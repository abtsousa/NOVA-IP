/** CLASSE TABULEIRO (SISTEMA)
 * @author Afonso Brás Sousa
 * Inicia e gere o jogo
 * Define o formato do tabuleiro - número de casas e a ordem das casas "especiais"
 * Define 3 jogadores e a ordem com que iniciam
 * Actualiza a posição de cada jogador após cada turno
 */

public class Gameboard {
    //Constantes
    private static final int NUMBER_OF_PLAYERS = 3;
    private static final int BIRD_TILE_MULT = 9; //define de quantas em quantas casas existe uma casa pássaro
    private static final char BIRD_CHAR = 'B'; //pássaro
    private static final char PENALTY_CHAR = 'P'; //multa
    private static final char FALL_CHAR = 'F'; //precipício

    //Variáveis de instância
    private int tileNumber; //número de casas //Pre: >=10 && <=150
    private char[] boardTiles; //vector de casas e tipo
    private Player[] players; //lista de jogadores pela ordem com que jogam
    private int nextPlayer; //define ordem do próximo jogador a jogar

    //Constructor
    //Define o estado inicial do tabuleiro
    public Gameboard(String playerOrder, //Pre: length==3;
                     int tileNumber, //Pre: >=10 && <=150
                     int[] penaltyTiles, //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
                     int[] fallTiles //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
    ) {
        this.tileNumber = tileNumber;

        //TODO meter as próximas linhas num método generateBoard()?

        //Inicializa o tabuleiro
        boardTiles = new char[tileNumber];

        //Popula o tabuleiro com as casas especiais;
        populateBoard(BIRD_CHAR, birdTiles());
        populateBoard(PENALTY_CHAR, penaltyTiles);
        populateBoard(FALL_CHAR, fallTiles);

        //Popula os jogadores
        players = populatePlayers(playerOrder);
        nextPlayer = 0;
    }

    //Define as casas com pássaro
    private int[] birdTiles() {
        int[] birdTiles = new int[(tileNumber -1)/ BIRD_TILE_MULT]; //vai até n-1 — a última casa nunca pode ser pássaro
        for (int i=0; i < birdTiles.length; i++) {
            birdTiles[i] = BIRD_TILE_MULT *(i+1);
        }
        return birdTiles;
    }

    //Popula o tabuleiro com as casas especiais
    private void populateBoard(char c, int[] tiles) { //Pre: !=null
        for (int i = 0; i < tiles.length; i++) {
            int specialTile = tiles[i];
            boardTiles[specialTile-1] = c;//casa especial N está na posição N-1 do vector
        }
    }

    //Cria a lista de jogadores pela ordem com que jogam
    private Player[] populatePlayers(String playersString) { //Pre !=null; length == NUMBER_OF_PLAYERS == 3
    char[] playerOrder = playersString.toCharArray();
    Player[] players = new Player[NUMBER_OF_PLAYERS];
    for (int i=0; i<NUMBER_OF_PLAYERS; i++) {
        char playerColor = playerOrder[i];
        players[i] = new Player(playerColor);
        }
    return players;
    }

    //Procura o jogador pela sua cor
    //TODO
    private int searchPlayer(String color) {}

    //TODO comando-jogador
    private static void getNextPlayer() {}
    //TODO comando-casa
    private static void getPlayerSquare(String player) {}
    //TODO comando-estado
    private static void getPlayerStatus(String player) {}

    //TODO comando-lançamento
    //Processa um turno
    public void processNextTurn(int diceResult) {}

    //TODO endgame
    private boolean isGameOver() {return 0;} //TODO
}
