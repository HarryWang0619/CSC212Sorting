package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {
    public static ListADT<Integer> recursiveMergeSort(ListADT<Integer> input) {
        if (input.size() <= 1) {
            return input;
        } else {
            ListADT<Integer> a = input.slice(0, input.size()/2);
            ListADT<Integer> b = input.slice(input.size()/2, input.size());
            
            return combine(recursiveMergeSort(a), recursiveMergeSort(b));
        }
    }

    public static ListADT<Integer> iterativeMergeSort(ListADT<Integer> input) {
        ListADT<Integer> output = new JavaList<Integer>();

        return output;
    }

    public static ListADT<Integer> combine(ListADT<Integer> a, ListADT<Integer> b) {
        ListADT<Integer> output = new JavaList<Integer>();
            while (!a.isEmpty() && !b.isEmpty()) {
                output.addBack(smallerReturn(a, b));
            } 
            if (a.isEmpty()) {
                output.addAll(b);
            } else if (b.isEmpty()) {
                output.addAll(a);
            } 
        return output;
    }

    public static Integer smallerReturn(ListADT<Integer> a, ListADT<Integer> b) {
        Integer v = Math.min(a.getFront(), b.getFront());
        if (a.getFront() <= b.getFront()) {
            a.removeFront();
        } else {
            b.removeFront();
        }
        return v;
    }
}