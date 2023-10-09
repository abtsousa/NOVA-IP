public class Main {
    public static void main(String[] args) {
        int sum = 1+2+3+4+5+6+7+8+9;
        int product = 1*2*3*4*5*6*7*8*9;
        int count=0;
        for (int n1=1; n1<10; n1++) {
        for (int n2=1; n2<10; n2++) {
        for (int n3=1; n3<10; n3++) {
        for (int n4=1; n4<10; n4++) {
        for (int n5=1; n5<10; n5++) {
        for (int n6=1; n6<10; n6++) {
        for (int n7=1; n7<10; n7++) {
        for (int n8=1; n8<10; n8++) {
        for (int n9=1; n9<10; n9++) {
            if (n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 == sum && n1 * n2 * n3 * n4 * n5 * n6 * n7 * n8 * n9 == product) {
                System.out.printf("%d %d %d %d %d %d %d %d %d\n", n1, n2, n3, n4, n5, n6, n7, n8, n9);
                count++;
            }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        System.out.printf("Soma = %d, Produto = %d, %d possibilidades",sum,product,count);
    }
}