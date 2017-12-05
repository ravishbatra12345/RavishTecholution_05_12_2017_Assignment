package com.ravi.assignment;

public class TwoCircles {

	public static void main(String[] args) {
//		 String[] info = new String[] { "12 0 21 14 0 23", "0 45 8 0 94 9",
//		 "35 0 13 10 0 38", "0 26 8 0 9 25" };

		String[] info = new String[] { "0 5 9 0 9 7", "0 15 11 0 20 16",
				"26 0 10 39 0 23", "37 0 5 30 0 11", "41 0 0 28 0 13" };

		String[] relationships = circles(info);

		for (int i = 0; i < relationships.length; i++) {
			System.out.println(relationships[i]);
		}
	}

	static String[] circles(String[] info) {
		String[] relationships = new String[info.length];
		int x1 = 0, y1 = 0, r1 = 0, x2 = 0, y2 = 0, r2 = 0;

		for (int i = 0; i < info.length; i++) {
			String[] relationshipArr = info[i].split(" ");
			x1 = Integer.parseInt(relationshipArr[0]);
			y1 = Integer.parseInt(relationshipArr[1]);
			r1 = Integer.parseInt(relationshipArr[2]);
			x2 = Integer.parseInt(relationshipArr[3]);
			y2 = Integer.parseInt(relationshipArr[4]);
			r2 = Integer.parseInt(relationshipArr[5]);

			if (isConcentricCircles(x1, y1, r1, x2, y2, r2)) {
				relationships[i] = "Concentric";
			} else if (isTouchingCircles(x1, y1, r1, x2, y2, r2)) {
				relationships[i] = "Touching";
			} else if (isIntersectingCircles(x1, y1, r1, x2, y2, r2)) {
				relationships[i] = "Intersecting";
			} else if (isDisjointInsideCircles(x1, y1, r1, x2, y2, r2)) {
				relationships[i] = "Disjoint‐Inside";
			} else if (isDisjointOutsideCircles(x1, y1, r1, x2, y2, r2)) {
				relationships[i] = "Disjoint‐Outside";
			}
		}

		return relationships;
	}

	private static boolean isConcentricCircles(int x1, int y1, int r1, int x2,
			int y2, int r2) {
		boolean isConcentric = false;
		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		if (d == 0) {
			isConcentric = true;
		}

		return isConcentric;
	}

	private static boolean isTouchingCircles(int x1, int y1, int r1, int x2,
			int y2, int r2) {
		boolean isTouching = false;
		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		if ((d == Math.abs((r1 - r2))) || (d == (r1 + r2))) {
			isTouching = true;
		}

		return isTouching;
	}

	private static boolean isIntersectingCircles(int x1, int y1, int r1,
			int x2, int y2, int r2) {
		boolean isIntersecting = false;
		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		if (Math.abs(r1 - r2) < d && d < (r1 + r2)) {
			isIntersecting = true;
		}

		return isIntersecting;
	}

	private static boolean isDisjointInsideCircles(int x1, int y1, int r1,
			int x2, int y2, int r2) {
		boolean isDisjointInside = false;
		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		int shorterRadius = 0;
		int longerRadius = 0;

		if (r1 < r2) {
			shorterRadius = r1;
			longerRadius = r2;
		} else if (r1 > r2) {
			shorterRadius = r2;
			longerRadius = r1;
		} else {
			return false;
		}

		if ((d + shorterRadius) < longerRadius) {
			isDisjointInside = true;
		}

		return isDisjointInside;
	}

	private static boolean isDisjointOutsideCircles(int x1, int y1, int r1,
			int x2, int y2, int r2) {
		boolean isDisjointOutside = false;
		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		if (d > (r1 + r2)) {
			isDisjointOutside = true;
		}

		return isDisjointOutside;
	}
}
