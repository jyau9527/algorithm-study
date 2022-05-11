package utils;

public class Timer {
    private final String mTag;
    private long mStartTime;

    public Timer(String tag) {
        mTag = tag;
    }

    public void start() {
        mStartTime = System.nanoTime();
    }

    public void stop() {
        long nanoTime = System.nanoTime() - mStartTime;

        double seconds = nanoTime / 1.0e9;
        System.out.println(mTag + " cost: " + seconds + "s");

        mStartTime = 0;
    }
}
