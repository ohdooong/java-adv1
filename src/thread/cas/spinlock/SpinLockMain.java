package thread.cas.spinlock;

import static util.MyLogger.log;
public class SpinLockMain {

	public static void main(String[] args) {
		SpinLockBad spinLock = new SpinLockBad();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				spinLock.lock();
				try {
					
					log("비즈니스 로직 수행");
				} finally {
					spinLock.unlock();
				}
				log("비즈니스 로직 수행 완료");
			}
		};
		
		
		Thread thread1 = new Thread(task, "Thread-1");
		Thread thread2 = new Thread(task, "Thread-2");
		
		thread1.start();
		thread2.start();
		
	}

}
