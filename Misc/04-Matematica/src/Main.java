import java.util.Scanner;

public class Main {
    private final static int END_OF_INPUT = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        do {
            number = getIntValue(in, "Introduza 1 número (0 para terminar): ");
            if (number != END_OF_INPUT) {

               // System.out.println(Mathematics.sumSquaredIt(number));
               // System.out.println(Mathematics.sumSquaredRec(number));


                int n2 = in.nextInt();
                System.out.println(Mathematics.gcdRec(number, n2));
                System.out.println(Mathematics.gcdIt(number, n2));

                /*
                if (Mathematics.isPrime(number))
                    System.out.println("É primo.");
                else
                    System.out.println("Não é primo.");
                System.out.println("Adeus!!!");
                in.close();
                 */
            }
        } while (number != END_OF_INPUT);
        in.close();
    }

    public static int getIntValue(Scanner in, String msg) {
        System.out.print(msg);
        int value = in.nextInt();
        return value;
    }

}