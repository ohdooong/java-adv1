package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = createThread("Thread-A", "A", 1000);
        Thread threadB = createThread("Thread-B", "B", 500);

        threadA.start();
        threadB.start();
    }

    private static Thread createThread(String name, String value,long mills){
        return new Thread(() -> {
            while(true) {
                log(value);
                try {
                    Thread.sleep(mills);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, name);
    }
}
