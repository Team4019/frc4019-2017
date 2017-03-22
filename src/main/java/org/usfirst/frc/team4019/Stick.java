package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Joystick;

public class Stick extends Joystick {
	public Stick(int port) {
		super(port);
	}
	protected Stick(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
	}
	public double horizontal() {
		return this.getX();
	}
	public double vertical() {
		return -this.getY();
	}
	public double rotation() {
		double center = -0.16;
		double deadzone = 0.2;
		double twist = this.getTwist();
		return twist >= center ? Range.spread(twist, center + deadzone, 1) : Range.spread(twist, -1, center - deadzone) - 1;
	}
	public double throttle() {
		return this.getThrottle() / -2 + 0.5;
	}
	public boolean button(int value) {
		return this.getRawButton(value);
	}
}