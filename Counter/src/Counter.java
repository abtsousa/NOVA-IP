
public class Counter {
	private int count;
	public Counter() {count = 0;}
	public void inc() {count = count + 1;}
	public void dec() {count = count - 1;}
	public void reset() {count = 0;}
	public int status() {return count;}
}
