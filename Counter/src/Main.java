
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c1 = new Counter();
		System.out.println(c1.status()); // 0
		c1.inc();
		System.out.println(c1.status()); // 1
		c1.inc();
		System.out.println(c1.status()); // 2
		c1.dec();
		c1.reset();
		System.out.println(c1.status()); // 0
	}

}
