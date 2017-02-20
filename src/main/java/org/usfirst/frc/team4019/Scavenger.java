package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Scavenger {
    CANTalon motor;
    double multiplier = 1;
    boolean scavenging = false;

    public Scavenger(int talonID) {
        this.motor = new CANTalon(talonID);
    }

    public Scavenger(int talonID, double multiplier) {
        this.motor = new CANTalon(talonID);
        this.multiplier = multiplier;
    }

    public void start() {
        this.motor.set(this.multiplier);
        this.scavenging = true;
    }

    public void reverse() {
        this.motor.set(-this.multiplier);
        this.scavenging = true;
    }

    public void stop() {
        if (this.scavenging) {
            this.motor.set(0);
            this.scavenging = false;
        }
    }
}
