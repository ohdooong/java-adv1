package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {

	private volatile boolean lock = false;
	
	
	public void lock() {
		log("락 획득 시도");
		while(true) {
			if(!lock) {
				sleep(100);
				lock = true;
				break;
			} else {
				// 락 획득실패
			}
		}
		
		log("락 획득 완료");
	}
	
	public void unlock() {
		lock = false;
		log("락 반납 완료");
	}
}
