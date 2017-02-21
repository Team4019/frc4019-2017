package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasonic {
	static private double voltsToFeet = 0.0093587227165699;

	AnalogInput analogInput;

	public Ultrasonic(int port) {
		this.analogInput = new AnalogInput(port);
	}

	Distance getDistance() {
		return new Distance(this.analogInput.getVoltage() / voltsToFeet);
	}

	Distance getRound() {
		return new Distance(Math.round(this.analogInput.getVoltage() / voltsToFeet));
	}
}