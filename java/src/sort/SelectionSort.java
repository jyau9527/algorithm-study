package sort;

import utils.SortHelper;

public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                SortHelper.swap(arr, i, maxIndex);
            }
        }
    }
}
