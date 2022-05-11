package sort;

import utils.ArrayGenerator;
import utils.SortHelper;
import utils.Tester;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    // 交换，三步操作
//                    SortHelper.swap(arr, j - 1, j);
//                } else {
//                    break;
//                }
//            }
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j + 1 < arr.length; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortHelper.swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            E tmp = arr[i];
//            for (int j = i; j - 1 >= 0; j--) {
//                if (tmp.compareTo(arr[j - 1]) < 0) {
//                    // 赋值，一步操作
//                    arr[j] = arr[j - 1];
//                } else {
//                    arr[j] = tmp;
//                    break;
//                }
//            }
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            E tmp = arr[i];
            for (int j = i; j + 1 < arr.length; j++) {
                if (tmp.compareTo(arr[j + 1]) > 0) {
                    arr[j] = arr[j + 1];
                } else {
                    arr[j] = tmp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {10000, 100000};
        for (int i : test) {
            Integer[] arr = ArrayGenerator.generateRandomArray(i, 1000000);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Tester.test("sort.InsertionSort", "sort", arr);
            Tester.test("sort.InsertionSort", "sort2", arr2);
        }
    }
}
