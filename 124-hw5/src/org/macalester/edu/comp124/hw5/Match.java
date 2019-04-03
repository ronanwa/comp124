package org.macalester.edu.comp124.hw5;

public class Match {
    private Template template;
    private double score;

    public Match(Template template, double score){
        this.template=template;
        this.score=score;
    }

    public Template getTemplate() {
        return template;
    }

    public double getScore() {
        return score;
    }
}
