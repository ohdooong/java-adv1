package thread.executor.poolsize;

import static thread.executor.ExecutorUtils.printState;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import thread.executor.RunnableTask;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

	public static void main(String[] args) {
			BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
			
			ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);
			
			printState(es);
			es.execute(new RunnableTask("task1"));
			printState(es, "task1");
			
			es.execute(new RunnableTask("task2"));
			printState(es, "task2");
			
			es.execute(new RunnableTask("task3"));
			printState(es, "task3");
			es.execute(new RunnableTask("task4"));
			printState(es, "task4");
			es.execute(new RunnableTask("task5"));
			printState(es, "task5");
			es.execute(new RunnableTask("task6"));
			printState(es, "task6");
			
			try {
				es.execute(new RunnableTask("task7"));
			} catch(RejectedExecutionException e) {
				log("task7 실행 거절 예외 발생: " + e);
			}
			
			
			sleep(3000);
			log("-- 작업 수행 완료 --");
			printState(es);
			
			sleep(3000);
			log("-- max pool size 대기시간 초과 --");
			
			// keepAliveTime동안 초과 스레드가 처리할 작업이 없다면 max pool size에서 기본size pool size로 돌아옴
			printState(es);
			
	}

}
