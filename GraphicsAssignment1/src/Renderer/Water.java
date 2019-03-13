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

public class Water {
	
	public Water() {
		
	}
	
	public void draw(GL2 gl, float positionX, float positionY) {
		//positionX += 0.001;
		
		
		
		/*if(positionY >= 0.5) {
			positionY = 0.9f;
		}*/
				
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor4d(0.55, 0.82, 0.93, 0.5);
		gl.glVertex2d(-1, 0.9);
		//gl.glVertex2d(1, 0.9);
		gl.glVertex2d(1, 0.9);
		gl.glColor4d(0.25, 0.6, 0.8, 0.3);
		//gl.glColor4d(0.25, 0.43, 0.5, 0.3);
		gl.glVertex2d(1, -1);
		gl.glVertex2d(-1, -1);
		gl.glEnd();
	}
	
}
