import java.util.Scanner;

public class Main {
    private static MoneyCounter counter = new MoneyCounter();

    public static void main(String[] args) {
        //input start
        Scanner in = new Scanner(System.in);
        int maxWeight = in.nextInt();
        int capacity = in.nextInt(); in.nextLine();

        for (int i=0;i<capacity;i++) {
            int n = in.nextInt(); in.nextLine();
            counter.addCount(n);
        }

        int[] weightCount = counter.weighteredCount(maxWeight);
        System.out.println(counter.getSum(weightCount));
        for (int i=0; i<weightCount.length; i++) {
            if (weightCount[i]!=0) {
                System.out.printf("%d %d\n",counter.getEuros(i), weightCount[i]);
            }
        }
    }


}