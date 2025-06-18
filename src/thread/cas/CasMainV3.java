package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV3 {
	
	private final static int THREAD_COUNT = 100;
	
	
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				incrementAndGet(atomicInteger);
			}
		};
		
		List<Thread> threadList = new ArrayList<>();
		
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(runnable);
			threadList.add(thread);
			thread.start();
		}
		
		for (Thread thread : threadList) {
			thread.join();
		}
		
		log("atomicInteger: " + atomicInteger);
	}
	
	private static int incrementAndGet(AtomicInteger atomicInteger) {
		
		int value;
		boolean result;
		
		do {
			value = atomicInteger.get();
			log("value: " + value);
			result = atomicInteger.compareAndSet(value, value+1);
			log("result: " + result);
		} while(!result);
		
		return value + 1;
	}
}
