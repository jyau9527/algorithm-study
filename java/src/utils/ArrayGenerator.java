package utils;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {}

    public static Integer[] generateOrderedArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generateRandomArray(int size, int bound) {
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    // 针对以中间点为标定点的快速排序，生成一个特殊的测试用例
    // 使得这样的快速排序产生退化
    public static Integer[] generateSpecialArray(int n){

        Integer[] arr = new Integer[n];
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;
    }

    private static void generateSpecialArray(Integer[] arr, int l, int r, int value){

        if(l > r) return;

        int mid = (l + r) / 2;
        arr[mid] = value;

        SortHelper.swap(arr, l, mid);
        generateSpecialArray(arr, l + 1, r, value + 1);
        SortHelper.swap(arr, l, mid);
    }
}
