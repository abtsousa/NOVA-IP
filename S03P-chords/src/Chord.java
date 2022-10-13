public class Chord {
    private int n1, n2, n3;

    public Chord(int a, int b, int c) {
        n1=a;
        n2=b;
        n3=c;
    }

    //devolve a primeira nota
    public void printChord() {
        System.out.printf("%d %d %d", n1, n2, n3);
    }

    //devolve se o acorde é maior 0-4-7
    public boolean isMajor() {
        return (n2-n1==4 && n3-n1==7);
    }

    //devolve se o acorde é menor 0-3-7
    public boolean isMinor() {
        return (n2-n1==3 && n3-n1==7);
    }

    //devolve se os acordes são uníssonos
    public boolean isUnison(Chord other) {
      return ( (this.n1==other.n1) && (this.n2==other.n2) && (this.n3==other.n3));

        // se transpostos 12 notas:
        // return ((this.n1 - other.n1) % 12 ==0) && ((this.n2 - other.n2) % 12 ==0) && ((this.n3 - other.n3) % 12 ==0);
    }

    //devolve se formam 2 oitavas
    public boolean formsTwoOctaves(Chord other) {
        return (Math.abs(this.n1 - other.n1) == 12) && (Math.abs(this.n2 - other.n2) == 12) && (Math.abs(this.n3 - other.n3) == 12);
    }

    //devolve se os 4 acordes seguem a progressão POP
    public boolean isPopProgression(Chord c2, Chord c3, Chord c4) {
        return ( this.isMajor() && c2.isMajor() && c4.isMajor() && c3.isMinor() &&
                (Math.abs(this.n1 - c2.n1) == 7) &&
                (Math.abs(this.n1 - c3.n1) == 9) &&
                (Math.abs(this.n1 - c4.n1) == 5) );
    }

    // transpõe o acorde
    public void transpose(int halfSteps) {
        this.n1=this.n1+halfSteps;
        this.n2=this.n2+halfSteps;
        this.n3=this.n3+halfSteps;
    }
}
