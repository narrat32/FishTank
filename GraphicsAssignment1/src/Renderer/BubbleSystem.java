package Renderer;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class BubbleSystem {
	
	private double bubbleMovement = 0.6;
	private boolean bubbleRising = true;
	private double transparency = 0.5;
	private ArrayList<Bubbles> bubble;
	
	public BubbleSystem() {
		bubble = new ArrayList<Bubbles>();
	}
	
	public void addParticle(double x, double y) {
		bubble.add(new Bubbles(x, y));
	}
	
	public void addParticle(double x, double y, double dx, double dy) {
		bubble.add(new Bubbles(x, y, dx, dy));
	}
	
	public void animate(double time) {
		for(Bubbles b: bubble) {
			b.age += time;
			
			b.x += b.dx * time;
			b.y += b.dy * time;
			
			
			}
		if(bubble.size() > 0) {
			Bubbles b = bubble.get(0);
			if(b.age > b.ageMax) {
				bubble.remove(b);
			}
		}
	}
	
	public void draw(GL2 gl) {
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		for(Bubbles b : bubble) {
			double f = b.age / b.ageMax;
			for(int i = 0; i <= 100; i++){
				gl.glColor4d(1, 1 - f, 1, transparency - f);
		        double angle = 2 * Math.PI * i / 50;
		        double x = Math.cos(angle) / 20;
		        double y = Math.sin(angle) / 20;
		        gl.glVertex2d(x + .7, y - bubbleMovement);
		        if(transparency == 0) {
		        	bubble.remove(b);
		        	System.out.println("bubble removed from transparency");
		        }
			}
			if(bubbleRising == true) {
				bubbleMovement -= 0.005;
			}
	        if (bubbleMovement >= 0.8) {
	        	bubble.remove(b);
	        	System.out.println("Bubble has been removed");
	        }
	       
		}
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
	}
}
