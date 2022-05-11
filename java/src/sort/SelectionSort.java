package sort;

import utils.ArrayGenerator;
import utils.SortHelper;
import utils.Tester;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] test = {10000, 100000};
        for (int i : test) {
            Integer[] arr = ArrayGenerator.generateRandomArray(i, 1000000);
            Tester.test("sort.SelectionSort", "sort", arr);
        }
    }
}
