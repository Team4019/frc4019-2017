package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Dashboard {
	static void write(int id, String data) {
		if (data != null) {
			SmartDashboard.putString("DB/String " + id, data);
		} else {
			SmartDashboard.putString("DB/String " + id, "");
		}
	}

	static void write(int id, Double data) {
		if (data != null) {
			SmartDashboard.putString("DB/String " + id, data.toString());
		} else {
			SmartDashboard.putString("DB/String " + id, "");
		}
	}

	static void write(int id, Integer data) {
		if (data != null) {
			SmartDashboard.putString("DB/String " + id, data.toString());
		} else {
			SmartDashboard.putString("DB/String " + id, "");
		}
	}

	static void write(int id, Long data) {
		if (data != null) {
			SmartDashboard.putString("DB/String " + id, data.toString());
		} else {
			SmartDashboard.putString("DB/String " + id, "");
		}
	}

	static void clear() {
		for (int id = 0; id < 10; id++) {
			SmartDashboard.putString("DB/String " + id, "");
		}
	}

	static double getSlider(int id) {
		return SmartDashboard.getNumber("DB/Slider " + id);
	}

	static void setSlider(int id, double value) {
		SmartDashboard.putNumber("DB/Slider " + id, value);
	}

	static boolean getButton(int id) {
		return SmartDashboard.getBoolean("DB/Button " + id);
	}
}