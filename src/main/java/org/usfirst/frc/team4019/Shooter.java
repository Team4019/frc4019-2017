package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Shooter {
	CANTalon leftWheel;
	CANTalon rightWheel;

	public Shooter(int leftTalonID, int rightTalonID) {
		this.leftWheel = new CANTalon(leftTalonID);
		this.rightWheel = new CANTalon(rightTalonID);
		this.leftWheel.setInverted(true);
	}

	public void set(double value) {
		this.leftWheel.set(value * Constants.shooter.speed);
		this.rightWheel.set(value * Constants.shooter.speed);
	}

	public void stop() {
		this.leftWheel.set(0);
		this.rightWheel.set(0);
	}
}
