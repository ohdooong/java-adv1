package thread.cas.increment;

public class BasicInteger implements IncrementInteger {
	
	private int value;

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
