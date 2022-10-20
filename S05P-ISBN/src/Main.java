import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String code = in.next();
        Tester iban = new Tester(code);
        if (iban.isValid()) {
            System.out.println("OK");
        } else {
            System.out.println("ERRO " + iban.calculateVD());
        }
        in.close();
        // Testes
        /*
        Tester c = new Tester("9780136091813");
        System.out.println(c.isValid());*/
    }
}

// LFG ABS