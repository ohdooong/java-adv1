package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread t = new Thread(task, "work");
		
		log("runFlag = "+ task.runFlag);
		
		t.start();
		
		sleep(1000);
		
		log("runFlag false로 변경시도");
		task.runFlag = false;
		
		log("runFlag = "+ task.runFlag);
		log("main 종료");
	}
	
	static class MyTask implements Runnable {
		volatile boolean runFlag = true;
		//boolean runFlag = true;
		@Override
		public void run() {
			log("task 시작");
			while(runFlag) {
				// 작업
			}
			log("task 종료");
		}
	}

}
