public class Obj {
    private int value;
    private char letter;

    public Obj(int value, char letter) {
        this.value = value;
        this.letter = letter;
    }

    public void addValue(int val) {
        value += val;
    }

    public int getValue() {
        return value;
    }

    public char getLetter() {
        return letter;
    }
}
