package sort;

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
                swap(arr, i, maxIndex);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
