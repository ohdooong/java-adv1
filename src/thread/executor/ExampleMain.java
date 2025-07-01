package thread.executor;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.Random;

public class ExampleMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();

        log("value: " + task.value);

    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            sleep(2000);
            value = new Random().nextInt(10);
        }
    }
}
