package sort;

import utils.ArrayGenerator;
import utils.Tester;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    // merge [l, mid] and [mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int left = l;
        int right = mid + 1;
        for (int i = l; i <= r; ++i) {
            if (left > mid) {
                arr[i] = temp[right];
                right++;
            } else if (right > r) {
                arr[i] = temp[left];
                left++;
            } else if (temp[left].compareTo(temp[right]) <= 0) {
                arr[i] = temp[left];
                left++;
            } else {
                arr[i] = temp[right];
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {10000, 100000, 1000000};
        for (int i : test) {
            Integer[] arr = ArrayGenerator.generateRandomArray(i, 1000000);
            Tester.test("sort.MergeSort", "sort", arr);
        }
    }
}
