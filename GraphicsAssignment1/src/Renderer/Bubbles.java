package Renderer;

import java.util.ArrayList;

public class Bubbles {
	public double bubbleXLocation, y;
	public double bubbleSize, bubbleMovement;
	public double age;
	public double ageMax;
	
	public Bubbles(double x, double y) {
		this(x, y, x*3, y*3);
	}
	
	public Bubbles(double bubbleXLocation, double y, double bubbleSize, double bubbleMovement) {
		this.bubbleXLocation = bubbleXLocation;
		this.y = y;
		this.bubbleSize = bubbleSize;
		this.bubbleMovement = bubbleMovement;
		this.age = 0.0f;
		this.ageMax = 1.0f + (double)Math.random() * 10;
	}
}
