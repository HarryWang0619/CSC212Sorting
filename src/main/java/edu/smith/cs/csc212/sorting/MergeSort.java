package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {

    // Sorting Functions
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
        // ListADT<Integer> output = new JavaList<Integer>();
        DoublyLinkedList<DoublyLinkedList<Integer>> workingQueue = new DoublyLinkedList<>(); 
        // from [1,2,1,4,6]
        // to   [[1],[2],[1],[4],[6]]
        for (int element : input) {
			DoublyLinkedList<Integer> elementsSet = new DoublyLinkedList<>();
			elementsSet.addBack(element);
			workingQueue.addBack(elementsSet);
        }
        // from     [[1],[2],[1],[4],[6]]
        //          [[1],[4],[1],[1,2]]
        //          [[1],[1,2],[1,4]]
        //          [[1,4],[1,1,2]]
        //          [1,1,1,2,4]
        while (workingQueue.size()>1) {
			DoublyLinkedList<Integer> a = workingQueue.removeFront();
			DoublyLinkedList<Integer> b = workingQueue.removeFront();
			workingQueue.addBack(combine(a,b));
		}

        return workingQueue.getBack();
    }



    // helper functions
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

    @SuppressWarnings("unused")
    public static DoublyLinkedList<Integer> combine(DoublyLinkedList<Integer> a, DoublyLinkedList<Integer> b) {
		DoublyLinkedList<Integer> output = new DoublyLinkedList<>();
		while (!a.isEmpty() && !b.isEmpty()) {
			output.addBack(smallerReturn(a, b));
		}
		if (a.isEmpty()) { 
			output.addAll(b); 
		} 
		if (b.isEmpty()) {
			output.addAll(a); 
		}
		return output;
	}

    @SuppressWarnings("unused")
    public static Integer smallerReturn(DoublyLinkedList<Integer> a, DoublyLinkedList<Integer> b) {
        Integer v = Math.min(a.getFront(), b.getFront());
        if (a.getFront() <= b.getFront()) {
            a.removeFront();
        } else {
            b.removeFront();
        }
        return v;
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


    // in file testings (non-unit testing, very unprofessional
    private static void checkFunc(ListADT<Integer> lst) {
        for(Integer i: lst) {
        	System.out.println(i);
        }
    }

        //NOTPASSED

    public static void main(String[] args) {    
		ListADT<Integer> sortRecur = new JavaList<>();
		sortRecur.addBack(13);
		sortRecur.addBack(52);
		sortRecur.addBack(1);
        sortRecur.addBack(256);
        ListADT<Integer> sorted1 = recursiveMergeSort(sortRecur);
        System.out.println("Recursive: ");
        checkFunc(sorted1);

        ListADT<Integer> sortIter = new JavaList<>();
		sortIter.addBack(31);
		sortIter.addBack(25);
		sortIter.addBack(33);
        sortIter.addBack(128);
        ListADT<Integer> sorted2 = recursiveMergeSort(sortIter);
        System.out.println("Iterative: ");
        checkFunc(sorted2);
	}

}