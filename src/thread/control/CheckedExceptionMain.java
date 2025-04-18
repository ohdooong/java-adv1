package thread.control;

import static util.MyLogger.log;

import util.ThreadUtils;

public class CheckedExceptionMain {

    public static void main(String[] args) {
        new Thread(new CheckedRunnable(), "myThread")
            .start();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() {
            log("start");
            ThreadUtils.sleep(3000);
            log("end");
        }
    }
}
