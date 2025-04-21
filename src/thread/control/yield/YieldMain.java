package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1_000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    private static class MyRunnable implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                // 1. empty
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 2. sleep
                //sleep(1);
                // 3. yield
                Thread.yield();
            }
        }
    }
}
