package org.usfirst.frc.team4019;

public abstract class Exponent {
	public static double even(double base, int power) {
		return Math.pow(Math.abs(base), power);
	}
	public static double odd(double base, int power) {
		return even(base, power) * (base >= 0 ? 1 : -1);
	}
}