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
	
	private static final String M_DEPOSIT = "D";
	private static final String M_WITHDRAW = "L";
	private static final String M_BALANCE = "CS";
	private static final String M_CHECKINT = "CJA";
	private static final String M_CREDITINT = "AJA";
	
	private static void printMenu() {
		System.out.println(M_DEPOSIT+" - Depositar\n"
				+ M_WITHDRAW+" - Levantar\n"
				+ M_BALANCE+" - Consultar saldo\n"
				+ M_CHECKINT+" - Consultar juro anual\n"
				+ M_CREDITINT+" - Creditar juro anual");
	}
	
	private static String readCmd(Scanner in) {
		return in.next().toUpperCase(); //converte o input para maiúsculas
	}
	
	private static int readCmdValue(Scanner in) {
		int value = in.nextInt();
		in.nextLine(); //descarta o \n
		return value;
	}
	
	private static void processDeposit(SafeBankAccount acct, Scanner in) {
		int value = readCmdValue(in);
		if (value > 0) {
			acct.deposit(value);
			System.out.println("Depósito efectuado.");
		} else {System.out.println("Valor inválido.");}
	}
	
	private static void processWithdraw(SafeBankAccount acct, Scanner in) {
		int value = readCmdValue(in);
		
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
	
	private static void executeCmd(String option, SafeBankAccount account, Scanner in) {
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
		
		// Mostra o menu de opções
		printMenu();
		
		// Lê uma opção
		String option = readCmd(in);
		
		// Executa uma operação
		executeCmd(option,acct,in);
		
		// Mostra o saldo da conta, após a execução da operação
		checkBalance(acct);
		
		in.close();
	}

}
