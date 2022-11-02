import java.util.Scanner;
public class Player {
    /** Constantes */

    /** Variáveis de instância */
    private String name;
    private int points;

    /**
     * Constructor:
     * @param name - o nome do jogador (String)
     * @pre: name != null; unique for each player
     */

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points++;
    }
}

public class TableTennis {
    /** Constantes */
    private static final int WINNING_SCORE = 11;
    private static final int MINIMUM_SCORE_DIFFERENCE = 2;

    /** Variáveis de instância */
    Player player1;
    Player player2;

    /**
     * Constructor:
     * @param name1 - o nome do jogador 1 (String)
     * @param name2 - o nome do jogador 2 (String)
     * @pre: nomes diferentes
     */

    public TableTennis(String name1, String name2) {
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    /**
     * @return nome do jogador 1
     */
    public String player1name() {
        return player1.getName();
    }

    /**
     * @return número de pontos do jogador 1
     */
    public int player1points() {
        return player1.getPoints();
    }

    /**
     * Adiciona mais um ponto ao jogador 1
     */
    public void addPointToPlayer1() {
        player1.addPoint();
    }

    /**
     * Diz se o jogo já terminou
     * @return true, se o jogo acabou; false, no caso contrário
     */
    public boolean isGameOver() {
        return ( ( player1points() >= WINNING_SCORE || player2points() >= WINNING_SCORE ) && ( player1points() - player2points() >= MINIMUM_SCORE_DIFFERENCE || player2points() - player1points() >= MINIMUM_SCORE_DIFFERENCE ));
    }

    /**
     * @return nome do vencedor do jogo
     * @pre: isGameOver() == true;
     */
    public String nameOfWinner() {
        if (player1points() > player2points()) {
            return player1name();
        } else {
            return player2name();
        }
    }

    public int numberOfMoves() {
        return ( player1points() + player2points() );
    }
}

public class Main {
    /** Constantes */
    private static final String PROMPT = "> ";
    private static final String AJUDA = "AJUDA";
    private static final String APJ1 = "APJ1";
    private static final String APJ2 = "APJ2";
    private static final String MP = "MP";
    private static final String SAIR = "SAIR";

    /**
     * Programa principal:
     * - leitura dos nomes dos 2 jogadores
     * - criação de um objeto da classe TableTennis
     * - chamada do método interpretador de comandos
     * @param args
     */

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nome do jogador 1: ");
        String playerName1 = in.nextLine();
        System.out.print("Nome do jogador 2: ");
        String playerName2 = in.nextLine();
        if (playerName2 == playerName1)
            System.out.println("Os 2 jogadores nao podem ter o mesmo nome.");
        else
            interpreter(in, new TableTennis(playerName1, playerName2));
        in.close();
    }

    /**
     * Implementação do comando AJUDA
     */
    private static void help( ) {
        System.out.println(SAIR + "\tSair do programa (terminar execucao).");
        System.out.println(AJUDA + "\tListar os comandos.");
        System.out.println(APJ1 + "\tAcrescentar 1 Ponto ao Jogador 1.");
        System.out.println(APJ2 + "\tAcrescentar 1 Ponto ao Jogador 2.");
        System.out.println(MP + "\tMostrar os Pontos dos 2 jogadores.");
    }

    /**
     * Leitura do próximo comando
     * @param in - o input
     */

    private static String nextCommand( Scanner in ) {
        System.out.print(PROMPT);
        return in.nextLine().toUpperCase();
    }

    /**
     * Jogada - acrescenta 1 Ponto ao Jogador 1
     * Se o jogo já terminou, só escreve na consola:
     O jogo ja terminou.
     * Caso contrário, concretiza a jogada e escreve 2 linhas com a forma:
     *	<int> jogadas ate agora.
     *  Jogador <nome> agora tem <int> pontos.
     * Caso o jogo termine com esta jogada, escreve mais 2 linhas:
     *	O jogo terminou.
     *  Vencedor: <nome>
     * @param tt - o objeto ténis de mesa
     */

    private static void processAPJ1 ( TableTennis tt ) {
        if (tt.isGameOver())
            System.out.println("O jogo já terminou.");
        else {
            tt.addPointToPlayer1();
            System.out.printf("%d jogadas ate agora.\nJogador %s agora tem %d pontos.", tt.numberOfMoves(), tt.player1name(), tt.player1points());
        }
        if (tt.isGameOver()) {
            System.out.println("O jogo terminou.");
            System.out.printf("Vencedor: %s", tt.nameOfWinner());
        }
    }

    /**
     * Implementação do comando SAIR
     * Se existir um vencedor, escreve na consola uma linha da forma:
     * 		Vencedor: <nome>
     * Se o jogo ainda não tinha terminado, escreve:
     * 		Jogo sem vencedor.
     * @param tt - o objeto ténis de mesa
     */

    private static void processExit ( TableTennis tt ) {
        if (tt.isGameOver())
            System.out.printf("Vencedor: %s", tt.nameOfWinner());
        else
            System.out.println("Jogo sem vencedor.");
    }


    /**
     * Implementação parcial do interpretador de comandos
     * Caso o comando não seja AJUDA, APJ1 ou SAIR,
     * escreve na consola:
     *    Comando desconhecido.
     * @param in - o input
     * @param tt - o objeto ténis de mesa
     * @pre:  os nomes dos 2 jogadores são distintos
     */

    private static void interpreter( Scanner in, TableTennis tt ) {
        String cmd;
        do {
            cmd = in.next();
            switch (cmd) {
                case AJUDA:
                    help();
                    break;
                case APJ1:
                    processAPJ1(tt);
                    break;
                case SAIR:
                    processExit(tt);
                    break;
                default:
                    System.out.println("Comando desconhecido.");
            }
        } while (cmd!=SAIR);
    }
}