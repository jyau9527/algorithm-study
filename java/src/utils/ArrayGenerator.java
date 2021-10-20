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
}
