
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
	private double y1 = 0.5;
	private double y2 = 0.5;
	private boolean waveIncreasing = true;
	private double yIncrease = 0.1;
	private double yDecrease = -0.1;
	public void draw(GL2 gl) {
		/*gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);*/
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glColor3d(1, 0, 0);
		
		if(waveIncreasing == true) {
			y1 += 0.0005;
			if(y1 >= 1) {
				waveIncreasing = false;
			}
		}
		else if(waveIncreasing == false) {
			y1 -= 0.0005;
			if(y1 <= 0) {
				waveIncreasing = true;
			}
		}
		gl.glVertex2d(waveX[0], y1);
		
		if(waveIncreasing == true) {
			y2 -= 0.0005;
			if(y2 <= 0) {
				waveIncreasing = false;
			}
		}
		else if(waveIncreasing == false) {
			y2 += 0.0005;
			if(y2 >= 1) {
				waveIncreasing = true;
			}
		}
		gl.glVertex2d(waveX[1], y2);
		
		gl.glColor3d(0, 1, 0);
		gl.glVertex2d(waveX[2], 0.5);
		gl.glVertex2d(waveX[3], 0.5);
		gl.glColor3d(0, 0, 1);
		gl.glVertex2d(waveX[4], 0.5);
		gl.glVertex2d(waveX[5], 0.5);
		gl.glColor3d(1, 0, 0);
		gl.glVertex2d(waveX[6], 0.5);
		gl.glVertex2d(waveX[7], 0.5);
		gl.glColor3d(0, 1, 0);
		gl.glVertex2d(waveX[8], 0.5);
		gl.glEnd();
	}
}
