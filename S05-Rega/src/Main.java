import java.util.Scanner;

public class Main {

    private static Crop getCrop(Scanner in) {
        String nome = in.next(); in.nextLine();
        int min = in.nextInt(); in.nextLine();
        int max = in.nextInt(); in.nextLine();
        return new Crop(nome, min, max);
    }

    public static void main(String[] args) {
        //input start
        Scanner in = new Scanner(System.in);
        Crop crop1 = getCrop(in);
        Crop crop2 = getCrop(in);

        WaterStation ws1 = new WaterStation(crop1, crop2);
        int numDays = in.nextInt(); in.nextLine();
        for (int i=0; i<numDays; i++) {
            ws1.registerDay(in.nextLine());
        }
        in.close();

        //output start
        System.out.printf("%d dias adequadas para ambas\n",ws1.getNumDaysForBoth());
        if (ws1.areCropsEquivalent())
            System.out.println("Opções equivalentes");
        else
            System.out.printf("Opte por %s", ws1.getBestCropName());
    }
}