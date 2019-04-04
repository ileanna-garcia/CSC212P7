package edu.smith.cs.csc212.p7;

import java.util.ArrayList;

import org.w3c.dom.Node;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;
import edu.smith.cs.csc212.adtr.real.JavaList;

/**
 * Merge Sort is a simple sort that is O(nLogn).
 * @author jfoley
 *
 */
public class MergeSort {

	/**
	 * @param input - the list to be sorted.
	 * @return 
	 */

	public static ListADT<Integer> combineMergeSort (ListADT<Integer> left,ListADT<Integer> right) {
		
		ListADT<Integer> result =new JavaList<>();
		
		while(left.size() > 0 && right.size() > 0 ) {
			
			if(left.getFront() < right.getFront() ) {
				result.addBack(left.removeFront());
			}
			
			else {
				result.addBack(right.removeFront());
			}
		}
		if(right.size() != 0) {
			int N = right.size();
			for(int i = 0; i<N; i++){
				result.addBack(right.removeFront());	
		    }					
	    }
		
		if(left.size() != 0) {
			int N = left.size();
			for(int i = 0 ;i<N; i++){
				result.addBack(left.removeFront());
		    }
		}
		return result;
		
}
	public static ListADT<Integer> recursiveMergeSort (ListADT<Integer> input)	{
		if(input.size() == 1) {
			return input;
		}
		
		int half = input.size()/2;
		ListADT<Integer> left = input.slice(0,half);
		ListADT<Integer> right = input.slice(half,input.size());
		return combineMergeSort(recursiveMergeSort(left),recursiveMergeSort(right));
		
		}
	
	public static <T> ListADT<Integer> iterativeMergeSort (ListADT<Integer> input)	{
            DoublyLinkedList <ListADT<Integer>> queue = new DoublyLinkedList <ListADT<Integer>> ();
           
            for (int element : input) {
            	ListADT<Integer> list = new JavaList<Integer>();
            	list.addFront(element);
            	queue.addBack(list);
            }
            
            
            while(queue.size() > 1) {
                System.out.println(queue);

            	ListADT<Integer> first = queue.removeFront();
            	ListADT<Integer> second = queue.removeFront();
            	ListADT<Integer> combined = combineMergeSort(first,second);
            	
            	System.out.println("During while loop" + combined);
            	
            	queue.addBack(combined);
            	System.out.println("During while loop" + queue);
            }
      
            System.out.println("This is the front of the queue " + queue.getFront());
	   
            return queue.getFront();
	}
	
}



