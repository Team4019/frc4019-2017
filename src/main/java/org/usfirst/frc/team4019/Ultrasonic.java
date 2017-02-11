package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasonic {
	int port;
	int starboard;
	AnalogInput analogInputPort;
	AnalogInput analogInputStarboard;
	double voltsToFeet = 106.8521880907391270985;
	boolean posNeg;
	public Ultrasonic(int port, int starboard) {
		this.port = port;
		this.starboard = starboard;
		this.analogInputPort = new AnalogInput(this.port);
		this.analogInputStarboard = new AnalogInput(this.starboard);
	}

	public double getDistance() {
		double averageVoltage = (this.analogInputPort.getVoltage() + this.analogInputStarboard.getVoltage()) / 2;
		double distanceFeet = averageVoltage * this.voltsToFeet;
		return averageVoltage;
	}

	public double getAngle() {
		System.out.println("Hello Cooper");
		double portInput = this.analogInputPort.getVoltage();
		double starboardInput = this.analogInputStarboard.getVoltage();
		double oppositeLine = 0.0;
		if (portInput < starboardInput){
			posNeg = true;
			oppositeLine = starboardInput - portInput;
		}
		else if (portInput > starboardInput){
			oppositeLine = portInput - starboardInput;
		}
		return Math.atan(oppositeLine/Constants.ultrasonic.spread);

	}
}