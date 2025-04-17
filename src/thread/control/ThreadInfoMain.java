package thread.control;

import thread.start.HelloRunnable;

public class ThreadInfoMain {

	public static void main(String[] args) {
		// main 스레드
		Thread mainThread = Thread.currentThread();
		System.out.println("mainThread : "+mainThread);
		System.out.println("mainThread.threadId() : "+mainThread.threadId());
		System.out.println("mainThread.getName() : "+mainThread.getName());
		System.out.println("mainThread.getPriority() : "+mainThread.getPriority());
		System.out.println("mainThread.getName() : "+mainThread.getThreadGroup());
		System.out.println();
		
		// my 스레드
		Thread myThread = new Thread(new HelloRunnable(), "myThread");
		System.out.println("myThread : "+myThread);
		System.out.println("myThread.threadId() : "+myThread.threadId());
		System.out.println("myThread.getName() : "+myThread.getName());
		System.out.println("myThread.getPriority() : "+myThread.getPriority());
		System.out.println("myThread.getName() : "+myThread.getThreadGroup());
		System.out.println();
		
		// my 스레드
		Thread myThread2 = new Thread(new HelloRunnable(), "myThread");
		System.out.println("myThread2 : "+myThread2);
		System.out.println("myThread2.threadId() : "+myThread2.threadId());
		System.out.println("myThread2.getName() : "+myThread2.getName());
		System.out.println("myThread2.getPriority() : "+myThread2.getPriority());
		System.out.println("myThread2.getName() : "+myThread2.getThreadGroup());
			
	}

}
