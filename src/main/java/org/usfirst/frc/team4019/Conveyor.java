package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Conveyor {
	CANTalon motor;

	public Conveyor(int talonID) {
		this.motor = new CANTalon(talonID);
	}

	public void set(double value) {
		this.motor.set(value * Constants.conveyor.speed);
	}

	public void stop() {
		this.motor.set(0);
	}
}
