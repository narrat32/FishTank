package Renderer;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

public class Pump {
	public Pump() {
		
	}
	
	public void draw(GL2 gl) {
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(1, 1, 1);
		gl.glVertex2d(0.6, -0.75);
		gl.glVertex2d(0.8, -0.75);
		gl.glVertex2d(0.8, -0.55);
		gl.glVertex2d(0.6, -0.55);
		gl.glEnd();
	}
}
