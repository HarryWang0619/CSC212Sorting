package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {
    public static ListADT<Integer> sort(ListADT<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }
        int checkIndex = 1;
        while (checkIndex < input.size()-1) {
            if (input.getIndex(checkIndex) >= input.getIndex(checkIndex-1)) {
                checkIndex++;
            } else {
                for (int i = 0; i < checkIndex; i++) {
                    if (input.getIndex(i) >= input.getIndex(checkIndex)) {
                        Integer v = input.getIndex(checkIndex);
                        input.addIndex(i, v);
                        checkIndex++;
                    }
                }
            }
        }
        checkFunc(input);
        return input;
    }

    private static void checkFunc(ListADT<Integer> lst) {
        for(Integer i: lst) {
        	System.out.println(i);
        }
    }

    public static void main(String[] args) {    
		ListADT<Integer> sortMe = new JavaList<>();
		sortMe.addBack(4);
		sortMe.addBack(3);
		sortMe.addBack(9);
        sortMe.addBack(1);
        ListADT<Integer> sorted = sort(sortMe);
        checkFunc(sorted);
	}
}