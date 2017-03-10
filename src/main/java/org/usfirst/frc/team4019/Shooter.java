package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Shooter {
	enum ShootingMode {ENABLED, DISABLED}

	CANTalon leftWheel;
	CANTalon rightWheel;
	ShootingMode shooting;

	public Shooter(int leftTalonID, int rightTalonID) {
		this.leftWheel = new CANTalon(leftTalonID);
		this.rightWheel = new CANTalon(rightTalonID);
		this.leftWheel.setInverted(Constants.shooter.leftInverted);
		this.rightWheel.setInverted(Constants.shooter.rightInverted);
		this.shooting = ShootingMode.DISABLED;
	}

	public void set(double value) {
		this.leftWheel.set(value * Constants.shooter.speed);
		this.rightWheel.set(value * Constants.shooter.speed);
		this.shooting = ShootingMode.ENABLED;
		this.setDashboard(value);
	}

	public void stop(double value) {
		if (this.shooting != ShootingMode.DISABLED) {
			this.leftWheel.set(0);
			this.rightWheel.set(0);
			this.shooting = ShootingMode.DISABLED;
		}
		this.setDashboard(value);
	}

	public void setDashboard(double value) {
		Dashboard.write(Constants.shooter.dashboard, "Shooter: " + this.shooting + " @ " + Math.round(value * 100) + "%");
	}
}