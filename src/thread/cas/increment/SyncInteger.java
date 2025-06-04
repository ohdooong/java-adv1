package thread.cas.increment;

public class SyncInteger implements IncrementInteger {
	
	private int value;

	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		value++;
	}

	@Override
	public synchronized int get() {
		// TODO Auto-generated method stub
		return value;
	}

}
