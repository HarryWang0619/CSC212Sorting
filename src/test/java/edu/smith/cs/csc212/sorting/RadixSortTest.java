package edu.smith.cs.csc212.sorting;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

@SuppressWarnings("javadoc")
public class RadixSortTest {
	
	@Test
	public void testRadixSortFixed() {
		ListADT<Integer> input = new JavaList<Integer>();
		ListADT<Integer> bubbled = new JavaList<Integer>();

		for (int x : SortTestingHelpers.data) {
			input.addBack(x);
			bubbled.addBack(x);
		}

		// sort one of them with known-good:
		BubbleSort.sort(bubbled);
		// sort with maybe-broken radix-sort:
		ListADT<Integer> output = RadixSort.sort(input);
		
		// For debugging:
		System.out.println(input);
		System.out.println(output);
		System.out.println(bubbled);

		Assert.assertEquals(bubbled, output);
	}

	@Test
	public void stressTestRadixSort() {
		int N = 1000;
		Random rand = new Random();

		// This test generates random data, and makes sure that
		// RadixSort can sort as well as BubbleSort.
		for (int trial = 0; trial < 100; trial++) {
			ListADT<Integer> input = new JavaList<Integer>();
			ListADT<Integer> bubbled = new JavaList<Integer>();

			for (int i = 0; i < N; i++) {
				int next = rand.nextInt();
				input.addBack(next);
				bubbled.addBack(next);
			}

			// sort one of them with known-good:
			BubbleSort.sort(bubbled);
			// sort with maybe-broken radix-sort:
			ListADT<Integer> output = RadixSort.sort(input);

			// For debugging:
			// System.out.println(output);
			// System.out.println(bubbled);

			// Both sorts should yield the same lists:
			Assert.assertEquals(bubbled, output);
		}
	}
}
