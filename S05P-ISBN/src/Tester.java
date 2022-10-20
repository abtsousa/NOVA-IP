public class Tester {
    private String codeString;

    //calcula o 13.º dígito de teste dados 12 dígitos
    public int calculateVD() {
        char[] sArray = codeString.toCharArray();
        int sLen = sArray.length;
        int multiplier, validSum = 0;
        for (int i = 0; i < sLen-1; i++) {
            int sCharInt = Character.getNumericValue(sArray[i]);
            if (i%2==0) {multiplier=1;} else {multiplier=3;}
            validSum += sCharInt * multiplier;
        }
        int validRest = validSum % 10;
        return 10-validRest;
    }

    //devolve se o código é válido
    public boolean isValid() {
        int sLen = codeString.length();
        char sLast = codeString.charAt(sLen-1);
        return (Character.getNumericValue(sLast) == calculateVD());
    }

    /* Ultrapassa o limite do int pq java == fecaloma
    private int stringToDouble(String s) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;
        double sInt = 0; //tem de ser DOUBLE porque ultrapassa o limite do INT do Java
        for (int i = 0; i < sLen; i++) {
            int sCharInt = Character.getNumericValue(sArray[sLen-1-i]);
            sInt += sCharInt * Math.pow(10,i);
        }
        return sInt;
    } */

    //Constructor
    //Separa a string em 12+1 caracteres
    public Tester(String c) {
        codeString = c;
        //Testes
        /*
        System.out.println(validationDigit);
        System.out.println(codeString13);
        System.out.println(codeString12);
        System.out.println(validationDigit); */
    }
}

//LFG ABS