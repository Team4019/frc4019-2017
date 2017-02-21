package org.usfirst.frc.team4019;

public class Distance {
	Double value;

	public Distance(Double value) {
		this.value = value;
	}

	public Distance(double value) {
		this.value = value;
	}

	double getFeet() {
		return this.value / 12;
	}

	int getFeetRound() {
		return (int) Math.round(this.getFeet());
	}

	int getFeetFloor() {
		return (int) Math.floor(this.getFeet());
	}

	int getFeetCeil() {
		return (int) Math.ceil(this.getFeet());
	}

	double getInches() {
		return this.value % 12;
	}

	int getInchesRound() {
		return (int) Math.round(this.getInches());
	}

	int getInchesFloor() {
		return (int) Math.floor(this.getInches());
	}

	int getInchesCeil() {
		return (int) Math.ceil(this.getInches());
	}

	double getInchesTotal() {
		return this.value;
	}

	int getTotalInchesRound() {
		return (int) Math.round(this.getInchesTotal());
	}

	int getTotalInchesFloor() {
		return (int) Math.floor(this.getInchesTotal());
	}

	int getTotalInchesCeil() {
		return (int) Math.ceil(this.getInchesTotal());
	}

	String getString() {
		if (this.value != null) {
			int feet = this.getFeetFloor();
			int inches = this.getInchesFloor();
			return feet + "' " + inches + "\"";
		} else {
			return "";
		}
	}
}