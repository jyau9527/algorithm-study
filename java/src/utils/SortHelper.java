package utils;

public class SortHelper {
    private SortHelper() {}

    public static <E extends Comparable<E>> boolean check(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
