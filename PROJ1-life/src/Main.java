/*
   ___                         _         _____ _     __     _
  |_  |                       | |       |  __ \ |   /_/    (_)
    | | ___   __ _  ___     __| | __ _  | |  \/ | ___  _ __ _  __ _
    | |/ _ \ / _` |/ _ \   / _` |/ _` | | | __| |/ _ \| '__| |/ _` |
/\__/ / (_) | (_| | (_) | | (_| | (_| | | |_\ \ | (_) | |  | | (_| |
\____/ \___/ \__, |\___/   \__,_|\__,_|  \____/_|\___/|_|  |_|\__,_|
              __/ |
             |___/                      by Afonso Brás Sousa v 0.1
*/

/** CLASSE MAIN
 * @author Afonso Brás Sousa
 * Recebe inputs, processa e gera outputs
 * Responsável pela interacção com o utilizador final
*/

//Importa a classe Scanner
import java.util.Scanner;

public class Main {
    //Constantes
    private static final String CMD_PLAYER = "player"; //comando-jogador
    private static final String CMD_SQUARE = "square"; //comando-casa
    private static final String CMD_STATUS = "status"; //comando-estado
    private static final String CMD_DICE = "dice"; //comando-lançamento
    private static final String CMD_EXIT = "exit"; //comando-sair

    //Variáveis de instância
    private static Board board;

    //Main
    public static void main(String[] args) {
        //Inicia o input
        Scanner in = new Scanner(System.in);

        //Processa a ordem dos jogadores
        String playerOrder = in.next(); in.nextLine(); //Pre: length==3;

        //Processa o número de casas;
        int tileNumber = in.nextInt(); in.nextLine(); //Pre: >=10 && <=150

        //Processa as casas especiais
        int[] penaltyTiles = saveTileArray(in); //Pre: >=1 && <=(tileNumber/3)
        int[] fallTiles = saveTileArray(in); //Pre: >=1 && <=(tileNumber/3)

        //Cria um tabuleiro
        board = new Board(playerOrder, tileNumber, penaltyTiles, fallTiles);

        //Processa comandos
        executeCmdLoop(in);

        in.close();
    }

    /* Métodos */

    //Grava os vectores com as casas "especiais"
    private static int[] saveTileArray(Scanner in) {
        int size = in.nextInt(); in.nextLine();
        int[] tileArray = new int[size];
        for (int i=0; i<size; i++) {
            tileArray[i] = in.nextInt();
        }
        in.nextLine();
        return tileArray;
    }

    //Output start
    //Interpreta e executa comandos enquanto !=exit
    private static void executeCmdLoop(Scanner in) {
        String cmd;
        do {
            cmd = in.next();
            switch (cmd) {
                case CMD_PLAYER:
                    printNextPlayer();
                    break;
                case CMD_SQUARE:
                    printPlayerSquare(in.next());
                    break;
                case CMD_STATUS:
                    printPlayerStatus(in.next());
                    break;
                case CMD_DICE:
                    rollDice(in);
                    break;
                case CMD_EXIT:
                    printExitStatus();
                    break;
                default:
                    System.out.println("Invalid command");
            }
            in.nextLine();
        } while (!cmd.equals(CMD_EXIT));
    }

    //comando-jogador
    private static void printNextPlayer() {
        if (board.isGameOver()) {
            System.out.println("The game is over");
        } else {
            System.out.printf("Next to play: %C\n", board.getNextPlayer());
        }
    }

    //comando-casa
    private static void printPlayerSquare(String player) {
        if (player.length()>1) { //argumento inválido
            System.out.println("Nonexistent player");
        } else {
            char playerColor = player.charAt(0);
            int index = board.searchPlayer(playerColor);
            if (index == -1) {
                System.out.println("Nonexistent player");
            } else {
                //posição N do vector corresponde à casa N+1
                System.out.printf("%C is on square %d\n", playerColor, board.getPlayerSquare(index) + 1);
            }
        }
    }

    //comando-estado
    private static void printPlayerStatus(String player) {
        if (player.length()>1) { //argumento inválido
            System.out.println("Nonexistent player");
        } else {
            char playerColor = player.charAt(0);
            int index = board.searchPlayer(playerColor);
            if (index == -1) {
                System.out.println("Nonexistent player");
            } else if (board.isGameOver()) {
                System.out.println("The game is over");
            } else if (board.getPlayerStatus(index)) {
                System.out.printf("%C can roll the dice\n", playerColor);
            } else {
                System.out.printf("%C cannot roll the dice\n", playerColor);
            }
        }
    }

    //comando-lançamento
    private static void rollDice(Scanner in) {
        int dice1 = in.nextInt();
        int dice2 = in.nextInt();
        if (dice1<1 || dice1 >6 || dice2<1 || dice2>6) {
            System.out.println("Invalid dice");
        } else if (board.isGameOver()) {
            System.out.println("The game is over");
        } else {
            int diceResult = dice1 + dice2;
            board.processNextTurn(diceResult);
        }
    }

    //comando-sair
    private static void printExitStatus() {
        if (board.isGameOver()) {
            System.out.printf("%C won the game!\n",board.getWinner());
        } else {
            System.out.println("The game was not over yet...");
        }
    }
}