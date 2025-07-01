package thread.collection.simple.list;

import static util.MyLogger.log;

public class SimpleListMainV1 {

	public static void main(String[] args) {
		SimpleList list = new SyncList();
		
		list.add("A");
		list.add("B");
		
		log(list.toString());
	}

}
