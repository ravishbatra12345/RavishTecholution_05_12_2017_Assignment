package com.ravi.assignment;

public class LargestSubsetSum {

	public static void main(String[] args) {
		int[] k = new int[] { 2, 4, 7, 16 };

		long[] sumArr = maxSubsetSum(k);

		for (int i = 0; i < sumArr.length; i++) {
			System.out.println(sumArr[i]);
		}
	}

	static long[] maxSubsetSum(int[] k) {
		long[] sumArr = new long[k.length];
		int current = 0;

		for (int i = 0; i < k.length; i++) {
			current = k[i];
			sumArr[i] = getSum(current);
		}

		return sumArr;
	}

	private static long getSum(int N) {
		long sum = 0;
		double maxLimit = Math.sqrt((double) N);

		// find all divisors which divides 'N'
		for (int i = 1; i <= maxLimit; i++) {
			// if 'i' is divisor of 'N'
			if (N % i == 0) {
				// if both divisors are same then add
				// it only once else add both
				if (i == (N / i)) {
					sum += i;
				} else {
					sum += (i + N / i);
				}
			}
		}

		return sum;
	}
}
