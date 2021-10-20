import utils.ArrayGenerator;
import utils.Tester;

import java.util.Arrays;

public class Main {
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
