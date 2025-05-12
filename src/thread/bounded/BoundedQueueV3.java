package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;
import static util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue {
	
	private final Queue<String> queue = new ArrayDeque<>();
	private int max;
	
	public BoundedQueueV3(int max) {
		this.max = max;
	}
	
	
    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            try {
            	wait(); // RUNNABLE -> WATING
            	log("[put] 생산자 깨어남.");
            }catch (InterruptedException e) {
				new RuntimeException(e);
			}
            
        } 
        queue.offer(data);
        
        log("[put] 생산자 데이터 저장, notify() 호출");
        // 대기하고 있던 스레드 WATING -> BLOCKED
        notify();
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
        	log("[take] 큐에 데이터가 없음, 소비자 대기");
        	try {
            	wait(); // RUNNABLE -> WATING
            	log("[take] 소비자 깨어남.");
            }catch (InterruptedException e) {
				new RuntimeException(e);
			}
        }
        String data = queue.poll();
        
        log("[put] 소비자 데이터 소비, notify() 호출");
        // 대기하고 있던 스레드 WATING -> BLOCKED
        notify();
        
        return queue.poll();
    }
    
    @Override
    public String toString() {
    	return queue.toString();
    }

}
