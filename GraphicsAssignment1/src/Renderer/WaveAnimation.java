
package Renderer;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;

public class WaveAnimation {
	private double waveX[] = {-1, -0.75, -0.5, -0.25, -0, 0.25, 0.5, 0.75, 1};
	private double y1 = 0.8;
	private double yLeftIncrease = 0.81;
	private double yRightIncrease = 0.81;
	private boolean waveIncreasing = true;

	public void draw(GL2 gl) {
		
		if(waveIncreasing == true) {
			yLeftIncrease -= 0.00005;
			if(yLeftIncrease <= 0.8) {
				waveIncreasing = false;
			}
		}
		
		else if(waveIncreasing == false) {
			yLeftIncrease += 0.00005;
			if(yLeftIncrease >= 0.84) {
				waveIncreasing = true;
			}
		}
		
		if(waveIncreasing == false) {
			yRightIncrease -= 0.00005;
			if(yRightIncrease <= 0.8) {
				waveIncreasing = true;
			}
		}
		
		else if(waveIncreasing == true) {
			yRightIncrease += 0.00005;
			if(yRightIncrease >= 0.84) {
				waveIncreasing = false;
			}
		}
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor4d(0.55, 0.82, 0.93, 0.5);
		
		for (int i = 0; i < 8; i += 2) {
			gl.glVertex2d(waveX[i], 0.8);
			gl.glVertex2d(waveX[i + 1], 0.8);
			gl.glVertex2d(waveX[i + 1], yRightIncrease);
			gl.glVertex2d(waveX[i], yLeftIncrease);
			
			gl.glVertex2d(waveX[i + 1], 0.8);
			gl.glVertex2d(waveX[i + 2], 0.8);
			gl.glVertex2d(waveX[i + 2], yLeftIncrease);
			gl.glVertex2d(waveX[i + 1], yRightIncrease);
		}
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
	}
}