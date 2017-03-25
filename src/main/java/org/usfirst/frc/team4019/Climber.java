package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Climber {
	enum ClimberMode {ENABLED, DISABLED}

	CANTalon leftMotor;
	CANTalon rightMotor;
	ClimberMode mode;

	public Climber(int leftID, int rightID) {
		this.leftMotor = new CANTalon(leftID);
		this.rightMotor = new CANTalon(rightID);
		this.leftMotor.setInverted(Constants.climber.leftInverted);
		this.rightMotor.setInverted(Constants.climber.rightInverted);
		this.mode = ClimberMode.DISABLED;
	}

	public void set(double value) {
		this.leftMotor.set(value * Constants.climber.speed);
		this.rightMotor.set(value * Constants.climber.speed);
		this.mode = ClimberMode.ENABLED;
		this.setDashboard(value * Constants.climber.speed);
	}

	public void stop() {
		this.leftMotor.set(0);
		this.rightMotor.set(0);
		this.mode = ClimberMode.DISABLED;
		this.setDashboard(0);
	}

	public void setDashboard(double value) {
		Dashboard.write(Constants.climber.dashboard, "Climber: " + this.mode + " " + Math.round(value * 100) + "%");
	}
}