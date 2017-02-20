package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasonic {
	int leftPort;
	int rightPort;
	AnalogInput leftInput;
	AnalogInput rightInput;
	double leftVoltage;
	double rightVoltage;
	final double voltsToFeet = 106.8521880907391270985;

	public Ultrasonic(int leftPort, int rightPort) {
		this.leftPort = leftPort;
		this.rightPort = rightPort;
		this.leftInput = new AnalogInput(this.leftPort);
		this.rightInput = new AnalogInput(this.rightPort);

	}

	public void update(){
		this.leftVoltage = this.leftInput.getVoltage();
		this.rightVoltage = this.rightInput.getVoltage();
	}

	public double getDistance() {
		double averageVoltage = (this.leftVoltage + this.rightVoltage) / 2;
		double distanceFeet = averageVoltage * this.voltsToFeet;
		return distanceFeet;
	}

	public boolean isObstucted(){
		if (this.getDistance() > 15){
			return false;
		}
		else {
			return true;
		}
		}
	}
	public boolean isObstructed(double range){
		if (this.getDistance()> range){
			return false;
		}
		else{
			return true;
		}
	}

	public double getAngle() {
		double leftVoltage = this.leftVoltage;
		double rightVoltage = this.rightVoltage;
		double oppositeLine = 0.0;
		if (leftVoltage < rightVoltage){
			oppositeLine = -1 * (rightVoltage - leftVoltage);
		}
		else if (leftVoltage > rightVoltage){
			oppositeLine = leftVoltage - rightVoltage;
		}
		return Math.atan(this.voltsToFeet * oppositeLine/Constants.ultrasonic.spread);

	}
}