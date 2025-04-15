package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : start");

        HelloThread thread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start 호출 전");
        thread.start();
        System.out.println(Thread.currentThread().getName() + " : start 호출 후");

        System.out.println(Thread.currentThread().getName() + " : end");
    }
}
