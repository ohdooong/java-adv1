package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {

        System.out.println("111");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(false); // DaemonThread 여부에 따라 jvm종료 여부 결정됨.
        daemonThread.start();
        System.out.println("222");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " run() end");

        }
    }



}
