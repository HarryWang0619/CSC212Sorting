package edu.smith.cs.csc212.sorting;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.sorting.SelectionSort;
import edu.smith.cs.csc212.sorting.InsertionSort;
import edu.smith.cs.csc212.sorting.MergeSort;

import edu.smith.cs.csc212.sorting.SortTestingHelpers;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SortTest {
	private static boolean checkSorted(ListADT<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}

	@Test
	public void testClassSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		sortMe.addBack(4);
		sortMe.addBack(3);
		sortMe.addBack(9);
		sortMe.addBack(1);
		InsertionSort.sort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	// @Test
	// public void testSelectionSort() {
	// 	ListADT<Integer> sortMe = SortTestingHelpers.getData();
	// 	int originalSize = sortMe.size();
	// 	ListADT<Integer> sorted = SelectionSort.sort(sortMe);
		
	// 	Assert.assertEquals(originalSize, sorted.size());
	// 	Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	// }
	
	@Test
	public void testInsertionSort() {
		ListADT<Integer> sortMe = SortTestingHelpers.getData();
		int originalSize = sortMe.size();
		ListADT<Integer> sorted = InsertionSort.sort(sortMe);
		
		Assert.assertEquals(originalSize, sorted.size());
		Assert.assertEquals(true, SortTestingHelpers.checkSorted(sorted, originalSize));
	}
}