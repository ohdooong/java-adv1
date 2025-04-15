package thread.start;

public class HelloThreadMain2 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : start");

        HelloThread thread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start 호출 전");
        thread.run(); // run을 호출하면 main 스레드가 실행한다.
        System.out.println(Thread.currentThread().getName() + " : start 호출 후");

        System.out.println(Thread.currentThread().getName() + " : end");
    }
}
