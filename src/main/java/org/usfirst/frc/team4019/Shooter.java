package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Shooter {
	enum ShooterMode {CONSTANT, DYNAMIC, MANUAL, DISABLED}

	CANTalon leftMotor;
	CANTalon rightMotor;
	ShooterMode mode;

	public Shooter(int leftID, int rightID) {
		this.leftMotor = new CANTalon(leftID);
		this.rightMotor = new CANTalon(rightID);
		this.leftMotor.setInverted(Constants.shooter.leftInverted);
		this.rightMotor.setInverted(Constants.shooter.rightInverted);
		this.mode = ShooterMode.DISABLED;
	}

	public void constant() {
		this.leftMotor.set(Constants.shooter.constantSpeed);
		this.rightMotor.set(Constants.shooter.constantSpeed);
		this.mode = ShooterMode.CONSTANT;
		this.setDashboard(1);
	}

	public void dynamic() {
		double value = Physics.angular(Vision.boilerDistance) * Constants.shooter.coefficient;
		this.leftMotor.set(value);
		this.rightMotor.set(value);
		this.mode = ShooterMode.DYNAMIC;
		this.setDashboard(value);
	}

	public void set(double value) {
		this.leftMotor.set(value * Constants.shooter.manualSpeed);
		this.rightMotor.set(value * Constants.shooter.manualSpeed);
		this.mode = ShooterMode.MANUAL;
		this.setDashboard(value);
	}

	public void stop() {
		this.leftMotor.set(0);
		this.rightMotor.set(0);
		this.mode = ShooterMode.DISABLED;
		this.setDashboard(0);
	}

	public void setDashboard(double value) {
		Dashboard.write(Constants.shooter.dashboard, "Shooter: " + this.mode + " @ " + Math.round(value * 100) + "%");
	}
}