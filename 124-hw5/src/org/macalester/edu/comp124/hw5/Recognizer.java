package org.macalester.edu.comp124.hw5;

import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import comp124graphics.GraphicsGroup;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Recognizer to recognize 2D gestures. Uses the $1 gesture recognition algorithm.
 */
public class Recognizer {
    private List<Template> templates=new ArrayList<>();
    final int N=64;
    final int SIZE=250;

    /**
     * Constructs a recognizer object
     */
    public Recognizer(){
    }

    /**
     * Create a template to use for matching
     * @param name of the template
     * @param points in the template gesture's path
     */
    public void addTemplate(String name, List<Point> points){
        List<Point> normalizedPoints=normalize(points);
        Template template=new Template(name, normalizedPoints);
        templates.add(template);
    }

    private List<Point> normalize (List<Point> points){
        List<Point> resampledPoints=resample(points, N);
        double x=findIndicativeAngle(resampledPoints);
        List <Point> rotatedPoints=rotateTo(resampledPoints, -x);
        List<Point> scaledPoints=scaleToSquare(rotatedPoints, SIZE);
        Point origin=new Point(0,0);
        List<Point> normalizedPoints=translateToPoint(scaledPoints, origin);
        return normalizedPoints;
    }

    protected Match recognize(List<Point> gesture){
        double minimumDistance=Double.POSITIVE_INFINITY;
        Template bestTemplate=null;
        List<Point> normalizedGesture;
        normalizedGesture=normalize(gesture);
        if(templates!=null){
            for(Template template : templates){
                double distance=distanceAtBestAngle(normalizedGesture, template.getPoints());
                if(distance<minimumDistance){
                    minimumDistance=distance;
                    bestTemplate=template;
                }
            }
        }
        double score=calculateScore(minimumDistance);
        return new Match(bestTemplate, score);
    }

    private double calculateScore(double distance){
        double sizeSquared=SIZE*SIZE;
        return 1-distance/(.5*(Math.sqrt(sizeSquared+sizeSquared)));

    }

    /**
     * Uses a golden section search to calculate rotation that minimizes the distance between the gesture and the template points.
     * @param points
     * @param templatePoints
     * @return best distance
     */
    private double distanceAtBestAngle(List<Point> points, List<Point> templatePoints){
        double thetaA = -Math.toRadians(45);
        double thetaB = Math.toRadians(45);
        final double deltaTheta = Math.toRadians(2);
        double phi = 0.5*(-1.0 + Math.sqrt(5.0));// golden ratio
        double x1 = phi*thetaA + (1-phi)*thetaB;
        double f1 = distanceAtAngle(points, templatePoints, x1);
        double x2 = (1 - phi)*thetaA + phi*thetaB;
        double f2 = distanceAtAngle(points, templatePoints, x2);
        while(Math.abs(thetaB-thetaA) > deltaTheta){
            if (f1 < f2){
                thetaB = x2;
                x2 = x1;
                f2 = f1;
                x1 = phi*thetaA + (1-phi)*thetaB;
                f1 = distanceAtAngle(points, templatePoints, x1);
            }
            else{
                thetaA = x1;
                x1 = x2;
                f1 = f2;
                x2 = (1-phi)*thetaA + phi*thetaB;
                f2 = distanceAtAngle(points, templatePoints, x2);
            }
        }
        return Math.min(f1, f2);
    }

    private double distanceAtAngle(List<Point> points, List<Point> templatePoints, double theta){
        List<Point> rotatedPoints = null;
        rotatedPoints = rotateTo(points, theta);
        return pathDistance(rotatedPoints, templatePoints);
    }

    private double pathDistance(List<Point> a, List<Point> b) {
        double pathDistance=0;
        for(int index=0; index<a.size(); index++){
            double length=a.get(index).distance(b.get(index));
            pathDistance+=length;
        }
        return pathDistance/a.size();
    }

    public List<Point> resample(List<Point> points, int n){
        List<Point> resampledPoints=new ArrayList<>(n);
        double pathLength=findPathLength(points);
        double resampleInterval=pathLength/(n-1);
        resampledPoints.add(points.get(0));
        double accumulatedDistance=0;
        for(int index=0; index<(points.size()-1); index++){
            Point currentPoint=points.get(index);
            Point nextPoint=points.get(index+1);
            double segmentDistance=currentPoint.distance(nextPoint);
            accumulatedDistance=accumulatedDistance+segmentDistance;
            if(accumulatedDistance>resampleInterval){
                Point location=Point.interpolate(currentPoint, nextPoint,(resampleInterval-(accumulatedDistance-segmentDistance))/segmentDistance);
                resampledPoints.add(location);
                points.add((index+1), location);
                accumulatedDistance=0;
            }
        }
        if(resampledPoints.size()!=n){
            resampledPoints.add(points.get(points.size()-1));
        }
        return resampledPoints;
    }

    protected double findPathLength(List<Point> points){
        double pathLength=0;
        for(int x=1; x<points.size(); x++){
            double length=points.get(x).distance(points.get(x-1));
            pathLength+=length;
        }
        return pathLength;
    }

    protected List<Point> rotateTo(List<Point> points, double theta){
        List<Point> newPoints=new ArrayList<> (points.size());
        Point centroid=findCentroid(points);
        for(Point point : points){
            newPoints.add(point.rotate(theta, centroid));
        }
        return newPoints;
    }

    protected double findIndicativeAngle(List<Point> points){
        Point centroid=findCentroid(points);
        double angle=centroid.subtract(points.get(0)).angle();
        return angle;
    }

    protected Point findCentroid(List<Point> points){
        double totalX=0;
        double totalY=0;
        for(Point point : points){
            totalX+=point.getX();
            totalY+=point.getY();
        }
        double avgX=totalX/points.size();
        double avgY=totalY/points.size();

        return new Point(avgX, avgY);
    }

    protected List<Point> scaleToSquare(List<Point> points, int size){
        List<Point> newPoints=new ArrayList<>(points.size());
        Point boundingBox=calculateBoundingBox(points);
        double width=boundingBox.getX();
        double height=boundingBox.getY();
        for(Point point : points){
            newPoints.add(point.scale(size/width, size/height));
        }
        return newPoints;
    }

    protected Point calculateBoundingBox(List<Point> points){
        Point max=points.get(0);
        Point min=points.get(0);
        for(Point point : points){
            max=Point.max(max, point);
            min=Point.min(min, point);
        }
        return new Point(max.getX()-min.getX(), max.getY()-min.getY());
    }

    protected List<Point> translateToPoint(List<Point> points, Point origin){
        Point centroid=findCentroid(points);
        List<Point> newPoints=new ArrayList<>(points.size());
        for(Point point : points){
            newPoints.add(point.add(origin).subtract(centroid));
        }
        return newPoints;
    }
}