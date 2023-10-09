public class Product {
    private String name;
    private int price;
    private int qty;

    public Product(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void changeQty(int add) {
        qty += add;
    }
}
