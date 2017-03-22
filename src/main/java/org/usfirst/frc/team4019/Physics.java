package org.usfirst.frc.team4019;

public abstract class Physics {
	double velocity(double distance) { // inches per second
		double x = distance + Constants.shooter.inset;
		double y = Constants.boiler.height - Constants.shooter.height;
		return Constants.physics.gravity * Math.pow(x, 2) / (2 * Math.cos(Constants.shooter.angle) * (x * Math.sin(Constants.shooter.angle) - y * Math.cos(Constants.shooter.angle)));
	}
	double angular(double distance) { // revolutions per second
		return velocity(distance) / (2 * Math.PI * Constants.shooter.radius);
	}
}