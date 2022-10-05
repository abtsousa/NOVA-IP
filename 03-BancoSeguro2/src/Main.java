import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("***MONEYTRANSFER - Transferências Fáceis Lda.***");
		System.out.println("Insira o valor inical da conta (em cêntimos): ");
		Scanner in = new Scanner(System.in);
		int inicial = in.nextInt();
		in.nextLine();
		SafeBankAccount ba1 = createAccount(inicial);
		SafeBankAccount ba2 = createAccount(inicial);
		int amt = getIntTransfer(in);
		transferCash(ba1, ba2, amt);
		printBalance(ba1);
		printBalance(ba2);
		in.close();
	}
	
	private static SafeBankAccount createAccount(int amt) {
		SafeBankAccount acc = new SafeBankAccount();
		System.out.println("Criação de conta.");
		System.out.println("Saldo inicial: "+amt+" cêntimos");
		if (amt > 0) {
			acc.deposit(amt);
		}
		return acc;
	}
	
	private static void printBalance(SafeBankAccount acc) {
		System.out.print("Saldo da conta: ");
		System.out.println(acc.getBalance() + " cêntimos");
	}
	
	private static int getIntTransfer(Scanner in) {
		System.out.print("Valor a transferir em cêntimos: ");
		int transfer_input = in.nextInt();
		in.nextLine();
		return transfer_input;
	}
	
	private static void transferCash(SafeBankAccount acc1, SafeBankAccount acc2, int cash_amount) {
		System.out.println("A transferir "+cash_amount+" cêntimos...");
		if (acc1.getBalance() >= cash_amount && cash_amount > 0) {
			acc1.withdraw(cash_amount);
			acc2.deposit(cash_amount);
			System.out.println("Transferência efectuada com sucesso.");
		}
		else {System.out.println("Erro de transferência.");}	
	}
	
	
}
