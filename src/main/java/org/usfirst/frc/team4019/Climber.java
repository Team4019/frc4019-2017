package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Climber {
	CANTalon leftMotor;
	CANTalon rightMotor;

	public Climber(int leftID, int rightID) {
		this.leftMotor = new CANTalon(leftID);
		this.rightMotor = new CANTalon(rightID);
		this.leftMotor.setInverted(Constants.climber.leftInverted);
		this.rightMotor.setInverted(Constants.climber.rightInverted);
	}

	public void set(double value) {
		this.leftMotor.set(value * Constants.climber.speed);
		this.rightMotor.set(value * Constants.climber.speed);
	}

	public void stop() {
		this.leftMotor.set(0);
		this.rightMotor.set(0);
	}

	public void setDashboard(boolean enabled, double axis) {
		Dashboard.write(Constants.climber.dashboard, "Climber: " + enabled + " @ " + Math.round(axis * 100) + "%");
	}
}