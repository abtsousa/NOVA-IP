/* CLASSE JOGADOR
- Inicializa cada jogador como um objecto com variáveis que o define
    - Variáveis: cor da marca (char), posição P (int), multa/pena M (int)
 */

public class Player {
    // Variáveis que definem o jogador
    private final char color; //cor da marca //Pre: letra única para cada jogador
    private int position; //posição //Pre: >0 && <=Gameboard.numCasas
    private int penalty; //multa (impede de jogar) //Pre: >=0

    //Constructor
    public Player(char color, int position, int penalty) {
        this.color = color;
        this.position = position;
        this.penalty = penalty;
    }

    //Constructor alternativo (1 parâmetro)
    public Player(char color) {
        this.color = color;
        this.position = 1; //assume casa inicial por defeito
        this.penalty = 0; //assume multa inicial nula
    }

    //Getters
    public char getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public int getPenalty() {
        return penalty;
    }

    //Actualiza posição com base no resultado do dado
    //Pre: this.multa == 0 && posição final <= Gameboard.numCasas
    void movePlayer(int dice_result) {
        position = position + dice_result;
    }

    //Diminui a multa em 1
    //Pre: penalty > 0
    void lowerPenalty() {
        penalty--;
    }
}