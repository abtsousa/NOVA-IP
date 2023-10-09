public class ObjIterator {
    private Obj[] list;
    private int size;
    private int nextIndex;

    public ObjIterator(Obj[] list, int size) {
        this.list = list;
        this.size = size;
        this.nextIndex = 0;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    public Obj next() {
        return list[nextIndex++];
    }
}
