package com.ravi.assignment;

public class InTheFuture {
	public static void main(String[] args) {
		System.out.println(InTheFuture.minNum(3, 5, 1));
		System.out.println(InTheFuture.minNum(4, 5, 1));
		System.out.println(InTheFuture.minNum(5, 5, 1));
		System.out.println(InTheFuture.minNum(6, 5, 1));
		System.out.println(InTheFuture.minNum(5, 5, 0));
		System.out.println(InTheFuture.minNum(1, 2, 100));
		System.out.println(InTheFuture.minNum(100, 99, 100));
		System.out.println(InTheFuture.minNum(99, 100, 100));
	}

	public static int minNum(int A, int K, int P) {
		int minNoOfDays = 0, ashaCurrent = A + P, kellyCurrent = K;
		boolean isContinue = true;

		if (A >= K && P >= 0) {
			minNoOfDays = -1;
		} else {
			while (isContinue) {
				if (ashaCurrent < kellyCurrent) {
					isContinue = false;
				} else {
					ashaCurrent += A;
					kellyCurrent += K;
				}
				minNoOfDays++;
			}
		}

		return minNoOfDays;
	}
}
