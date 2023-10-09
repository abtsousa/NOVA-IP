public class Main {
    public static Obj[] vec;

    public static void main(String[] args) {
        vec = new Obj[3];
        vec[0] = new Obj(1,'a');
        vec[1] = new Obj(2,'b');
        vec[2] = new Obj(3,'c');
        printAll(vec);
        addTo('a',3);
        printAll(vec);

    }

    public static void addTo(char letter, int value) {
        ObjIterator it = new ObjIterator(vec, 3);
        Obj obj;
        do {
            obj = it.next();
        } while (it.hasNext() && obj.getLetter()!=letter);
        obj.addValue(value);
    }

    public static void printAll(Obj[] vec) {
        ObjIterator it = new ObjIterator(vec, 3);
        while (it.hasNext()) {
            Obj obj = it.next();
            System.out.println(obj.getLetter());
            System.out.println(obj.getValue());
        }
    }
}

