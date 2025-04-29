package thread.bounded;

public interface BoundedQueue {
	public void put(String data);
	public String take();
}
