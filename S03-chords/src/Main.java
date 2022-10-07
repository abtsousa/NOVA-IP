import java.util.Scanner;

public class Main {

    private static final String TRP = "TRP";
    private static final String MAJ = "MAJ";
    private static final String MIN = "MIN";
    private static final String UNI = "UNI";
    private static final String OCT = "OCT";
    private static final String POP = "POP";

    //transforma input em Chord
    private static Chord getChord(Scanner in) {
        int n1=in.nextInt();
        int n2=in.nextInt();
        int n3=in.nextInt();
        in.nextLine();
        return new Chord(n1,n2,n3);
    }

    //vai buscar a N-ésima Chord
    private static Chord loadChord(int cnumber, Chord c1, Chord c2, Chord c3, Chord c4) {
        Chord cReturn = new Chord(0,0,0);
        switch (cnumber) {
            case 1: cReturn=c1; break;
            case 2: cReturn=c2; break;
            case 3: cReturn=c3; break;
            case 4: cReturn=c4;break;
        }
        return cReturn;
    }

    //grava a N-ésima chord
    private static void saveChord(int cnumber, Chord newChord, Chord c1, Chord c2, Chord c3, Chord c4) {
        switch (cnumber) {
            case 1: c1=newChord; break;
            case 2: c2=newChord; break;
            case 3: c3=newChord; break;
            case 4: c4=newChord; break;
        }
    }

    private static void executeOption(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
        String optn = in.next();
        switch (optn) {
            case TRP:
                // fetch chord
                int ch_input=in.nextInt();
                Chord ch = loadChord(ch_input,c1,c2,c3,c4);
                // fetch half-steps
                int hs=in.nextInt();
                ch.transpose(hs);
                saveChord(ch_input,ch,c1,c2,c3,c4);
                // print result
                System.out.printf("O acorde %d foi transposto %d semi-tons.\n",ch_input,hs);
                break;
            case MAJ:
                // fetch chord
                ch_input=in.nextInt();
                ch = loadChord(ch_input,c1,c2,c3,c4);
                if (ch.isMajor()) {
                    System.out.printf("O acorde %d é um acorde maior.\n",ch_input);
                } else {
                    System.out.printf("O acorde %d não é um acorde maior.\n",ch_input);
                }
                break;
            case MIN:
                // fetch chord
                ch_input=in.nextInt();
                ch = loadChord(ch_input,c1,c2,c3,c4);
                if (ch.isMinor()) {
                    System.out.printf("O acorde %d é um acorde menor.\n",ch_input);
                } else {
                    System.out.printf("O acorde %d não é um acorde menor.\n",ch_input);
                }
                break;
            case UNI:
                // fetch chords
                ch_input=in.nextInt();
                ch = loadChord(ch_input,c1,c2,c3,c4);
                int ch_input2=in.nextInt();
                Chord ch2 = loadChord(ch_input2,c1,c2,c3,c4);
                if (ch.isUnison(ch2)) {
                    System.out.println("Os acordes são uníssonos.");
                } else {
                    System.out.println("Os acordes não são uníssonos.");
                }
                break;
            case OCT:
                // fetch chords
                ch_input=in.nextInt();
                ch = loadChord(ch_input,c1,c2,c3,c4);
                ch_input2=in.nextInt();
                ch2 = loadChord(ch_input2,c1,c2,c3,c4);
                if (ch.formsTwoOctaves(ch2)) {
                    System.out.println("As notas formam um acorde de duas oitavas.");
                } else {
                    System.out.println("As notas não formam um acorde de duas oitavas.");
                }
                break;
            case POP:
                if (c1.isPopProgression(c2,c3,c4)) {
                    System.out.println("É um exemplo da progressão pop.");
                } else {
                    System.out.println("Não é um exemplo da progressão pop.");
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //4 linhas = 4 acordes
        Chord c1 = getChord(in);
        Chord c2 = getChord(in);
        Chord c3 = getChord(in);
        Chord c4 = getChord(in);

        executeOption(in,c1,c2,c3,c4);
        executeOption(in,c1,c2,c3,c4);
        executeOption(in,c1,c2,c3,c4);
        executeOption(in,c1,c2,c3,c4);
        executeOption(in,c1,c2,c3,c4);
    }
}