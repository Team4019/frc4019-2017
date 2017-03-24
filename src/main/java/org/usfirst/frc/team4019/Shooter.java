package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Shooter {
	enum ShooterMode {CONSTANT, DYNAMIC, MANUAL, DISABLED}

	CANTalon motor;
	ShooterMode mode;

	public Shooter(int ID) {
		this.motor = new CANTalon(ID);
		this.motor.setInverted(Constants.shooter.inverted);
		this.mode = ShooterMode.DISABLED;
	}

	public void constant() {
		this.motor.set(Constants.shooter.constantSpeed);
		this.mode = ShooterMode.CONSTANT;
		this.setDashboard(1);
	}

	public void dynamic() {
		double value = Physics.angular(Vision.boilerDistance) * Constants.shooter.coefficient;
		this.motor.set(value);
		this.mode = ShooterMode.DYNAMIC;
		this.setDashboard(value);
	}

	public void set(double value) {
		this.motor.set(value * Constants.shooter.manualSpeed);
		this.mode = ShooterMode.MANUAL;
		this.setDashboard(value);
	}

	public void stop() {
		this.motor.set(0);
		this.mode = ShooterMode.DISABLED;
		this.setDashboard(0);
	}

	public void setDashboard(double value) {
		Dashboard.write(Constants.shooter.dashboard, "Shooter: " + this.mode + " @ " + Math.round(value * 100) + "%");
	}
}