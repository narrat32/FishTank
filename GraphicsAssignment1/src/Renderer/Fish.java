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
	private boolean finRaised = true;
	
	//fin Y values
	private double finRaiseY1 = 0.05;
	private double finRaiseY2 = -0.05;
	private double finRaiseY3 = 0;
	private double finRaiseY4 = 0;
	
	//eye y value
	private double eyeY = 0.05;
	
	//mouth y value
	private double mouthY = 0.04;
	
	//top fin y values
	private double topFinY1 = 0.125;
	private double topFinY2 = 0.15;
	
	//body y value
	private double bodyY = 0;
	
	public Fish() {
		
	}
	
	public void draw(GL2 gl, FishHook hook) {
		if(finRaised == true) {
			finRaiseY1 += 0.0005;
			finRaiseY2 += 0.0005;
			finRaiseY3 += 0.0005;
			if(finRaiseY1 >= bodyY + 0.09) {
				finRaised = false;
			}
		}
		if(finRaised == false) {
			finRaiseY1 -= 0.0005;
			finRaiseY2 -= 0.0005;
			finRaiseY3 -= 0.0005;
			if(finRaiseY1 <= bodyY - 0.01)
			{
				finRaised = true;
			}
		}
		
		if(hook.hookRaised == true && bodyY <= 1.1) {
			finRaiseY1 += 0.005;
			finRaiseY2 += 0.005;
			finRaiseY3 += 0.005;
			finRaiseY4 += 0.005;
			eyeY += 0.005;
			mouthY -= 0.005;
			topFinY1 += 0.005;
			topFinY2 += 0.005;
			bodyY += 0.005;
		}
		
		if(hook.hookRaised == false && bodyY >= 0) {
			finRaiseY1 -= 0.005;
			finRaiseY2 -= 0.005;
			finRaiseY3 -= 0.005;
			finRaiseY4 -= 0.005;
			eyeY -= 0.005;
			mouthY += 0.005;
			topFinY1 -= 0.005;
			topFinY2 -= 0.005;
			bodyY -= 0.005;
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
	         gl.glVertex2d( x, y + bodyY);
	         //gl.glColor3d(1, 0.76, .52);
	         //gl.glVertex2d( x, y);
	         
	         
	    }
	     gl.glEnd();
	     
	     //left fin
	     gl.glBegin(GL2.GL_QUADS);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(-0.03, finRaiseY4);
		    gl.glVertex2d(-0.1, finRaiseY1);
		    gl.glVertex2d(-0.07, finRaiseY3);
		    gl.glVertex2d(-0.1, finRaiseY2);
		    gl.glEnd();
		    
		    //right fin
		    gl.glBegin(GL2.GL_QUADS);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(0.03, finRaiseY4);
		    gl.glVertex2d(0.1, finRaiseY1);
		    gl.glVertex2d(0.07, finRaiseY3);
		    gl.glVertex2d(0.1, finRaiseY2);
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
		         gl.glVertex2d( x - 0.04, y + eyeY);
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
		         gl.glVertex2d( x + 0.04, y + eyeY);
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
		         gl.glVertex2d( x + 0.04, y + eyeY);
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
		         gl.glVertex2d( x - 0.04, y + eyeY);
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
		         gl.glVertex2d( x, y - mouthY);
		         gl.glColor3d(1, 1, 1);
		         
		    }
		    gl.glEnd();
		    
		    //top fin
		    gl.glBegin(GL2.GL_TRIANGLES);
		    gl.glEnable(GL2.GL_BLEND);
		    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		    gl.glColor3d(1, 1, 1);
		    gl.glVertex2d(0, topFinY1);
		    gl.glVertex2d(0.025,  topFinY2);
		    gl.glVertex2d(-0.025,  topFinY2);
		    gl.glEnd();
	}
}
