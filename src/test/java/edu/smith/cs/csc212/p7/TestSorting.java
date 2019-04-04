package edu.smith.cs.csc212.p7;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(ListADT<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}
	
	@Test
	public void testSlice() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		int mid = sortMe.size()/2;
		ListADT<Integer> leftSlice = sortMe.slice(0, mid);
		ListADT<Integer> rightSlice = sortMe.slice(mid, sortMe.size());
		
		Assert.assertEquals(leftSlice.toJava(), Arrays.asList(35, 88, 11, 47));
		Assert.assertEquals(rightSlice.toJava(), Arrays.asList(14, 24, 41, 62, 27));
		
		Assert.assertEquals(14, (int) rightSlice.removeFront());
		Assert.assertEquals(4, rightSlice.size());
		Assert.assertEquals(27, (int) rightSlice.removeBack());
		Assert.assertEquals(3, rightSlice.size());
	}
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		SelectionSort.SelectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		SelectionSort.SelectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		SelectionSort.SelectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}
	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		InsertionSort.InsertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		InsertionSort.InsertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassInsertionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		InsertionSort.InsertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}
	
	@Test
	public void testMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		ListADT<Integer> result =new JavaList<>();
		result = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertTrue(checkSorted(result));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		result = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertTrue(checkSorted(result));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassMergeSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		ListADT<Integer> result =new JavaList<>();
		result = MergeSort.recursiveMergeSort(sortMe);
		Assert.assertTrue(checkSorted(result));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}

}
