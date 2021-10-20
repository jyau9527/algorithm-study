import sort.SelectionSort;
import utils.ArrayGenerator;
import utils.PerformanceTester;
import utils.Printer;
import utils.SortHelper;

public class Main {
    public static void main(String[] args) {
        int[] test = {1000, 10000, 100000};
        for (int i : test) {
            Integer[] arr = ArrayGenerator.generateRandomArray(i, 10000000);
//        Printer.printArray(arr);
            System.out.println("ordered: " + SortHelper.check(arr));
            PerformanceTester tester = new PerformanceTester();
            tester.start();
            SelectionSort.sort(arr);
            tester.stop();
            System.out.println("ordered: " + SortHelper.check(arr));
            System.out.println();
//        Printer.printArray(arr);
        }
    }
}
