package Renderer;

import java.util.ArrayList;

public class Bubbles {
	public double x, y;
	public double dx, dy;
	public double age;
	public double ageMax;
	
	public Bubbles(double x, double y) {
		this(x, y, x*3, y*3);
	}
	
	public Bubbles(double x, double y, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.age = 0.0f;
		this.ageMax = 1.0f + (double)Math.random() * 10;
	}
}
