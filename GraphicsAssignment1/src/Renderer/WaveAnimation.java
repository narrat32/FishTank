
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
	private float waveX[] = {-1f, -0.75f, -0.5f, -0.25f, -0f, 0.25f, 0.5f ,0.75f, 1f};
	private float waveY[] = {};
	public void draw(GL2 gl) {
		/*gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);*/
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glColor3d(1, 0, 0);
		gl.glVertex2d(waveX[0], 0.5);
		gl.glVertex2d(waveX[1], 0.5);
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
