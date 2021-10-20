package utils;

public class Printer {
    private Printer() {}

    public static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
