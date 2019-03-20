package Renderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.jogamp.opengl.GL2;

public class BubbleSystem {
	
	private double transparency = 0.5;
	//public ArrayList<Bubbles> bubbles;
	public List<Bubbles> bubbles = Collections.synchronizedList(new ArrayList<Bubbles>());
	
	public BubbleSystem() {
		bubbles = new ArrayList<Bubbles>();
		
	}
	
	public void addParticle(double x, double y) {
		bubbles.add(new Bubbles(x, y));
	}
	
	public void addParticle(double x, double y, double dx, double dy) {
		bubbles.add(new Bubbles(x, y, dx, dy));
	}
	
	public void animate(double time) {
		for(Bubbles b: bubbles) {
			b.age += time;
			
			b.y += b.bubbleMovement * time;
			
			b.bubbleSize += 0.05;
		}		
	
		if(bubbles.size() > 0) {
			Bubbles b = bubbles.get(0);
			//removes bubble 
			if(b.age > b.ageMax) {
				bubbles.remove(b);
				System.out.println("bubble removed");
			}
			//remove bubble if water level is reached
			if(bubbles.size() > 25) {
				bubbles.remove(b);
				System.out.println("Array is too large!");
			}
			if(b.y > 0.8) {
				bubbles.remove(b);
				System.out.println("Bubble Removed");
			}
		}
	}
	
	public void draw(GL2 gl) {
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
				
		for(Bubbles b : bubbles) {
			double f = b.age / b.ageMax;
			gl.glBegin(GL2.GL_TRIANGLE_FAN);
			for(int i = 0; i <= 100; i++){
				
				gl.glColor4d(1, 1 - f, 1, transparency - f);
		        double angle = 2 * Math.PI * i / 50;
		        double x = Math.cos(angle) / b.bubbleSize;
		        double y = Math.sin(angle) / b.bubbleSize;
		        gl.glVertex2d(x + b.bubbleXLocation, y + b.y);
			}
			gl.glEnd();
		}
		
		gl.glDisable(GL2.GL_BLEND);
	}
}
