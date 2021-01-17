package com.vincent;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        // end (or mid) index should always be 1 index greater than the subarray

        // breakpoint: when the array contains less than two elements (a one element array),
        // the recursive calls will start executing.
        if (end - start < 2) {
            return;
        }

        // partition the arrays in half:

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        // at this point, both the left and right arrays will be separately sorted
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {

        // input[mid - 1] is the last element in the left array
        // input[mid] is the first element in the right array
        //
        // Thus, if the below breakpoint condition is true, the entire array must
        // already be in sorted order.
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ?
                      input[i++]
                    : input[j++];
        }

//        if (i > mid) {
//            while (j <= end) {
//                temp[tempIndex++] = input[j++];
//            }
//        } else {
//            while (i < mid) {
//                temp[tempIndex++] = input[i++];
//            }
//        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}
