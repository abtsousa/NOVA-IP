import java.util.Scanner;

public class Main {
    private static final int UBERX = 1;
    private static final int UBERX_TIME = 10;
    private static final int UBERX_DISTANCE = 80;
    private static final int UBERX_BASE = 100;
    private static final int UBERX_MINTARIF = 250;
    private static final int UBERXL = 2;
    private static final int UBERXL_TIME = 15;
    private static final int UBERXL_DISTANCE = 120;
    private static final int UBERXL_BASE = 150;
    private static final int UBERXL_MINTARIF = 350;

    private static int getPrice(int type, int time, int distance) {
        int price = 0;
        switch (type) {
            case UBERX: price=Math.max(UBERX_TIME*time + UBERX_DISTANCE*distance + UBERX_BASE, UBERX_MINTARIF); break;
            case UBERXL: price=Math.max(UBERXL_TIME*time + UBERXL_DISTANCE*distance + UBERXL_BASE, UBERXL_MINTARIF); break;
        }
        return price;
    }
    public static void main(String[] args) {
        //input
        Scanner in = new Scanner(System.in);

        int type = in.nextInt();
        int time = in.nextInt();
        int distance = in.nextInt();
        System.out.println(getPrice(type,time,distance));
    }
}