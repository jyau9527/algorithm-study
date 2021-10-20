package utils;

public class PerformanceTester {
    private long mStartTime;

    public void start() {
        mStartTime = System.nanoTime();
    }

    public void stop() {
        long nanoTime = System.nanoTime() - mStartTime;

        double seconds = nanoTime / 1.0e9;
        System.out.println("cost: " + seconds + "s");

        mStartTime = 0;
    }
}
