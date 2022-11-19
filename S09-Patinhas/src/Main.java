import java.util.Scanner;

public class Main {
    private static MoneyCounter counter;

    public static void main(String[] args) {
        //input start
        Scanner in = new Scanner(System.in);
        int maxWeight = in.nextInt();
        int capacity = in.nextInt(); in.nextLine();

        for (int i=0;i<capacity;i++) {
            int n = in.nextInt(); in.nextLine();
            counter.addCount(n);
        }

        IntIterator it = counter.iterator(counter.weighteredCount(maxWeight));

        int i=0;
        while (it.hasNext()) { //Run iterator
            int next = it.next();
            if (next.getName().equals(name)) {return i;} //return index if found
            i++;
        }
    }


}