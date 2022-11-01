/*
   ___                         _         _____ _     __     _
  |_  |                       | |       |  __ \ |   /_/    (_)
    | | ___   __ _  ___     __| | __ _  | |  \/ | ___  _ __ _  __ _
    | |/ _ \ / _` |/ _ \   / _` |/ _` | | | __| |/ _ \| '__| |/ _` |
/\__/ / (_) | (_| | (_) | | (_| | (_| | | |_\ \ | (_) | |  | | (_| |
\____/ \___/ \__, |\___/   \__,_|\__,_|  \____/_|\___/|_|  |_|\__,_|
              __/ |
             |___/                      by Afonso Brás Sousa
*/

/** CLASSE MAIN
 * @author Afonso Brás Sousa
 * Recebe entradas, processa e gera saídas
 * Responsável pela interacção com o utilizador final
*/

import java.util.Scanner;

public class Main {
    //Constantes
    private static final String CMD_PLAYER = "player"; //comando-jogador
    private static final String CMD_SQUARE = "square"; //comando-casa
    private static final String CMD_STATUS = "status"; //comando-estado
    private static final String CMD_DICE = "dice"; //comando-lançamento
    private static final String CMD_EXIT = "exit"; //comando-sair

    //Main
    public static void main(String[] args) {
        //Início do input
        Scanner in = new Scanner(System.in);

        //Processa a ordem dos jogadores
        String playerOrder = in.next(); in.nextLine(); //Pre: 3 maiúsculas diferentes

        //Recebe o número de casas;
        int tileNumber = in.nextInt(); in.nextLine(); //Pre: >=10 && <=150

        //Recebe as casas especiais
        int[] penaltyTiles = saveTileArray(in); //Pre: >=1 && <=(tileNumber/3)
        int[] fallTiles = saveTileArray(in); //Pre: >=1 && <=(tileNumber/3)

        //Cria o tabuleiro
        Board board = new Board(playerOrder, tileNumber, penaltyTiles, fallTiles);

        //Processa comandos
        executeCmdLoop(board, in);

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

    //Interpretador de comandos
    //Interpreta e executa comandos enquanto !=exit
    //Imprime os outputs
    private static void executeCmdLoop(Board board, Scanner in) {
        String cmd, arg;
        do {
            cmd = in.next();
            arg = in.nextLine();
            switch (cmd) {
                case CMD_PLAYER:
                    //invalida o comando player se o argumento não for vazio
                    if (!arg.equals("")) {System.out.println("Invalid command");}
                    else {printNextPlayer(board);}
                    break;
                case CMD_SQUARE: printPlayerSquare(board, arg); break;
                case CMD_STATUS: printPlayerStatus(board, arg); break;
                case CMD_DICE:
                    int[] dice = splitArg(arg); //Pre: 2 argumentos com números inteiros
                    rollDice(board, dice[0], dice[1]);
                    break;
                case CMD_EXIT: printExitStatus(board); break;
                default:
                    System.out.println("Invalid command");
            }
        } while (!cmd.equals(CMD_EXIT));
    }

    //Divide o argumento do comando-lançamento em 2 inteiros
    //TODO PERGUNTAR AO PROF DA PRÁTICA SE É OK
    private static int[] splitArg(String arg) {
        String[] diceString = arg.split(" ");
        int[] dice = new int[diceString.length-1]; //ignoramos o 1º valor do arg (caracter espaço)
        for (int i = 0; i < diceString.length-1; i++) {
            dice[i] = Integer.valueOf(diceString[i+1]);
        }
        return dice;
    }

    //Comando-jogador
    //Imprime o próximo jogador a lançar os dados
    private static void printNextPlayer(Board board) {
        if (board.isGameOver()) {
            System.out.println("The game is over");
        } else {
            System.out.printf("Next to play: %c\n", board.getNextPlayer());
        }
    }

    //Comando-casa
    //Imprime em que casa está o jogador pedido
    private static void printPlayerSquare(Board board, String player) {
        if (player.length()!=2) { //espaço + 1 caracter, caso contrário jogador inválido
            System.out.println("Nonexistent player");
        } else {
            char color = player.charAt(1);
            int index = board.searchPlayer(color);
            if (index == -1) { //jogador não encontrado
                System.out.println("Nonexistent player");
            } else {
                //posição N do objecto jogador corresponde à casa N+1
                System.out.printf("%c is on square %d\n", color, board.getPlayerSquare(index) + 1);
            }
        }
    }

    //Comando-estado
    //Imprime se o jogador pedido pode lançar os dados quando for a sua vez de jogar
    private static void printPlayerStatus(Board board, String player) {
        if (player.length()!=2) { //espaço + 1 caracter, caso contrário jogador inválido
            System.out.println("Nonexistent player");
        } else {
            char color = player.charAt(1);
            int index = board.searchPlayer(color);
            if (index == -1) { //jogador não encontrado
                System.out.println("Nonexistent player");
            } else if (board.isGameOver()) {
                System.out.println("The game is over");
            } else if (board.getPlayerStatus(index)) {
                System.out.printf("%c can roll the dice\n", color);
            } else {
                System.out.printf("%c cannot roll the dice\n", color);
            }
        }
    }

    //Comando-lançamento
    //Processa se os dados lançados são válidos e actualiza o tabuleiro em conformidade
    private static void rollDice(Board board, int dice1, int dice2) {
        if (dice1<1 || dice1 >6 || dice2<1 || dice2>6) {
            System.out.println("Invalid dice");
        } else if (board.isGameOver()) {
            System.out.println("The game is over");
        } else {
            int diceResult = dice1 + dice2;
            board.processNextTurn(diceResult);
        }
    }

    //Comando-sair
    //Imprime o vencedor, caso exista
    private static void printExitStatus(Board board) {
        if (board.isGameOver()) {
            System.out.printf("%c won the game!\n",board.getWinner());
        } else {
            System.out.println("The game was not over yet...");
        }
    }
}