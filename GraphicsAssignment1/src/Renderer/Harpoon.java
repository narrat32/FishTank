package Renderer;

import com.jogamp.opengl.GL2;

public class Harpoon {
	public boolean isClicked = false;
	private double movementFactor = 0.02;
	public double handleX1 = -1;
	public double handleX2 = -0.5;
	private double pierceX1 = -0.5;
	public double pierceX2 = -0.45;
	
	
	public Harpoon() {
		
	}
	
	public void draw(GL2 gl) {
		
		if(isClicked == true && pierceX2 <= 0) {
			handleX1 += movementFactor;
			handleX2 += movementFactor;
			pierceX1 += movementFactor;
			pierceX2 += movementFactor;
		}
		
		else if(isClicked == false && pierceX2 >= -0.45) {
			handleX1 -= movementFactor;
			handleX2 -= movementFactor;
			pierceX1 -= movementFactor;
			pierceX2 -= movementFactor;
		}
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2d(handleX1,  -0.01);
		gl.glVertex2d(handleX2,  -0.01);
		gl.glVertex2d(handleX2,  0.01);
		gl.glVertex2d(handleX1,  0.01);
		gl.glEnd();
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glVertex2d(pierceX1,  0.03);
		gl.glVertex2d(pierceX2,  0);
		gl.glVertex2d(pierceX1,  -0.03);
		gl.glEnd();
		
	}
}
