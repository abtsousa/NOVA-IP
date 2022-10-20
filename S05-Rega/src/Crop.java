public class Crop {
    private String name;
    private int minDrops;
    private int maxDrops;
    public Crop(String a, int b, int c) {
        name = a;
        minDrops = b;
        maxDrops = c;
    }

    public boolean isGoodDay(int drops) {
        return (drops >= minDrops && drops <= maxDrops);
    }

    public String getName() {
        return name;
    }
}
