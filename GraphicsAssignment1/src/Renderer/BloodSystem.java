package Renderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import com.jogamp.opengl.GL2;

public class BloodSystem {
	private double transparency = 0.5;
	public CopyOnWriteArrayList<Blood> blood;
	
	public BloodSystem() {
		blood = new CopyOnWriteArrayList<Blood>();
	}
	
	public void addParticle(double x, double y, double dx, double dy) {
		blood.add(new Blood(x, y, dx, dy));
	}
	
	public void animate(double time) {
		for (Blood b : blood) {
			b.age += time;
			
			b.y += b.bloodMovement * time;
			b.bloodSize += 0.05;
		}
		
		if(blood.size() > 0) {
			Blood b = blood.get(0);
			
			if(b.age > b.ageMax) {
				blood.remove(b);
			}
			
			if(b.y > 0.8) {
				blood.remove(b);
			}
			if(b.bloodSize > 50) {
				blood.remove(b);
			}
		}
	}
	
	public void draw(GL2 gl) {
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		
		for(Blood b : blood) {
			double f = b.age / b.ageMax;
			gl.glBegin(GL2.GL_TRIANGLE_FAN);
			for(int i = 0; i <= 100; i++) {
				gl.glColor4d(1 - f,  0,  0, transparency - f);
				double angle = 2 * Math.PI * i / 50;
				double x = Math.cos(angle) / b.bloodSize;
				double y = Math.sin(angle) / b.bloodSize;
				gl.glVertex2d(x + b.bloodXLocation, y + b.y);
			}
			gl.glEnd();
		}
		gl.glDisable(GL2.GL_BLEND);
	}
}
