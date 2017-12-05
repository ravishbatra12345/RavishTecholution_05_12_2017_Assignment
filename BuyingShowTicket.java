package com.ravi.assignment;

public class BuyingShowTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] tickets = new int[] { 2, 6, 3, 4, 5 };
//		int p = 2;
//		int[] tickets = new int[] { 1, 1, 1, 1 };
//		int p = 0;
		int[] tickets = new int[] { 5, 5, 2, 3 };
		int p = 3;
		System.out.println(BuyingShowTicket.waitingTime(tickets, p));
	}

	static long waitingTime(int[] tickets, int p) {
		int jesseWaitingTime = 0, jesseTickets = tickets[p], counter = 0;

		for (int i = 0, n = tickets.length; i < n; ++i) {
			if (i > p) {
				counter = 1;
			} else {
				counter = 0;
			}

			jesseWaitingTime += Math.min(tickets[i], jesseTickets - counter);
		}

		return jesseWaitingTime;
	}
}
