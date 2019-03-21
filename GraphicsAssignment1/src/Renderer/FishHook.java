package Renderer;

import com.jogamp.opengl.GL2;

public class FishHook {
	
	public boolean hookRaised;
	private double yRaise = 0.005;
	public double yValue = -0.05;
	
	public FishHook() {
		
	}
	
	public void draw(GL2 gl) {
		if(hookRaised == true && yValue <= 1.05) {
			yValue += yRaise;
		}
		if(hookRaised == false && yValue >= - 0.04){
			yValue -= yRaise;
		}
		
		gl.glBegin(GL2.GL_LINES);
		gl.glColor3d(0, 0, 0);
		gl.glVertex2d(0, yValue);
		gl.glVertex2d(0,  0.9);
		gl.glEnd();
	}
}
