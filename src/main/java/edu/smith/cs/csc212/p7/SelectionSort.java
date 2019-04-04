package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
/**Just in case this is found somewhere else I used CSC 111 Python code 
 * from Kiara's lab and we translated it into Java.
 */

/**
 * SelectionSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class SelectionSort {

	/**
	 * @param input - the list to be sorted.
	 */
	public static void SelectionSort(ListADT<Integer> input) {
		int N = input.size();
		int min = 0;
		int minIndex = 0;
		
		for (int i = 0; i < N - 1; i++) {
			min = input.getIndex(i); 
			minIndex = i;

           
             for (int j = i + 1; j < N; j++) {
            	 
                 if (input.getIndex(j) < min) { 
                
                 min = input.getIndex(j);
                 input.setIndex(i, input.getIndex(j));
                 
                  
                  
                        
                 }
                 
             }
             
             
		}

	}

}