package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SelectionSort {

    // public static ListADT<Integer> sort(ListADT<Integer> input) {
    //     ListADT<Integer> output = new JavaList<>();
    //     if (input.size() <= 1) {
    //         return input;
    //     }
    //     while (input.size() > 0) {
    //         int index = 0;
    //         for (; index < input.size()-1; index++) {
    //             if (input.getIndex(index+1) < input.getIndex(index)) {
    //                 index = index + 1;
    //             }
    //         } 
    //         output.addBack(input.getIndex(index));
    //         input.removeIndex(index);
    //     }
    //     return output;
    // }

    public static ListADT<Integer> sort(ListADT<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }
		ListADT<Integer> output = new JavaList<Integer>();
		while (input.size() > 0) {
			int index = 0;
			for (int i = 0; i < input.size(); i++) {
				if (input.getIndex(i) <= input.getIndex(index)) {
					index = i;
				}
			}
            output.addBack(input.getIndex(index));
            input.removeIndex(index);
		}
		return output;
	}

    // I NO LONGER NEED THIS
    // public static void min(ListADT<Integer> input) {
    //     int large;
    // }

    // passed this test

    // private static void checkFunc(ListADT<Integer> lst) {
    //     for(Integer i: lst) {
    //     	System.out.println(i);
    //     }
    // }

	// public static void main(String[] args) {    
	// 	ListADT<Integer> sortMe = new JavaList<>();
	// 	sortMe.addBack(4);
	// 	sortMe.addBack(3);
	// 	sortMe.addBack(9);
    //     sortMe.addBack(1);
    //     ListADT<Integer> sorted = sort(sortMe);
    //     checkFunc(sorted);
	// }
}