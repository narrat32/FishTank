	package Renderer;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.lang.Math;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

public class Pump {
	
	public int pumpIndex;
	public Pump() {
		
	}
	
	public void createList(GL2 gl) {
		this.pumpIndex = gl.glGenLists(3);
		
		gl.glNewList(pumpIndex, GL2.GL_COMPILE);
		
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(.66, .67, .68);
		gl.glVertex2d(0.6, -0.75);
		gl.glVertex2d(0.8, -0.75);
		gl.glVertex2d(0.8, -0.55);
		gl.glVertex2d(0.6, -0.55);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
	     for(int i = 0; i <= 50; i++){
	         double angle = 2 * Math.PI * i / 100;
	         double x = Math.cos(angle) / 10;
	         double y = Math.sin(angle) / 14;
	         gl.glVertex2d(x + .7,y - .55);
	     }
	    gl.glEnd();
	    
	    gl.glBegin(GL2.GL_TRIANGLE_FAN);
	     for(int i = 0; i <= 100; i++){
	         double angle = 2 * Math.PI * i / 50;
	         double x = Math.cos(angle) / 10;
	         double y = Math.sin(angle) / 14;
	         gl.glVertex2d(x + .7,y - .75);
	     }
	    gl.glEnd();
	    
	    gl.glEndList();
	}
}
