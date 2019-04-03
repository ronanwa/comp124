package edu.macalester.comp124.critters;

import comp124graphics.*;
import comp124graphics.Rectangle;

import java.awt.Color;


public class Mario extends Critter {
	private static final Color strokeColor = new Color(0, 0, 255);
	private static final Color fillColor = strokeColor;

	@Override
	protected void buildGraphics() {

		Rectangle leftLeg  = new Rectangle(21, 73.5, 12.5, 25.7);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 4));

        Rectangle rightLeg  = new Rectangle(35, 73.5, 12.5, 25.7);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 4));

		Image mario = CritterUtils.loadCritterImage("Mario.png");
		getGraphics().add(mario);

		addEye(new Eye(3.6, 0.26, 0.18, Color.RED), 31, 26);
        addEye(new Eye(3.6, 0.26, 0.18, Color.RED), 40, 26);
	}
}
