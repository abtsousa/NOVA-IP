public class Product {
    private String name;
    private int price;
    private int qty;

    public Product(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int comparePrice(Product other) {
        return this.price - other.price;
    }

    public int compareQty(Product other) {
        return this.qty - other.qty;
    }

    public int compareName(Product other) {
        return this.name.compareTo(other.name);
    }

    public int nestedCompare(Product other) {
        if (comparePrice(other)!=0) {
            return comparePrice(other);
        } else if (compareQty(other)!=0) {
            return compareQty(other)*(-1); //ordem crescente
        } else {
            return compareName(other)*(-1); //ordem crescente
        }
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
