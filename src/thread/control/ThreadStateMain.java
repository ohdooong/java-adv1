package thread.control;

import util.MyLogger;

public class ThreadStateMain {
	public static void main(String[] args) {
		MyLogger.log(Thread.currentThread().getState());
		Thread thread = new Thread(new MyRunnable(), "myThread");
		thread.start();
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			
		}
		
		MyLogger.log(thread.getState());
		try {
			Thread.sleep(4000);
		} catch(Exception e) {
			
		}
		MyLogger.log(thread.getState());
	}
	private static class MyRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			MyLogger.log("start");
			MyLogger.log("state : " + Thread.currentThread().getState());
			MyLogger.log("sleep start");
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				
			}
			MyLogger.log("sleep end");
			
			MyLogger.log("end");
			
		}
	}
}
