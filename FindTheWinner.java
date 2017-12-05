package com.ravi.assignment;

public class FindTheWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(FindTheWinner.winner(new int[] { 1, 2, 3 },
				new int[] { 2, 1, 3 }, "Even"));

		System.out.println(FindTheWinner.winner(new int[] { 1, 2, 3 },
				new int[] { 2, 1, 3 }, "Odd"));

		System.out.println(FindTheWinner.winner(new int[] { 1, 2, 3 },
				new int[] { 1, 2, 3 }, "Even"));
	}

	static String winner(int[] andrea, int[] maria, String s) {
		String winnerWho = null;
		int i = 0, andreaScore = 0, mariaScore = 0;

		if (s.equals("Odd")) {
			i = 1;
		}

		while (i < andrea.length) {
			andreaScore += andrea[i] - maria[i];
			mariaScore += maria[i] - andrea[i];
			i = i + 2;
		}

		if (andreaScore > mariaScore) {
			winnerWho = "Andrea";
		} else if (mariaScore > andreaScore) {
			winnerWho = "Maria";
		} else {
			winnerWho = "Tie";
		}

		return winnerWho;
	}
}
