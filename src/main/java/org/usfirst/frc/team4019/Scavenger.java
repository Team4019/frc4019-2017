package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Scavenger {
    CANTalon motor;
    boolean scavenging = false;

    public Scavenger(int talonID) {
        this.motor = new CANTalon(talonID);
    }

    public void start() {
        this.motor.set(Constants.scavenger.speed);
        this.scavenging = true;
    }

    public void reverse() {
        this.motor.set(-Constants.scavenger.speed);
        this.scavenging = true;
    }

    public void stop() {
        if (this.scavenging) {
            this.motor.set(0);
            this.scavenging = false;
        }
    }
}
