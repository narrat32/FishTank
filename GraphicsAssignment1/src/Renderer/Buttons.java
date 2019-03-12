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


public class Buttons {
	
	public Buttons() {
		
	}
	
	public void draw(GL2 gl, GLUT glut) {
		
		
		//gl.glEnable(GL2.GL_BLEND);
		//gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(1, 1, 1);
		gl.glVertex2d(-0.98,0.98);
		gl.glVertex2d(-0.7, 0.98);
		gl.glVertex2d(-0.7, 0.9);
		gl.glVertex2d(-0.98, 0.9);
		
		gl.glEnd();
		
		gl.glColor3d(0, 1, 0);
		gl.glRasterPos2d(-.95, .92);
		glut.glutBitmapString(GLUT.BITMAP_8_BY_13, "Pump");
		
		
		
	}
}
