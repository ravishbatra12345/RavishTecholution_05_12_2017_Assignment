package com.ravi.assignment;

public class ConsecutiveSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(consecutive(15));
		System.out.println(consecutive(10));
	}

	static int consecutive(long num) {
		long start = 1, end = 1;
		long sum = 1;
		int noOfWays = 0;

		while (start <= num / 2) {
			if (sum < num) {
				end += 1;
				sum += end;
			} else if (sum > num) {
				sum -= start;
				start += 1;
			} else if (sum == num) {
				noOfWays++;
				sum -= start;
				start += 1;
			}
		}

		return noOfWays;
	}
}
