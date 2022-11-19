public class MoneyCounter {
    private static final int[] EUROS = {500,200,100,50,20,10,5,2,1};
    private static int[] count = new int[EUROS.length];
    private static final int COIN_MAX_VALUE = 2;

    //Retorna o índice do vector EUROS
    //-1 se inválido
    private int getIndex(int n) {
        int i=0;
        while (i<EUROS.length && EUROS[i] != n) {
            i++;
        }
        if (i==EUROS.length) {return -1;} else {return i;}
    }

    public int getCount(int n) {
        int i = getIndex(n);
        return count[i];
    }

    public void addCount(int n) {
        int i = getIndex(n);
        count[i]++;
    }

    private int getWeight(int n) {
        if (n <= COIN_MAX_VALUE) {return 5;} else {return 1;}
    }

    public int[] weighteredCount(int maxWeight) {
        int weight = 0;
        int[] weightCount = new int[EUROS.length];
        int i = 0;
        do {
            if (weightCount[i] < count[i] && weight + getWeight(EUROS[i]) <= maxWeight) {
                weightCount[i]++;
                weight += getWeight(EUROS[i]);
            } else {
                i++;
            }
        } while (weight <= maxWeight);
        return weightCount;
    }


    public IntIterator iterator(int[] list) {
        return new IntIterator(list,list.length);
    }
}
