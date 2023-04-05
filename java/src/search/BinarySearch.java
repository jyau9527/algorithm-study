package search;

import utils.ArrayGenerator;

public class BinarySearch {
    private BinarySearch() {}

    // 大于target的最小值
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int l = 0, r = arr.length;
        while (l < r) {
            // l取值是mid+1，不存在运算后区间不变导致死循环的问题，因此这里下取整，如果是lower应该是l + (r - l) / 2
            int mid = l + (r - l) / 2;
            int ret = arr[mid].compareTo(target);
            if (ret <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (r >= arr.length) {
            return -1;
        } else {
            return r;
        }
    }

    public static <E extends Comparable<E>> int search2(E[] arr, E target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ret = arr[mid].compareTo(target);
            if (ret == 0) {
                return mid;
            } else if (ret < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static <E extends Comparable<E>> int search(E[] arr, E target) {
        return search(arr, 0, arr.length  - 1, target);
    }

    private static <E extends Comparable<E>> int search(E[] arr, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        int ret = arr[mid].compareTo(target);
        if (ret == 0) {
            return mid;
        } else if (ret < 0) {
            return search(arr, mid + 1, r, target);
        } else {
            return search(arr, l, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateOrderedArray(5000000);
        int target = arr[arr.length - 1];
        System.out.println("Search " + target + ": " + search(arr, target));
        System.out.println("Search2 " + target + ": " + search2(arr, target));
        System.out.println("Upper " + target + ": " + upper(arr, target));
    }
}
