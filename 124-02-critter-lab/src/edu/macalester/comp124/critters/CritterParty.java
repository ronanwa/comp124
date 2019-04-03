package edu.macalester.comp124.critters;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsObject;
import org.reflections.Reflections;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Paul Cantrell
 */
public class CritterParty {
    
    private static final double TARGET_FPS = 30, MIN_EFFECTIVE_FPS = 5;
    
    private final Random rand = new Random();
    private List<Class<? extends Critter>> critterClasses;
    private List<Critter> critters;
    private CanvasWindow canvas;
    
    @SuppressWarnings("InfiniteLoopStatement")
    public CritterParty(){
        canvas = new CanvasWindow("Critters", 2500, 1680);
        loadCritterClasses();
        critters = new ArrayList<Critter>();
        for(int n = 0; n < 50; n++)
            addNewCritter();
        
        long prevFrameTime = 0;
        while(true) {
            long frameTime = System.currentTimeMillis();
            double dt = Math.min(1 / MIN_EFFECTIVE_FPS, (frameTime - prevFrameTime) / 1000.0);
            
            moveCritters(dt);
            
            prevFrameTime = frameTime;
            canvas.pause(1000 / TARGET_FPS);
        }
    }

    private void addNewCritter() {
        Critter critter = createRandomCritter();
        
        GraphicsObject g = critter.getGraphics();
        Point.Double point = randLocationFor(critter);
        g.setPosition(point.getX(), point.getY());
        chooseNewGoal(critter);
        critter.setSpeed(rand.nextDouble() * 20 + 10);
        
        canvas.add(critter.getGraphics());
        critters.add(critter);
    }
    
    private Critter createRandomCritter() {
        Class<? extends Critter> critterClass = critterClasses.get(rand.nextInt(critterClasses.size()));
        try {
            return critterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate " + critterClass, e);
        }
    }

    private void moveCritters(double dt) {
        for(Critter critter : critters) {
            critter.moveTowardsGoal(dt);
            
            // Near our goal? Just time to go somewhere else? Pick a new direction!
            double distToGoal = Math.hypot(
                critter.getGoal().getX() - critter.getGraphics().getX(),
                critter.getGoal().getY() - critter.getGraphics().getY());
            if(distToGoal < critter.getSize() || rand.nextDouble() < dt / 10)
                chooseNewGoal(critter);
        }
    }
    
    /**
     * Finds all subclasses of Critter in this package.
     */
    private void loadCritterClasses() {
        Reflections reflections = new Reflections(getClass().getPackage().getName());
        critterClasses = new ArrayList<Class<? extends Critter>>(
            reflections.getSubTypesOf(Critter.class));
    }

    /**
     * Sends the critter off in a new direction.
     */
    private void chooseNewGoal(Critter critter) {
        critter.setGoal(randLocationInRange(critter.getGraphics()));
    }
    
    /**
     * Picks a random location that will approximately fit the given graphics object within the window.
     */
    private Point.Double randLocationFor(Critter critter) {
        GraphicsObject g = critter.getGraphics();
        Rectangle bounds = g.getBounds();
        return new Point2D.Double(
            rand.nextDouble() * (canvas.getWidth()  - (bounds.getWidth() + critter.getxOffset())),
            rand.nextDouble() * (canvas.getHeight() - (bounds.getHeight() + critter.getyOffset()))
            );
    }

    private Point.Double randLocationInRange(GraphicsObject g) {
        double maxRange = 500.0;
        Rectangle bounds = g.getBounds();
        Point.Double p0 = g.getPosition();
        double dx = rand.nextDouble() * (2.0 *maxRange) - maxRange;
        double dy = rand.nextDouble() * (2.0 * maxRange) - maxRange;
        Point.Double p = new Point.Double(p0.getX()+dx, p0.getY()+dy);
        p.setLocation(Math.max(0.0, Math.min(p.getX(), canvas.getWidth() - bounds.getWidth())), Math.max(0.0, Math.min(p.getY(), canvas.getHeight() - bounds.getHeight())));
        return p;
    }

    public static void main(String[] args){
        CritterParty prog = new CritterParty();
    }
}
