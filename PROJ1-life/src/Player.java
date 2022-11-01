/** CLASSE JOGADOR
 * @author Afonso Brás Sousa
 * Inicializa cada jogador
 * Objecto com 3 variáveis: cor da marca (char), posição P (int), multa/pena M (int)
 */

public class Player {
    //Constantes
    private static final int START_POSITION = 0;
    private static final int START_PENALTY = 0;

    // Variáveis que definem o jogador
    private final char color; //cor da marca //Pre: letra única para cada jogador
    private int position; //posição //Pre: >0 && <=Gameboard.numCasas
    private int penalty; //multa (impede de jogar) //Pre: >=0

    //Constructor
    public Player(char color) {
        this.color = color;
        this.position = START_POSITION; //assume casa inicial por defeito
        this.penalty = START_PENALTY; //assume multa inicial nula
    }

    //Getters
    //Devolvem a cor e a posição do jogador
    public char getColor() {
        return color;
    }
    public int getPosition() {
        return position;
    }

    //Devolve se o jogador pode jogar
    public boolean canPlay() {
        return penalty==0;
    }

    //Actualiza a posição do jogador
    public void movePlayer(int newPosition) {
        position = newPosition;
    }

    //Diminui a multa em 1
    //Pre: penalty > 0
    public void lowerPenalty() {
        penalty--;
    }

    public void applyPenalty(int penalty) {this.penalty = penalty;}
}