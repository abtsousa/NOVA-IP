/** CLASSE TABULEIRO (SISTEMA)
 * @author Afonso Brás Sousa
 * Inicia e gere o jogo
 * Define o formato do tabuleiro - número de casas e a ordem das casas "especiais"
 * Define 3 jogadores e a ordem com que iniciam
 * Actualiza a posição de cada jogador após cada turno
 */

public class Board {
    //Constantes
    private static final int NUMBER_OF_PLAYERS = 3;
    private static final int BIRD_TILE_MULT = 9; //define de quantas em quantas casas existe pássaro
    private static final char BIRD_CHAR = 'B'; //pássaro
    private static final char PENALTY_CHAR = 'P'; //multa
    private static final char FALL_CHAR = 'F'; //precipício

    //Variáveis de instância
    private final int tileNumber; //número de casas //Pre: >=10 && <=150
    private final char[] boardTiles; //vector de casas e tipo
    private final Player[] players; //lista de jogadores pela ordem com que jogam
    private int nextPlayer; //define ordem do próximo jogador a jogar

    //Constructor
    //Define o estado inicial do tabuleiro
    public Board(String playerOrder, //Pre: length==3;
                 int tileNumber, //Pre: >=10 && <=150
                 int[] penaltyTiles, //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
                 int[] fallTiles //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
    ) {
        this.tileNumber = tileNumber;

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
        int[] birdTiles = new int[(tileNumber -1)/ BIRD_TILE_MULT]; //vai até C-1
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
    private Player[] populatePlayers(String playersString) { //Pre !=null && length == 3
    char[] playerOrder = playersString.toCharArray();
    Player[] players = new Player[NUMBER_OF_PLAYERS];
    for (int i=0; i<NUMBER_OF_PLAYERS; i++) {
        char playerColor = playerOrder[i];
        players[i] = new Player(playerColor);
        }
    return players;
    }

    //Procura o jogador pela sua cor
    //Devolve o índice i do jogador com a cor procurada
    public int searchPlayer(char searchColor) {
        int i=NUMBER_OF_PLAYERS-1;
        while ( i>=0 && searchColor != players[i].getColor() ) {
            i--;
        }
        return i; //if not found ==> i=-1;
    }

    //comando-jogador
    public char getNextPlayer() {
        return players[nextPlayer].getColor();
    }

    //comando-casa
    public int getPlayerSquare(int index) {
        return players[index].getPosition();
    }

    //comando-estado
    public boolean getPlayerStatus(int index) {
        return players[index].canPlay();
    }

    //comando-lançamento
    //Processa um turno
    //TOTEST
    public void processNextTurn(int diceResult) {
    Player player = players[nextPlayer];
    int position = player.getPosition();
    char type = getSquareType(position);
    int nextPosition;

    //iniciar movimento
    if (type == FALL_CHAR) {nextPosition = position - diceResult;} //anda para trás
    else {nextPosition = position + diceResult;} // anda para a frente

    //assegurar que a jogada é válida
    if (nextPosition<0) {nextPosition=0;}
    else if (nextPosition>=tileNumber) {nextPosition=tileNumber-1;}

    if (getSquareType(nextPosition) == BIRD_CHAR) {
        nextPosition = Math.min(nextPosition + 9, tileNumber-1); //no out-of-bounds
    } else if (getSquareType(nextPosition) == PENALTY_CHAR) {player.applyPenalty(2);}


    player.movePlayer(nextPosition);
    //DEBUG T
    System.out.printf("Moving player %C %d -> %d (%c)\n",player.getColor(),position,nextPosition,getSquareType(nextPosition));
    passTurn();
    }

    private char getSquareType(int square) {
        return boardTiles[square];
    }

    //Passa a vez ao jogador seguinte
    private void passTurn() {
        nextPlayer++;
        if (nextPlayer>=NUMBER_OF_PLAYERS) {nextPlayer=0;}
        checkTurnSkip();
    }

    //Jogador multado não joga
    private void checkTurnSkip() {
        Player player = players[nextPlayer];
        if (!player.canPlay()) { //se o jogador não pode jogar
            player.lowerPenalty(); //diminui multa
            passTurn();
        }
    }

    //TOTEST searchForWinner & isGameOver
    //Procura se existe vencedor e devolve o seu índice
    private int searchForWinner() { //Pre: only 1 winner allowed
        int i=NUMBER_OF_PLAYERS-1;
        while (i>=0 && players[i].getPosition()+1!=tileNumber) { //posição N corresponde à casa N+1
            i--;
        }
        return i; //if not found ==> i=-1;
    }

    //Devolve a cor do vencedor
    //Pre: searchForWinner != -1
    public char getWinner() {
        return players[searchForWinner()].getColor();
    }

    //Devolve se o jogo terminou
    public boolean isGameOver() {
        return (searchForWinner() != -1);
    }
}
