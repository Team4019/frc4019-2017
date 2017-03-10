package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Intake {
	enum IntakeMode {FORWARD, REVERSE, DISABLED}

    CANTalon motor;
    IntakeMode intakeMode;

    public Intake(int talonID) {
        this.motor = new CANTalon(talonID);
        this.motor.setInverted(Constants.intake.inverted);
        this.intakeMode = IntakeMode.DISABLED;
    }

    public void start() {
        this.motor.set(Constants.intake.speed);
        this.intakeMode = IntakeMode.FORWARD;
        this.setDashboard();
    }

    public void reverse() {
        this.motor.set(-Constants.intake.speed);
	    this.intakeMode = IntakeMode.REVERSE;
	    this.setDashboard();
    }

    public void stop() {
        if (this.intakeMode != IntakeMode.DISABLED) {
            this.motor.set(0);
	        this.intakeMode = IntakeMode.DISABLED;
	        this.setDashboard();
        }
    }

    public void setDashboard() {
	    Dashboard.write(Constants.intake.dashboard, "Intake: " + this.intakeMode + ";");
    }
}