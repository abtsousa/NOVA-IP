
public class SafeBankAccount {
	/* !!!all currency and balance is in CENTS (1€ = 100) !!!*/

	private static final int FINE = 200;
	private int balance;

	public SafeBankAccount() {balance=0;}
	/* Pre: initial >=0 */
	public SafeBankAccount(int initial) {balance = initial;}

	/* Pre: amount > 0 */
	public void deposit(int amount) {balance = balance + amount;}

	public void withdraw(int amount) {
		if (amount <= balance) {
			balance = balance - amount;
		}
		else {balance = balance - FINE;}
	}

	public int getBalance() {return balance;}
	public boolean isInRedZone() {return balance < 0;}

	/* Interest */
	private static final int INT1 = 200000;
	private static final double INT1_RATE = 0.01;
	private static final int INT2 = 1000000;
	private static final double INT2_RATE = 0.02;
	private static final double INT3_RATE = 0.03;

	public int computeInterest() {
		double interestRate;
		if (balance<=INT1) {interestRate = INT1_RATE;}
		else if (balance <=INT2) {interestRate = INT2_RATE;}
		else {interestRate = INT3_RATE;}
		return Math.toIntExact(Math.round(balance * interestRate));
	}

	/* Pre: getbalance()>0 */
	public void applyInterest() {
		balance = balance + this.computeInterest();
	}
}
