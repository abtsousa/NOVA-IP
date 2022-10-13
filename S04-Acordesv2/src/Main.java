import java.util.Scanner;

public class Main {

    private static final String TRP = "TRP";
    private static final String MAJ = "MAJ";
    private static final String MIN = "MIN";
    private static final String UNI = "UNI";
    private static final String OCT = "OCT";
    private static final String POP = "POP";
    //private static final String PRINT = "PRT";
    private static final String EXITCMD = "SAIR";
    private static final int MIN_NOTE = 1;
    private static final int MAX_NOTE = 88;

    //transforma input em Chord
    private static Chord getChord(Scanner in) {
        int n1=in.nextInt();
        int n2=in.nextInt();
        int n3=in.nextInt();
        in.nextLine();
        if (n1<n2 && n2<n3 && n1 >=MIN_NOTE && n3 <=MAX_NOTE) {
            return new Chord(n1, n2, n3);
        } else {
            System.out.println("Acorde inválido.");
            return null;
        }
    }

    private static void getChordsLoop() {

    }

    //vai buscar a N-ésima Chord
    private static Chord loadChord(int cnumber, Chord c1, Chord c2, Chord c3, Chord c4) {
        Chord cReturn = new Chord(0,0,0);
        switch (cnumber) {
            case 1: cReturn=c1; break;
            case 2: cReturn=c2; break;
            case 3: cReturn=c3; break;
            case 4: cReturn=c4; break;
        }
        return cReturn;
    }

    private static void executeOptionLoop(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
        int ch_input, ch_input2, hs;
        Chord ch, ch2;
        boolean app_exit = false;
        while (!app_exit) {
            String optn = in.next();
            switch (optn) {
                case TRP:
                    // fetch chord
                    ch_input = in.nextInt();
                    // fetch half-steps
                    hs = in.nextInt();
                    if (ch_input < 1 || ch_input > 4) {
                        System.out.println("Acorde inexistente.");
                    } else if (hs <= 0) {
                        System.out.println("Número de semitons inválido.");
                    } else {
                        ch = loadChord(ch_input, c1, c2, c3, c4);
                        if (ch.getNote(3) + hs > MAX_NOTE) {
                            System.out.println("Transposição inválida.");
                        } else {
                            ch.transpose(hs);
                            // print result
                            System.out.printf("O acorde %d foi transposto %d semitons.\n", ch_input, hs);
                        }
                    }
                    break;
                case MAJ:
                    // fetch chord
                    ch_input = in.nextInt();
                    if (ch_input < 1 || ch_input > 4) {
                        System.out.println("Acorde inexistente.");
                    } else {
                        ch = loadChord(ch_input, c1, c2, c3, c4);
                        if (ch.isMajor()) {
                            System.out.printf("O acorde %d é um acorde maior.\n", ch_input);
                        } else {
                            System.out.printf("O acorde %d não é um acorde maior.\n", ch_input);
                        }
                    }
                    break;
                case MIN:
                    // fetch chord
                    ch_input = in.nextInt();
                    if (ch_input < 1 || ch_input > 4) {
                        System.out.println("Acorde inexistente.");
                    } else {
                        ch = loadChord(ch_input, c1, c2, c3, c4);
                        if (ch.isMinor()) {
                            System.out.printf("O acorde %d é um acorde menor.\n", ch_input);
                        } else {
                            System.out.printf("O acorde %d não é um acorde menor.\n", ch_input);
                        }
                    }
                    break;
                case UNI:
                    // fetch chords
                    ch_input = in.nextInt();
                    ch_input2 = in.nextInt();
                    if (ch_input < 1 || ch_input > 4) {
                        System.out.println("Primeiro acorde inexistente.");
                    } else if (ch_input2 < 1 || ch_input2 > 4) {
                        System.out.println("Segundo acorde inexistente.");
                    } else {
                        ch = loadChord(ch_input, c1, c2, c3, c4);
                        ch2 = loadChord(ch_input2, c1, c2, c3, c4);
                        if (ch.isUnison(ch2)) {
                            System.out.println("Os acordes são uníssonos.");
                        } else {
                            System.out.println("Os acordes não são uníssonos.");
                        }
                    }
                    break;
                case OCT:
                    // fetch chords
                    ch_input = in.nextInt();
                    ch_input2 = in.nextInt();
                    if (ch_input < 1 || ch_input > 4) {
                        System.out.println("Primeiro acorde inexistente.");
                    } else if (ch_input2 < 1 || ch_input2 > 4) {
                        System.out.println("Segundo acorde inexistente.");
                    } else {
                        ch = loadChord(ch_input, c1, c2, c3, c4);
                        ch2 = loadChord(ch_input2, c1, c2, c3, c4);
                        if (ch.formsTwoOctaves(ch2)) {
                            System.out.println("As notas formam um acorde de duas oitavas.");
                        } else {
                            System.out.println("As notas não formam um acorde de duas oitavas.");
                        }
                    }
                    break;
                case POP:
                    if (c1.isPopProgression(c2, c3, c4)) {
                        System.out.println("É um exemplo da progressão pop.");
                    } else {
                        System.out.println("Não é um exemplo da progressão pop.");
                    }
                    break;
/*                case PRINT:
                    ch_input = in.nextInt();
                    ch = loadChord(ch_input, c1, c2, c3, c4);
                    ch.printChord();
                    break;*/
                case EXITCMD:
                    app_exit = true;
            }
        in.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //4 linhas = 4 acordes
        Chord c1 = getChord(in);
        if (c1!=null) {
            Chord c2 = getChord(in);
            if (c2 != null) {
                Chord c3 = getChord(in);
                if (c3 != null) {
                    Chord c4 = getChord(in);
                    if (c4 != null) {
                        executeOptionLoop(in, c1, c2, c3, c4);
                    }
                }
            }
        }
        in.close();
    }
}