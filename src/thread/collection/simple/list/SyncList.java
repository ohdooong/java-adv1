package thread.collection.simple.list;

import java.util.Arrays;
import static util.ThreadUtils.sleep;

public class SyncList implements SimpleList{
	
	private final int DEFALUT_CAPACITY = 5;
	private Object[] elementData;
	private int size;
	
	public SyncList() {
		elementData = new Object[DEFALUT_CAPACITY];
	}

	@Override
	public synchronized int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public synchronized void add(Object e) {
		// TODO Auto-generated method stub
		
		elementData[size] = e;
		sleep(100);
		size++;
		
	}

	@Override
	public synchronized Object get(int index) {
		// TODO Auto-generated method stub
		return elementData[index];
	}

	
	@Override
	public synchronized String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
	}
}
