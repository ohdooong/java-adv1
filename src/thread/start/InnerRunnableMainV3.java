package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log("main() start");
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				log("run()");
			}
		});
		thread.start();
		log("main() end");
	}

}
