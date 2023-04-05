package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
    private Tester() {
    }

    public static <E extends Comparable<E>> void testSort(String className, String methodName, E[] arr) {
        try {
            String tag = className + "#" + methodName + " dataSize: " + arr.length;

            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, Comparable[].class);

            Timer timer = new Timer(tag);
            timer.start();

            method.invoke(null, (Object) arr);

            timer.stop();

            if (!SortHelper.isSorted(arr)) {
                throw new RuntimeException(tag + " sort failed");
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static <E extends Comparable<E>> void testSearch(String className, String methodName, E[] arr, E target) {
        try {
            String tag = className + "#" + methodName + " dataSize: " + arr.length;

            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, Comparable[].class, Comparable.class);

            Timer timer = new Timer(tag);
            timer.start();

            int ret = (int) method.invoke(null, arr, target);

            timer.stop();

            if (ret < 0 || arr[ret] != target) {
                throw new RuntimeException(tag + " search failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
