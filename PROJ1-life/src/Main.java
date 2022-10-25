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
    private static Gameboard board;

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
        board = new Gameboard(playerOrder, tileNumber, penaltyTiles, fallTiles);

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

    //Interpreta e executa comandos enquanto !=exit
    private static void executeCmdLoop(Scanner in) {
        //TODO
        String cmd;
        do {
            cmd = in.next();
            switch (cmd) {
                case CMD_PLAYER:
                    //TODO fetchNextPlayer()
                case CMD_SQUARE:
                    //TODO printPlayerSquare(in.next()) {}
                case CMD_STATUS:
                    //TODO printPlayerStatus(in.next()) {}
                case CMD_DICE:
                    rollDice(in);
            }
            in.nextLine();
        } while (!cmd.equals(CMD_EXIT));
    }

    //Output start
    //TODO comando-jogador
    private static void printNextPlayer() {}
    //TODO comando-casa
    private static void printPlayerSquare(String player) {}
    //TODO comando-estado
    private static void printPlayerStatus(String player) {}
    //TODO comando-lançamento
    private static void rollDice(Scanner in) {
        int diceResult = in.nextInt() + in.nextInt(); //Pre: >1 && <13
        board.processNextTurn(diceResult); //TODO processNextTurn();
    }
}