public class IntIterator {
    private int[] list;
    private int size;
    private int nextIndex;

    public IntIterator(int[] list, int size) {
        this.list = list;
        this.size = size;
        this.nextIndex = 0;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    public int next() {
        return list[nextIndex++];
    }
}
