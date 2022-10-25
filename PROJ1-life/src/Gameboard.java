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
    private int NUMBER_OF_TILES; //Pre: >=10 && <=150
    private char[] boardTiles;
    private Player[] players;

    //Constructor
    //Define o estado inicial do tabuleiro
    public Gameboard(String playerOrder, //Pre: = 3
                     int tileNumber, //Pre: >=10 && <=150
                     int[] penaltyTiles, //Pre: >=1 && <=(numCasas/3)
                     int[] fallTiles //Pre: >=1 && <=(numCasas/3)
    ) {
        this.NUMBER_OF_TILES = tileNumber;

        //Inicializa o tabuleiro
        boardTiles = new char[tileNumber];

        //Popula o tabuleiro com as casas especiais;
        populateBoard(BIRD_CHAR, birdTiles());
        populateBoard(PENALTY_CHAR, penaltyTiles);
        populateBoard(FALL_CHAR, fallTiles);

        //Popula os jogadores
        populatePlayers(playerOrder);
    }

    //Define as casas com pássaro
    private int[] birdTiles() {
        int[] birdTiles = new int[(NUMBER_OF_TILES -1)/ BIRD_TILE_MULT]; //vai até n-1 — a última casa nunca pode ser pássaro
        for (int i=0; i < birdTiles.length; i++) {
            birdTiles[i] = BIRD_TILE_MULT *(i+1);
        }
        return birdTiles;
    }

    //Popula o tabuleiro com as casas especiais
    private void populateBoard(char c, int[] tiles) { //Pre: !=null
        for (int i = 1; i <= tiles.length-2; i++) { //vai de C=2 a C=N-1 (1<i<=n-2)
            int specialTile = tiles[i];
            boardTiles[specialTile-1] = c;//casa especial N está na posição N-1 do vector
        }
    }

    //Cria a lista de jogadores PELA ORDEM COM QUE JOGAM
    private void populatePlayers(String playerOrder) { //Pre !=null; jogadores.length == NUMJOGADORES == 3
    //TODO
    }

    //Processa um turno
    private void nextTurn() {
    //TODO
    }
}
