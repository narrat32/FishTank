package Renderer;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class BubbleSystem {
	
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
		gl.glPointSize(4.0f);
		gl.glBegin(GL2.GL_POINTS);
		for(Bubbles b : bubble) {
			double f = b.age / b.ageMax;
			gl.glColor4d(1,  1 - f, 0, 1.0 - f);
			gl.glVertex2d(b.x, b.y);
		}
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
	}
}
