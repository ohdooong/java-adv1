package thread.start.test;

import static util.MyLogger.log;
public class StartTestMain {

    public static void main(String[] args) {
        log("main() start");
        CounterThread thread = new CounterThread();
        thread.start();
        log("main() end");
    }

    static class CounterThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("value : " + (i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
