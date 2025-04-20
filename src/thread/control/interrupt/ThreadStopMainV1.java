package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        log("start");
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        task.runFlag = false;
        log("end");
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업 시작");
                sleep(3000);
            }

            log("자원 정리");
            log("작업 완료");
        }
    }
}
