package thread.collection.simple.list;

import static util.MyLogger.log;

public class SimpleListMainV2 {

	
	
	public static void main(String[] args) {
		SimpleList list = new BasicList();
		
		list.add("A");
		list.add("B");
		
		log(list.toString());
	}
	
	private static void test(SimpleList list) {
		log(list.getClass().getSimpleName());
	}

}
