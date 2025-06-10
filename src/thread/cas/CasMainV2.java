package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(20);
		
		// incrementAndGet 구현
		incrementAndGet(atomicInteger);		
		incrementAndGet(atomicInteger);		
		incrementAndGet(atomicInteger);		
		incrementAndGet(atomicInteger);		
		incrementAndGet(atomicInteger);		
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
