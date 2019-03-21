package Renderer;

public class Blood {
	public double bloodXLocation, y;
	public double bloodSize, bloodMovement;
	public double age;
	public double ageMax;
	
	public Blood(double bloodXLocation, double y, double bloodSize, double bloodMovement) {
		this.bloodXLocation = bloodXLocation;
		this.y = y;
		this.bloodSize = bloodSize;
		this.bloodMovement = bloodMovement;
		this.age = 0.0f;
		this.ageMax = 1.0f + (double)Math.random() * 10;
	}
}
