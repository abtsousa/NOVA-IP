import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WeatherStation ws1 = new WeatherStation();

        do {
            System.out.print("Valor: ");
            if (in.hasNextDouble()) { // Check for numeric value
                ws1.addSample(in.nextDouble()); // Read and store value
                in.nextLine();
            }
        } while (in.hasNextDouble());
        in.close();

        // Full listing
        for (int i=1; i <= ws1.getNumberOfSamples(); i++) {
            System.out.println(i + ".ª temperatura: " + ws1.getSample(i));
        }


        // Testes
        /*
        for (int i=0; i<5; i++) {
            ws1.addSample(in.nextInt());
        }
        in.close();
        System.out.println(ws1.getNumberOfSamples());
        ws1.printSamples();
        ws1.insertAt(7,3);
        System.out.println(ws1.getNumberOfSamples());
        ws1.printSamples();
        ws1.removeFrom(1);
        System.out.println(ws1.getNumberOfSamples());
        ws1.printSamples();
        System.out.println(ws1.firstOcurrenceOfSample(10));
        System.out.println(ws1.lastOcurrenceOfSample(10));
        System.out.println(ws1.countSamplesLowerThan(10));
        System.out.println(ws1.countSamplesGreaterThan(10));
        System.out.println(ws1.percentageOfNegatives());
        System.out.println(ws1.getAverage());
        System.out.println(ws1.getMaximum());
        System.out.println(ws1.getMinimum());
        System.out.println(ws1.getSample(1));
        System.out.println(ws1.getSample(2));
        System.out.println(ws1.getSample(3));
        System.out.println(ws1.getSample());
        System.out.println(ws1.getNumberOfSamples());
        */
    }
}