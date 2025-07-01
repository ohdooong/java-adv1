package thread.collection.simple.list;

import java.util.Arrays;
import static util.ThreadUtils.sleep;

public class BasicList implements SimpleList{
	
	private final int DEFALUT_CAPACITY = 5;
	private Object[] elementData;
	private int size;
	
	public BasicList() {
		elementData = new Object[DEFALUT_CAPACITY];
	}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(Object e) {
		// TODO Auto-generated method stub
		
		elementData[size] = e;
		sleep(100);
		size++;
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return elementData[index];
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
	}
}
