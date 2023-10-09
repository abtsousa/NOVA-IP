public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private static void listing(CarOutlet outlet, int minimumPrice) {
        MinPriceCarModelIterator it = outlet.iterator(minimumPrice);
        while (it.hasNext()) {
            CarModel car = it.next();
            printCarModel(car);
        }
    }

    private static void printCarModel(CarModel car) {
        System.out.println();
    }
}