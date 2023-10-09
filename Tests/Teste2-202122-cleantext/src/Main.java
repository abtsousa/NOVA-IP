public class Main {
    public static void main(String[] args) {
        char[] text = "abc   ,   ok  p".toCharArray();
        clean(text);
        System.out.println(text);
    }

    private static void clean(char[] text) {
        for (int i=2; i<text.length; i++) {
            while (text[i] == text[i-1] && text[i] == ' ' && text[i-2]==',') {
                for (int j=i; j<text.length-1; j++) {
                    text[j]=text[j+1];
                }
                text[text.length-1]='-';
            }
        }
    }
}