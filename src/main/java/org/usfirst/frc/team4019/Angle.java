package org.usfirst.frc.team4019;

public class Angle {
	Double value;

	public Angle(Double value) {
		this.value = value;
	}

	public Angle(double value) {
		this.value = value;
	}

	double getRadians() {
		return Math.toRadians(this.value);
	}

	String getString() {
		if (this.value != null) {
			return Math.round(this.value) + " deg";
		} else {
			return "";
		}
	}
}