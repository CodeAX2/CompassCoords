package dev.jd.compasscoords;

public class FacingUtil {

	public static String getDirectionFacing(double yaw) {

		if (yaw > 135 || yaw < -135) {
			return "North";
		} else if (yaw < -45) {
			return "East";
		} else if (yaw > 45) {
			return "West";
		} else {
			return "South";
		}

	}

}
