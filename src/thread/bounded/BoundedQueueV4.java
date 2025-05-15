package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;
import static util.ThreadUtils.sleep;



public class BoundedQueueV4 implements BoundedQueue {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	
	private final Queue<String> queue = new ArrayDeque<>();
	private int max;
	
	public BoundedQueueV4(int max) {
		this.max = max;
	}
	
	
    @Override
    public void put(String data) {
    	
    	lock.lock();
    	
    	try {
    		while (queue.size() == max) {
    			log("[put] 큐가 가득 참, 생산자 대기");
    			try {
    				condition.await();
    				log("[put] 생산자 깨어남.");
    			}catch (InterruptedException e) {
    				new RuntimeException(e);
    			}
    			
    		} 
    		queue.offer(data);
    		
    		log("[put] 생산자 데이터 저장, notify() 호출");
    		// 대기하고 있던 스레드 WATING -> BLOCKED
    		condition.signal();
    		
    	} finally {
    		lock.unlock();
    	}
    	
    	
    }

    @Override
    public String take() {
    	
    	lock.lock();
    	
    	try {
    		while (queue.isEmpty()) {
    			log("[take] 큐에 데이터가 없음, 소비자 대기");
    			try {
    				condition.await();
    				log("[take] 소비자 깨어남.");
    			}catch (InterruptedException e) {
    				new RuntimeException(e);
    			}
    		}
    		String data = queue.poll();
    		
    		log("[put] 소비자 데이터 소비, notify() 호출");
    		// 대기하고 있던 스레드 WATING -> BLOCKED
    		condition.signal();
    		
    		return data;
    	} finally {
    		lock.unlock();
    	}
    	
    	
    }
    
    @Override
    public String toString() {
    	return queue.toString();
    }

}
