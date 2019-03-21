package Renderer;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Timer;
import java.util.TimerTask;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class Main implements GLEventListener, MouseListener{
	private Water water;
	private Buttons buttons;
	private Fish fish;
	private WaveAnimation wave;
	private Pump pump;
	private BubbleSystem bubbleSystem;
	private FishHook hook;
	private BloodSystem bloodSystem;
	private Harpoon harpoon;
	private int windowWidth = 650;
	private int windowHeight = 600;
	private double prevTick;
	
	
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GLUT glut = new GLUT();
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//creates a blue background
		gl.glBegin(GL2.GL_POLYGON);
		//gl.glColor3d(0.73, 0.86, 0.91);
		gl.glColor3d(0.12, 0.42, 0.91);
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
		
		//draws the harpoon
		harpoon.draw(gl);
		
		//draws the fish
		fish.draw(gl, hook);
		
		//draws the hook
		hook.draw(gl);
		
		//draws the pump
		pump.createList(gl);
		gl.glCallList(pump.pumpIndex);
		
		double tick = System.currentTimeMillis() / 1000.0;
		double time = tick - prevTick;
		if (prevTick > 0) {
			bubbleSystem.animate(time);
			bloodSystem.animate(time);
		}
		prevTick = tick;
		
		//draws the bubbles
		bubbleSystem.draw(gl);
		
		//draws blood
		bloodSystem.draw(gl);
		
		
		//draws the overlaying water
		water.draw(gl);
		
		//adds a wave to the top of the water
		wave.draw(gl);
		
		//creates a blank bar for buttons
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3d(0.66, 0.66, 0.64);
		gl.glVertex2d(-1,1);
		gl.glVertex2d(1, 1);
		gl.glVertex2d(1, 0.9);
		gl.glVertex2d(-1, 0.9);
		gl.glEnd();
				
		
		//draws the button and adds functionality
		buttons.drawButtonOne(gl, glut);
		buttons.drawButtonTwo(gl, glut);
		
		
		
	
	}
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.setSwapInterval(1);
		gl.glShadeModel(GL2.GL_SMOOTH);
		pump = new Pump();
		fish = new Fish();
		water = new Water();
		buttons = new Buttons();
		wave = new WaveAnimation();
		hook = new FishHook();
		bubbleSystem = new BubbleSystem();
		bloodSystem = new BloodSystem();
		harpoon = new Harpoon();
		prevTick = 0;
		
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
	final FPSAnimator animator = new FPSAnimator(canvas, 60);
	
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

public void createBubbles() {
	double bubbleXLocation = (Math.random() * 0.2) + 0.6; 
	double circleSize = (Math.random() * 20) + 20;
	bubbleSystem.addParticle(bubbleXLocation, -0.6, circleSize, 0.7);

	System.out.println("Particle created");
}

public void createBlood() {
	double bloodXLocation = (Math.random() * 0); 
	double circleSize = (Math.random() * 20) + 20;
	bloodSystem.addParticle(bloodXLocation, 0, circleSize, 0.7);
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
public void mouseReleased(MouseEvent e){
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
		System.out.println("Pump is on!");
			if(buttons.buttonOneOn == false) {
				buttons.buttonOneOn = true;
				bubbleSystem.bubbles.clear();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						while(buttons.buttonOneOn == true) {
							try {
								createBubbles();
								break;
							}
							catch(Exception ex) {}
						}	
					}
				};
			Timer timer = new Timer();
			timer.schedule(task,  1, 100);
			bubbleSystem.bubbles.clear();
			
			}
		else if(buttons.buttonOneOn == true){
			buttons.buttonOneOn = false;
			System.out.println("Pump is off!");
			System.out.println("Array size "+bubbleSystem.bubbles.size());
			bubbleSystem.bubbles.clear();
		
			System.out.println("Bubbles removed!");
			}
		}
		else if(openglX >= -.65 && openglY <= 0.98 && openglX <= -0.37 && openglY >= 0.91) {
			if(buttons.buttonTwoOn == false) {
				buttons.buttonTwoOn = true;
				hook.hookRaised = true;
			}
			else if(buttons.buttonTwoOn == true) {
				buttons.buttonTwoOn = false;
				hook.hookRaised = false;
			}
		}
	
		else if(openglX >= -1 && openglY <= 0.01 && openglX <= -0.5 && openglY >= -0.01) {
			harpoon.isClicked = true;
			if(harpoon.pierceX2 <= 0) {
				System.out.println(+harpoon.handleX1+" "+harpoon.handleX2);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						while(harpoon.pierceX2 >= 0) {
							try {
								createBlood();
								break;
							}
							catch(Exception ex) {}
						}	
					}
				};
			Timer timer = new Timer();
			timer.schedule(task,  1, 100);
			}
			else if(openglX >= -1 && openglY <= 0.01 && openglX <= -0.5 && openglY >= -0.01) {
				System.out.println("This is hit");
				harpoon.isClicked = false;
			}
		}
		else {
			System.out.println("Out of bounds");
		}
	}

}
