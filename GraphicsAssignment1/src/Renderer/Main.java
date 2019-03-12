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

public class Main implements GLEventListener, MouseListener{
	private Water water;
	private Buttons buttons;
	private float positionX = 1;
	private float positionY = 0.9f;
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GLUT glut = new GLUT();
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//creates a blank bar for buttons
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(0.66, 0.66, 0.64);
		gl.glVertex2d(-1,1);
		gl.glVertex2d(1, 1);
		gl.glVertex2d(1, 0.9);
		gl.glVertex2d(-1, 0.9);
		gl.glEnd();
		
		
		//creates a blue background
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(0.73, 0.86, 0.91);
		//gl.glColor3d(1, 1, 1);
		gl.glVertex2d(-1, 0.9);
		gl.glVertex2d(1, 0.9);
		gl.glVertex2d(1, -0.75);
		gl.glVertex2d(-1, -0.75);
		gl.glEnd();
		
		//creates a rectangular sand area
		gl.glBegin(GL2.GL_POLYGON);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glColor3d(1, 0.98, 0.64);
		gl.glVertex2d(-1,-1);
		gl.glVertex2d(1, -1);
		gl.glColor3d(0.75, 0.74, 0.39);
		gl.glVertex2d(1, -0.75);
		gl.glVertex2d(-1, -0.75);
		gl.glEnd();
		//draws the overlaying water with animation
		water.draw(gl, positionX, positionY);
		buttons.draw(gl, glut);
		
		
		
	}
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		water = new Water();
		buttons = new Buttons();
	}
	
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		
	}


public static void main(String[] args) {
	Frame frame = new Frame("Fish Tank");
	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
	GLCanvas canvas = new GLCanvas(capabilities);
	Main background = new Main();
	canvas.addGLEventListener(background);
	frame.add(canvas);
	frame.setSize(650, 600);
	final Animator animator = new Animator(canvas);
	
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			new Thread(new Runnable() {
				public void run() {
					animator.stop();
					System.exit(0);
				}
			}).start();
		}
	});
	
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	canvas.requestFocusInWindow();
	}

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
