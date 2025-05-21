package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {
	
	private BlockingQueue<String> queue;
	
	
	public BoundedQueueV6_2(int max) {
		// TODO Auto-generated constructor stub
		this.queue = new ArrayBlockingQueue<>(max);
	}
	
	
	@Override
	public void put(String data) {
		boolean result = queue.offer(data);
		log("저장시도결과 : " + result);
	}
	@Override
	public String take() {
		return queue.poll();
	}
}
