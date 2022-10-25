/* CLASSE JOGADOR
 * @author Afonso Brás Sousa
 * Inicializa cada jogador
 * Objecto com variáveis: cor da marca (char), posição P (int), multa/pena M (int)
 */

public class Player {
    // Variáveis que definem o jogador
    private final char color; //cor da marca //Pre: letra única para cada jogador
    private int position; //posição //Pre: >0 && <=Gameboard.numCasas
    private int penalty; //multa (impede de jogar) //Pre: >=0
    private static final int START_POSITION = 0;
    private static final int START_PENALTY = 0;

    //Constructor
    public Player(char color, int position, int penalty) {
        this.color = color;
        this.position = position;
        this.penalty = penalty;
    }

    //Constructor alternativo (1 parâmetro)
    public Player(char color) {
        this.color = color;
        this.position = START_POSITION; //assume casa inicial por defeito
        this.penalty = START_PENALTY; //assume multa inicial nula
    }

    //Getters
    public char getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    //Indica se o jogador pode jogar
    public boolean canPlay() {
        return penalty==0;
    }

    //Actualiza posição com base no resultado do dado
    //Pre: canPlay==true && posição final <= Gameboard.numCasas
    void movePlayer(int newPosition) {
        position = newPosition;
    }

    //Diminui a multa em 1
    //Pre: penalty > 0
    void lowerPenalty() {
        penalty--;
    }
}