import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String CMD_EXIT = "SAIR";
    private static final String CMD_ADD = "AP";
    private static final String CMD_REMOVE = "RP";
    private static final String CMD_QTY_PLUS = "AQP";
    private static final String CMD_QTY_MINUS = "DQP";
    private static final String CMD_LIST = "L";
    private static final String CMD_ORD_LIST = "LO";
    private static final String CMD_OOS_LIST = "PE";
    private static final String CMD_VALUE = "VT";


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Scanner file = new Scanner(new FileReader(in.nextLine().trim()));
        Inventory invent = loadFromFile(file);
        executeCmdLoop(invent, in);
        in.close();
    }

    private static Inventory loadFromFile(Scanner file) {
        int numberOfProducts = file.nextInt(); file.nextLine();
        Inventory invent = new Inventory();
        for (int i=0; i<numberOfProducts; i++) {
            String name = file.next();
            int price = file.nextInt();
            int qty = file.nextInt();
            invent.addProductFromFile(name,price,qty);
        }
        return invent;
    }

    private static void executeCmdLoop(Inventory invent, Scanner in) {
        String cmd, name;
        int price, qty;
        do {
            cmd = in.nextLine().trim(); //command
            switch (cmd) {
                case CMD_EXIT:
                    System.out.printf("O stock totaliza %d items\n", invent.getInventoryQty());
                    break;
                case CMD_ADD:
                    name = in.nextLine();
                    price = in.nextInt();
                    qty = in.nextInt(); in.nextLine();
                    invent.addProduct(name,price,qty);
                    break;
                case CMD_REMOVE:
                    name = in.nextLine();
                    invent.removeProduct(name);
                    break;
                case CMD_QTY_PLUS:
                    name = in.nextLine();
                    qty = in.nextInt(); in.nextLine();
                    invent.growQty(name,qty);
                    break;
                case CMD_QTY_MINUS:
                    name = in.nextLine();
                    qty = in.nextInt(); in.nextLine();
                    invent.shrinkQty(name,qty);
                    break;
                case CMD_LIST:
                    invent.listAll(invent.iterator());
                    break;
                case CMD_ORD_LIST:
                    invent.listAll(invent.sorteredIterator());
                    break;
                case CMD_OOS_LIST:
                    invent.listAll(invent.filteredIterator());
                    break;
                case CMD_VALUE:
                    invent.getInventoryValue();
                    break;
            }
        } while (!cmd.equals(CMD_EXIT));
    }
}