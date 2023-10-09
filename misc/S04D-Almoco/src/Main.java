import java.util.Scanner;

//ALMOÇO v2
// Adicionado in.close()
// Adicionado check de restrições
public class Main {
    private static final int FIXEDNMIN = 1;
    private static final int FIXEDNMAX = 99;
    private static final int FRIENDSMIN = 1;
    private static final int FRIENDSMAX = 10;
    private static final int NUMBERMIN = 1;
    private static final int NUMBERMAX = 99;
    public static void main(String[] args) {
        //input start
        Scanner in = new Scanner(System.in);
        int fixedn, friendsn;
        //define números com restrições
        do {fixedn = in.nextInt();} while (fixedn > FIXEDNMAX || fixedn < FIXEDNMIN);
        do {friendsn = in.nextInt();} while (friendsn > FRIENDSMAX || friendsn < FRIENDSMIN);
        int number, winnerwinnerchickendinner = 0;
        for (int f=0; f < friendsn; f++) {
            do {number = in.nextInt();} while (number > NUMBERMAX || number < NUMBERMIN);
            if (number > winnerwinnerchickendinner && number <= fixedn) {
                winnerwinnerchickendinner = number;
            }
        }
        //input end
        in.close();
        if (winnerwinnerchickendinner !=0) {
            System.out.println(winnerwinnerchickendinner);
        } else {
            System.out.println("No free lunch");
        }
    }
}