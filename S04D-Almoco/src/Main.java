import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fixedn = in.nextInt();
        int friends = in.nextInt();
        int winner = 0;
        for (int f=0; f < friends; f++) {
            int number = in.nextInt();
            if (number > winner && number <= fixedn) {
                winner = number;
            }
        }
        if (winner !=0) {
            System.out.println(winner);
        } else {
            System.out.println("No free lunch");
        }
    }
}