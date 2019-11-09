package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {


    //BINARY SEARCH

    //              ^5, 1, 3, 12, 14, 3, 57, 14, 4
    // 5            5, _1, 3, 12, 14, 3, 57, 14, 4
    // 5            5, _1, 3, 12, 14, ., .., .., .
    // 5            5, _1, 3, .., .., ., .., .., .
    // 5            5, ^1, ., .., .., ., .., .., .
    // 1, 5         5, 1, _3, 12, 14, 3, 57, 14, 4
    //                             .
    //                             .
    //                             .
    //                             .


    public static ListADT<Integer> sort(ListADT<Integer> input) {
        ListADT<Integer> output = new JavaList<Integer>();
        output.addBack(input.getFront());
        if (input.size() <= 1) {
            return input;
        }

        for (int index = 1; index < input.size(); index++) {
			int l = 0;
			int r = index-1;
			int value = input.getIndex(index);
            int m = (l+r)/2;

            
			while (l <= r) {
				m = (l+r)/2;
				if (value > output.getIndex(m)) {
					l = m+1;
				}else {
					r = m-1;
				}
			}
		
			output.addIndex(l, value);
		}
		
		return output;
    }



    // LINEAR
    // public static ListADT<Integer> sort(ListADT<Integer> input) {
    //     if (input.size() <= 1) {
    //         return input;
    //     }
    //     int checkIndex = 1;
    //     while (checkIndex < input.size()-1) {
    //         if (input.getIndex(checkIndex) >= input.getIndex(checkIndex-1)) {
    //             checkIndex++;
    //         } else {
    //             for (int i = 0; i < checkIndex; i++) {
    //                 if (input.getIndex(i) >= input.getIndex(checkIndex)) {
    //                     Integer v = input.getIndex(checkIndex);
    //                     input.addIndex(i, v);
    //                     checkIndex++;
    //                 }
    //             }
    //         }
    //     }
    //     return input;
    // }

    // in file testings (non-unit testing, very unprofessional, but can i get partial credit if my unit test crashes?)
    // private static void checkFunc(ListADT<Integer> lst) {
    //     for(Integer i: lst) {
    //     	System.out.println(i);
    //     }
    // }

    //     //PASSED

    // public static void main(String[] args) {    
	// 	ListADT<Integer> sortMe = new JavaList<>();
	// 	sortMe.addBack(4);
	// 	sortMe.addBack(5);
	// 	sortMe.addBack(10);
    //     sortMe.addBack(2);
    //     ListADT<Integer> sorted = sort(sortMe);
    //     checkFunc(sorted);
	// }
}