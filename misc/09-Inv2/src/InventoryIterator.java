public class InventoryIterator {
    private Product[] inventory;
    private int size;
    private int nextIndex;

    public InventoryIterator(Product[] inventory, int size) {
        this.inventory = inventory;
        this.size = size;
        this.nextIndex = 0;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    public Product next() {
        return inventory[nextIndex++];
    }
}
