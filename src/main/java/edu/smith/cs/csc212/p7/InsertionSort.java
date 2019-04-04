package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

/**
 * Insertion Sort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class InsertionSort {

	/**Got help from TA's, python code, and https://www.geeksforgeeks.org/insertion-sort/
	 * @param input - the list to be sorted.
	 */
	public static void InsertionSort(ListADT<Integer> input) {
		int N = input.size();
		int min = 0;
		int minIndex = 0;
		
		for (int i = 1; i < N; i++) { 
			min = input.getIndex(i); 
			minIndex = i-1;
			while (minIndex >= 0 && input.getIndex(minIndex) > min) {
		        input.swap(minIndex + 1,minIndex);
		        minIndex --;
		    }
		    input.setIndex(minIndex + 1,min); 
		}
}
}
