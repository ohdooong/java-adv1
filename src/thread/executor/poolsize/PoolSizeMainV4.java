package thread.executor.poolsize;

import static thread.executor.ExecutorUtils.printState;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import thread.executor.RunnableTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV4 {
	
//	static final int TASK_SIZE = 1100;
//	static final int TASK_SIZE = 1200;
	static final int TASK_SIZE = 1201;

	public static void main(String[] args) {
		ExecutorService es =
				new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
		
		printState(es);
		
		long startMs = System.currentTimeMillis();
		
		for (int i = 1; i <= TASK_SIZE; i++) {
			String taskName = "task-" + i;
			
			try {
				es.execute(new RunnableTask(taskName));
				printState(es, taskName);
			} catch (RejectedExecutionException e) {
				log("taskName: " + taskName);
			}
			
			
			
		}
		
		
		es.close();
		long endMs = System.currentTimeMillis();
		
		
		log("time: " + (endMs - startMs));
		
	}

}
