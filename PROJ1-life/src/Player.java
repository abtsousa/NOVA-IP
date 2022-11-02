/** PLAYER CLASS
 * @author Afonso Brás Sousa
 * Initializes each player
 * Object with 3 variables stored: color (char), position (int), penalty (int)
 */

public class Player {
    //Constants
    private static final int START_POSITION = 0;
    private static final int START_PENALTY = 0;

    //Variables that define each player
    private final char color; //Pre: unique character ('A' - 'Z')
    private int position; //Pre: >=0 && <=Board.tileNumber-1
    private int penalty; //Pre: >=0

    //Constructor
    public Player(char color) {
        this.color = color;
        this.position = START_POSITION; //assumes default position
        this.penalty = START_PENALTY; //assumes default penallty
    }

    //Getters
    //Return the player's color and position
    public char getColor() {
        return color;
    }
    public int getPosition() {
        return position;
    }

    //Returns if the player can play
    public boolean canPlay() {
        return penalty==0;
    }

    //Updates the player's position
    public void movePlayer(int newPosition) {
        position = newPosition;
    }

    //Lowers the player's penalty by 1
    //Pre: penalty > 0
    public void lowerPenalty() {
        penalty--;
    }

    public void applyPenalty(int penalty) {this.penalty = penalty;}
}