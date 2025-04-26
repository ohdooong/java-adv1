package thread.lock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100);
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작 2초 대기");
            LockSupport.parkNanos(2_000_000_000);
            log("park 종료 : " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}
