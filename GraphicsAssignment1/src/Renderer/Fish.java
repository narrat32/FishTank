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

public class Fish {
	
	public int fishIndex;
	
	public Fish() {
		
	}
	
	public void createList(GL2 gl) {
		this.fishIndex = gl.glGenLists(9);
		
		boolean finRaised = true;
		double raiseY1 = 0.05;
		double raiseY2 = -0.05;
		
		if(finRaised == true) {
			raiseY1 -= 0.005;
			raiseY2 += 0.005;
			if(raiseY1 >= 0.07) {
				finRaised = false;
			}
			
		}
		
		else if(finRaised == false) {
			raiseY1 += 0.005;
			raiseY2 -= 0.005;
			if(raiseY1 <= 0.3)
			{
				finRaised = true;
			}
		}
		
		//body
	    gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	     for(int i = 0; i <= 300; i++){
	         double angle = 2 * Math.PI * i / 300;
	         double x = Math.cos(angle) / 22.5;
	         double y = Math.sin(angle) / 7.5;
	         gl.glColor3d(1, 0.5, 0);
	         gl.glVertex2d( x, y);
	         //gl.glColor3d(1, 0.76, .52);
	         //gl.glVertex2d( x, y);
	         
	         
	    }
	     gl.glEnd();
	     
	     //left fin
	     gl.glBegin(GL2.GL_QUADS);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(-0.03, 0);
		    gl.glVertex2d(-0.1, raiseY1);
		    gl.glVertex2d(-0.07, 0);
		    gl.glVertex2d(-0.1, raiseY2);
		    gl.glEnd();
		    
		    //right fin
		    gl.glBegin(GL2.GL_QUADS);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(0.03, 0);
		    gl.glVertex2d(0.1, -0.05);
		    gl.glVertex2d(0.07, 0);
		    gl.glVertex2d(0.1, 0.05);
		    gl.glEnd();
	     
	     //left eye
	     gl.glBegin(GL2.GL_TRIANGLE_FAN);
			//gl.glEnable(GL2.GL_BLEND);
			//gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor3d(1, 0.5, 0);
		     for(int i = 0; i <= 300; i++){
		         double angle = 2 * Math.PI * i / 300;
		         double x = Math.cos(angle) / 40;
		         double y = Math.sin(angle) / 15;
		         gl.glVertex2d( x - 0.04, y + 0.05);
		         gl.glColor3d(1, 1, 1);
		         
		    }
		    gl.glEnd();
		    
		    //right eye
		    gl.glBegin(GL2.GL_TRIANGLE_FAN);
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor3d(1, 0.5, 0);
		     for(int i = 0; i <= 300; i++){
		         double angle = 2 * Math.PI * i / 300;
		         double x = Math.cos(angle) / 40;
		         double y = Math.sin(angle) / 15;
		         gl.glVertex2d( x + 0.04, y + 0.05);
		         gl.glColor3d(1, 1, 1);
		         
		    }
		    gl.glEnd();
		    
		    //right pupil
		    gl.glBegin(GL2.GL_TRIANGLE_FAN);
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor3d(1, 0.5, 0);
		     for(int i = 0; i <= 300; i++){
		         double angle = 2 * Math.PI * i / 300;
		         double x = Math.cos(angle) / 50;
		         double y = Math.sin(angle) / 25;
		         gl.glVertex2d( x + 0.04, y + 0.05);
		         gl.glColor3d(0, 0, 0);
		         
		    }
		    gl.glEnd();
		    
		    //left pupil
		    gl.glBegin(GL2.GL_TRIANGLE_FAN);
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor3d(1, 0.5, 0);
		     for(int i = 0; i <= 300; i++){
		         double angle = 2 * Math.PI * i / 300;
		         double x = Math.cos(angle) / 50;
		         double y = Math.sin(angle) / 25;
		         gl.glVertex2d( x - 0.04, y + 0.05);
		         gl.glColor3d(0, 0, 0);
		         
		    }
		    gl.glEnd();
		    
		    //mouth
		    gl.glBegin(GL2.GL_TRIANGLE_FAN);
			gl.glEnable(GL2.GL_BLEND);
			gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
			gl.glColor3d(1, 0.5, 0);
		     for(int i = 0; i <= 300; i++){
		         double angle = 2 * Math.PI * i / 300;
		         double x = Math.cos(angle) / 40;
		         double y = Math.sin(angle) / 70;
		         gl.glVertex2d( x, y - 0.04);
		         gl.glColor3d(1, 1, 1);
		         
		    }
		    gl.glEnd();
		    
		    //top fin
		    gl.glBegin(GL2.GL_TRIANGLES);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(0, 0.125);
		    gl.glVertex2d(0.025,  0.15);
		    gl.glVertex2d(-0.025,  0.15);
		    gl.glEnd();
		    
		    
		    
	    gl.glEndList();
	}
}
