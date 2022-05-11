package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
    private Tester() {
    }

    public static <E extends Comparable<E>> void test(String className, String methodName, E[] arr) {
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
}
