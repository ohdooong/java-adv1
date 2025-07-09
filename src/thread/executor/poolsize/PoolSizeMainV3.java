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

public class PoolSizeMainV3 {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		log("pool 생성");
		printState(es);
		
		for (int i = 1; i <= 4; i++) {
			String taskName = "task-" + i;
			es.execute(new RunnableTask(taskName));
			printState(es);
		}
	}

}
