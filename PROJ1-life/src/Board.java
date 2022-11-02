/** BOARD CLASS (SYSTEM)
 * @author Afonso Brás Sousa
 * Starts the game and manages the game state
 * Defines the format of the board, how many tiles and which are "special"
 * Defines 3 players and their playing order
 * Updates the position of each player after each turn
 */

public class Board {
    //Constants
    private static final int NUMBER_OF_PLAYERS = 3;
    private static final int BIRD_TILE_MULT = 9; //defines a bird tile every N tiles
    private static final char BIRD_CHAR = 'B'; //bird character
    private static final char PENALTY_CHAR = 'P'; //penalty character
    private static final char FALL_CHAR = 'F'; //fall character

    //Instance variables
    private final int tileNumber; //how many tiles //Pre: >=10 && <=150
    private final char[] boardTiles; //tile array, saves each tile's "type"
    private final Player[] players; //players array in order
    private int nextPlayer; //defines who plays next

    //Constructor
    //Defines the inicial game state
    public Board(String playerOrder, //Pre: length==3;
                 int tileNumber, //Pre: >=10 && <=150
                 int[] penaltyTiles, //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
                 int[] fallTiles //Pre: >=1 && <=tileNumber-2 && size>=1 && size<=(tileNumber/3)
    ) {
        this.tileNumber = tileNumber;

        //Initializes the board
        boardTiles = new char[tileNumber];

        //Populates the board with "special" tiles
        populateBoard(BIRD_CHAR, birdTiles());
        populateBoard(PENALTY_CHAR, penaltyTiles);
        populateBoard(FALL_CHAR, fallTiles);

        //Populates the player list in order of play and sets the first player to start
        players = populatePlayers(playerOrder);
        nextPlayer = 0;
    }

    //Defines the birdTiles
    private int[] birdTiles() {
        int[] birdTiles = new int[(tileNumber -1)/ BIRD_TILE_MULT]; //goes to C-1
        for (int i=0; i < birdTiles.length; i++) {
            birdTiles[i] = BIRD_TILE_MULT *(i+1);
        }
        return birdTiles;
    }

    //Populates the board with "special" tiles
    private void populateBoard(char c, int[] tiles) { //Pre: !=null
        for (int i = 0; i < tiles.length; i++) {
            int specialTile = tiles[i];
            boardTiles[specialTile-1] = c; //special tile N is in array position N-1
        }
    }

    //Creates the player list in order
    private Player[] populatePlayers(String playersString) { //Pre !=null && length == 3
    char[] playerOrder = playersString.toCharArray();
    Player[] players = new Player[NUMBER_OF_PLAYERS];
    for (int i=0; i<NUMBER_OF_PLAYERS; i++) {
        char playerColor = playerOrder[i];
        players[i] = new Player(playerColor);
        }
    return players;
    }

    //Searches for a player by their color
    //Returns index i of the player list array
    public int searchPlayer(char searchColor) {
        int i=NUMBER_OF_PLAYERS-1;
        while ( i>=0 && searchColor != players[i].getColor() ) {
            i--;
        }
        return i; //if not found ==> i=-1;
    }

    //Player command
    //Returns the color of the next player to roll the dice
    public char getNextPlayer() {
        return players[nextPlayer].getColor();
    }

    //Square command
    //Returns the position of the requested player
    public int getPlayerSquare(int index) {
        return players[index].getPosition();
    }

    //Status command
    //Returns if the requested player can roll the dice when it's their turn
    public boolean getPlayerStatus(int index) {
        return players[index].canPlay();
    }

    //Dice command
    //Processes one turn
    public void processNextTurn(int diceResult) {
        Player player = players[nextPlayer];
        int position = player.getPosition();

        //Movement start
        int nextPosition = Math.min(position + diceResult, tileNumber-1); //no out-of-bounds
        char type = getSquareType(nextPosition);

        switch (type) {
            case FALL_CHAR:
                nextPosition = Math.max(position - diceResult, 0); //no out-of-bounds
                break;
            case BIRD_CHAR:
                nextPosition = Math.min(nextPosition + 9, tileNumber-1); //no out-of-bounds
                break;
            case PENALTY_CHAR:
                player.applyPenalty(2);
                break;
        }

        player.movePlayer(nextPosition);

        passTurn();
    }

    //Returns the "type" of the requested square
    private char getSquareType(int square) {
        return boardTiles[square];
    }

    //Passes the turn to the next player
    private void passTurn() {
        nextPlayer++;
        if (nextPlayer>=NUMBER_OF_PLAYERS) {nextPlayer=0;}
        checkTurnSkip(); //checks if next player has a penalty
    }

    //A fined player must skip a turn
    private void checkTurnSkip() {
        Player player = players[nextPlayer];
        if (!player.canPlay()) { //if the player cannot play
            player.lowerPenalty(); //lower their penalty by 1
            passTurn();
        }
    }

    //Searches for a winner and returns their index
    private int searchForWinner() { //Pre: only 1 winner allowed
        int i=NUMBER_OF_PLAYERS-1;
        while (i>=0 && players[i].getPosition()+1!=tileNumber) { //position N == square N+1
            i--;
        }
        return i; //if not found ==> i == -1;
    }

    //Returns the winning player's color
    //Pre: searchForWinner != -1
    public char getWinner() {
        return players[searchForWinner()].getColor();
    }

    //Returns if the game is over
    public boolean isGameOver() {
        return (searchForWinner() != -1);
    }
}
