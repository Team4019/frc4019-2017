package org.usfirst.frc.team4019;

public class Line {
	double slope;
	double intercept;
	boolean vertical;
	double base;

	public Line(double[] start, double[] end) {
		if (start[0] == end[0]) {
			this.vertical = true;
			this.base = start[0];
		} else {
			this.vertical = false;
			this.slope = (end[1] - start[1]) / (end[0] - start[0]);
			this.intercept = start[1] - this.slope * start[0];
		}
	}

	public static double[] intersection(Line lineA, Line lineB) {
		double[] result = {0, 0};
		if (lineA.vertical && !lineB.vertical) {
			result[0] = lineA.base;
			result[1] = lineB.slope * result[0] + lineB.intercept;
		} else if (!lineA.vertical && lineB.vertical) {
			result[0] = lineB.base;
			result[1] = lineA.slope * result[0] * lineA.intercept;
		} else if (!lineA.vertical && !lineB.vertical && lineA.slope != lineB.slope) {
			result[0] = (lineA.intercept - lineB.intercept) / (lineB.slope - lineA.slope);
			result[1] = lineA.slope * result[0] + lineA.intercept;
		} else {
			// lines are parallel
		}
		return result;
	}
}