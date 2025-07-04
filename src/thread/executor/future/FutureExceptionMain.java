package thread.executor.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionMain {
	
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		Future<Integer> future = es.submit(new ExCallable());
		
		
		sleep(2000);
		
		log("future state: " + future.state());
		
		
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			Throwable throwable = e.getCause();
			log("원본 예외: " + throwable);
		}
		
		es.close();
	}
	
	static class ExCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			log("Callable 실행, 예외 발생");
			throw new IllegalStateException("ex!");
		}
		
	}
}
