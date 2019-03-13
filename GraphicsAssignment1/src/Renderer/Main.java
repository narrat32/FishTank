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
	private WaveAnimation wave;
	private Pump pump;
	private float positionX = 1;
	private float positionY = 0.9f;
	private int windowWidth = 650;
	private int windowHeight = 600;
	
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
		
		//draws the pump
		pump.draw(gl);
		
		//draws the overlaying water
		water.draw(gl, positionX, positionY);
		
		//draws the button and adds functionality
		buttons.draw(gl, glut);
		
		//adds a wave to the top of the water
		wave.draw(gl);
	}
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		pump = new Pump();
		water = new Water();
		buttons = new Buttons();
		wave = new WaveAnimation();
		GL2 gl = drawable.getGL().getGL2();
		gl.setSwapInterval(1);
		gl.glShadeModel(GL2.GL_SMOOTH);
	}
	
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		windowWidth = width;
		windowHeight = height;
	}


public static void main(String[] args) {
	Frame frame = new Frame("Fish Tank");
	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
	GLCanvas canvas = new GLCanvas(capabilities);
	Main background = new Main();
	canvas.addGLEventListener(background);
	canvas.addMouseListener(background);
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
	
	animator.start();
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
public void mouseReleased(MouseEvent e) {
	float mouseX = e.getX();
	float mouseY = e.getY();
	mouseY = windowHeight - mouseY;
	float openglX = 2.0f * (mouseX / windowWidth) - 1.0f;
	float openglY = 2.0f * (mouseY / windowHeight) - 1.0f;
	if (e.getButton() == 1){
	System.out.println("Click "+openglX+" "+openglY);
	}
	if(openglX >= -.98 && openglY <= 0.98 && openglX <= -0.7 && openglY >= 0.91) {
	System.out.println("In bounds");
	if(buttons.buttonOn == false) {
	buttons.buttonOn = true;
	System.out.println("Pump is on!");
	}
	else if(buttons.buttonOn == true){
	buttons.buttonOn = false;
	System.out.println("Pump is off!");
	}
	}
	else {
	System.out.println("Out of bounds");
	}
}

}
