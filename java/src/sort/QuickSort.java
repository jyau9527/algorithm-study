package sort;

import utils.ArrayGenerator;
import utils.SortHelper;
import utils.Tester;

import java.util.Arrays;
import java.util.Random;

/**
 * 1、单路排序
 * （1）选择第一个元素作为锚点，比它小的放前面，大的放后面
 * （2）以锚点为分界线，前后两个区间递归进行排序
 * （3）当遇到有序数组时，第一个元素永远是最小值，将导致每次都将长度为n的数组分为0和n-1的长度，最终导致算法复杂度退化到O(n^2)
 * （4）为解决（3）的问题，需要改为随机选取元素作为锚点（如果固定index，总能找到一组测试用例能让每次取到的锚点都是最小值，从而退化）
 * （5）有序数组的问题解决了，但遇到整个数组元素均相等时，问题依旧存在，切无法解决
 * 2、双路排序
 * （1）前面的思路与单路排序是一致的，为解决有序数组的问题，同样需要使用随机数
 * （2）区别在于单路排序是两个区间始终紧挨着，未排序的元素在最后；而双路排序为排序的元素在中间，小于和大于的区间在两边
 * （3）这样的做法可以使得元素相同的数组最终得到的锚点位置也是尽可能分散在两侧，而非集中在一侧，从而解决了单路排序无法解决的问题
 * 3、三路排序
 * （1）双路排序中还有一个不足，相同元素的情况下，仍会做大量不必要的排序工作
 * （2）为减少不必要的排序，三路排序将区间分为小于、等于、大于三个，递归排序小于和大于两个区间即可，从而优化了重复元素较多的数组排序
 */
public class QuickSort {
    private QuickSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1, new Random());
    }

    /**
     * 单路快排：arr[l...p-1] <= v, arr[p+1...r] > v
     * 问题：
     * 1、需要随机选择p，避免有序数组使算法复杂度退化成O(n^2)
     * 2、如果数组元素全部相同，依旧会出现有序数组的问题
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        SortHelper.swap(arr, p, l);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) <= 0) {
                j++;
                SortHelper.swap(arr, i, j);
            }
        }

        SortHelper.swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2Ways(E[] arr) {
        sort2Ways(arr, 0, arr.length - 1, new Random());
    }

    /**
     * 双路快排：arr[l+1...i-1] <= v, arr[j+1...r] >= v
     * 可以解决单路快排的问题，但重复元素多时会做多许多无用功
     */
    public static <E extends Comparable<E>> void sort2Ways(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition2Ways(arr, l, r, random);
        sort2Ways(arr, l, p - 1, random);
        sort2Ways(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition2Ways(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        SortHelper.swap(arr, l, p);

        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (i <= j && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            SortHelper.swap(arr, i++, j--);
        }

        SortHelper.swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3Ways(E[] arr) {
        sort3Ways(arr, 0, arr.length - 1);
    }

    /**
     * 三路快排：arr[l+1...lt] < v, arr[lt+1...gt-1] == v, arr[gt...r] > v
     * 在双路的基础上，增加一路相等值，减少不必要的排序
     */
    private static <E extends Comparable<E>> void sort3Ways(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int lt = l, gt = r + 1;
        for (int i = l + 1; i < gt;) {
            int ret = arr[i].compareTo(arr[l]);
            if (ret < 0) {
                lt++;
                SortHelper.swap(arr, i, lt);
                i++;
            } else if (ret > 0) {
                gt--;
                SortHelper.swap(arr, i, gt);
            } else {
                i++;
            }
        }

        SortHelper.swap(arr, l, lt);

        // arr[l...lt-1] < v, arr[lt...gt-1] == v, arr[gt...r] > v
        sort3Ways(arr, l, lt - 1);
        sort3Ways(arr, gt, r);
    }

    public static void main(String[] args) {
        int[] test = {100000};
        for (int i : test) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(i);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
//            Tester.test("sort.QuickSort", "sort", arr);
            Tester.test("sort.QuickSort", "sort2Ways", arr2);
            Tester.test("sort.QuickSort", "sort3Ways", arr3);
            System.out.println();
        }
    }
}
