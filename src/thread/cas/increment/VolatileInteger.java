package thread.cas.increment;

public class VolatileInteger implements IncrementInteger {
	
	volatile private int value;

	@Override
	public void increment() {
		// TODO Auto-generated method stub
		value++;
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		return value;
	}

}
