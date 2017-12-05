package com.ravi.assignment;

public class PsychometricTesting {

	public static void main(String[] args) {
//		int[] noOfJobOffers = jobOffers(new int[] { 1, 3, 5, 6, 8 },
//				new int[] { 2 }, new int[] { 6 });

		 int[] noOfJobOffers = jobOffers(new int[] { 4, 8, 7 },
		 new int[] { 2, 4 }, new int[] { 8, 4 });

		for (int i = 0; i < noOfJobOffers.length; i++) {
			System.out.println(noOfJobOffers[i]);
		}
	}

	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int[] selectedCandidates = new int[lowerLimits.length];
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		// Sort
		sort(scores, 0, scores.length - 1);

		while (index < lowerLimits.length) {
			leftIndex = getLeftIndex(scores, lowerLimits[index]);
			rightIndex = getRightIndex(scores, upperLimits[index]);
			selectedCandidates[index] = rightIndex - leftIndex + 1;
			index++;
		}

		return selectedCandidates;
	}

	private static int getLeftIndex(int scores[], int left_range) {
		int length = scores.length;
		if (scores[length - 1] < left_range)
			return -1;

		int low = 0;
		int high = length - 1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			if (scores[mid] >= left_range) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return high + 1;
	}

	private static int getRightIndex(int scores[], int right_range) {
		int length = scores.length;
		if (scores[0] > right_range)
			return -1;

		int low = 0;
		int high = length - 1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			if (scores[mid] > right_range) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low - 1;
	}

	private static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}

		// Merge the temp arrays

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	private static void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}
}
