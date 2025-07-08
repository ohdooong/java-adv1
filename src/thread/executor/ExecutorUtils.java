package thread.executor;


import static util.MyLogger.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor threadPoolExecutor) {
            int pool = threadPoolExecutor.getPoolSize();
            int active = threadPoolExecutor.getActiveCount();

            int queuedTasks = threadPoolExecutor.getQueue().size();
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();

            log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks +
                ", completedTaskCount=" + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }
    
    
    // 추가
    public static void printState(ExecutorService executorService, String taskName) {
    	if (executorService instanceof ThreadPoolExecutor threadPoolExecutor) {
    		int pool = threadPoolExecutor.getPoolSize();
    		int active = threadPoolExecutor.getActiveCount();
    		
    		int queuedTasks = threadPoolExecutor.getQueue().size();
    		long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
    		
    		log(taskName + " -> [pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks +
    				", completedTaskCount=" + completedTaskCount + "]");
    	} else {
    		log(executorService);
    	}
    }
}
