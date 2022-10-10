//SafeBank v3.0 + menu em loop e opção Sair
import java.util.Scanner;

public class Main {

	private static SafeBankAccount createAccount(Scanner in) {
		System.out.print("Saldo inicial: ");
		int value = in.nextInt();
		in.nextLine();
		SafeBankAccount ba; //declara a variável antes do if, caso contrário ela só está definida dentro do if
		if (value > 0) {
			ba = new SafeBankAccount(value);
		} else {
			ba = new SafeBankAccount();
		}
		System.out.println("Conta criada com saldo inicial: " + ba.getBalance());
		return ba;
	}

	private static final int M_DEPOSIT = 1;
	private static final int M_WITHDRAW = 2;
	private static final int M_BALANCE = 3;
	private static final int M_CHECKINT = 4;
	private static final int M_CREDITINT = 5;
	private static final int M_EXIT = 6;

	private static void printMenu() {
		System.out.println(M_DEPOSIT+" - Depositar\n"
				+ M_WITHDRAW+" - Levantar\n"
				+ M_BALANCE+" - Consultar saldo\n"
				+ M_CHECKINT+" - Consultar juro anual\n"
				+ M_CREDITINT+" - Creditar juro anual\n"
				+ M_EXIT+" - Sair");
	}

	private static int readValue(String msg, Scanner in) {
		System.out.print(msg);
		int value = in.nextInt();
		in.nextLine();
		return value;
	}

	private static void processDeposit(SafeBankAccount acct, Scanner in) {
		int value = readValue("Valor a depositar:",in);
		if (value > 0) {
			acct.deposit(value);
			System.out.println("Depósito efectuado.");
		} else {System.out.println("Valor inválido.");}
	}

	private static void processWithdraw(SafeBankAccount acct, Scanner in) {
		int value = readValue("Valor a levantar:",in);

		if (value <=0) {
			System.out.println("Valor inválido.");
		}

		else {
			acct.withdraw(value);
			System.out.println("Operação processada."); //gera multa se value > acct.getBalance();
		}
	}

	private static void checkBalance(SafeBankAccount account) {
		System.out.println("O saldo da conta é: "+account.getBalance());
	}

	private static void checkInterest(SafeBankAccount account) {
		System.out.println("O juro anual é: "+account.computeInterest());
	}

	private static void processInterest(SafeBankAccount account) {
		account.applyInterest();
		System.out.println("Juro processado.");
	}

	private static void executeCmd(int option, SafeBankAccount account, Scanner in) {
		switch(option) {
			case M_DEPOSIT:
				processDeposit(account,in);
				break;
			case M_WITHDRAW:
				processWithdraw(account,in);
				break;
			case M_BALANCE:
				checkBalance(account);
				break;
			case M_CHECKINT:
				checkInterest(account);
				break;
			case M_CREDITINT:
				processInterest(account);
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Cria conta bancária
		SafeBankAccount acct = createAccount(in);
		int option;
		do {
			// Mostra o menu de opções
			printMenu();

			// Lê uma opção
			option = readValue("Opção: ",in);

			if (option != M_EXIT) {
				// Executa uma operação
				executeCmd(option,acct,in);

				// Mostra o saldo da conta, após a execução da operação
				checkBalance(acct);
			}
		} while (option != M_EXIT);
	}

}
