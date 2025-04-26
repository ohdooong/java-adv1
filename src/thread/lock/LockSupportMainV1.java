package thread.lock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100);
        log("thread1 상태 : " + thread1.getState());

        log("main -> unpark");
        LockSupport.unpark(thread1);

        //log("main -> interrupt");
        //thread1.interrupt();

    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("작업시작");
            LockSupport.park();
            log("unpark 상태 : " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}
