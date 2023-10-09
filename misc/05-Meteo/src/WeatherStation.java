public class WeatherStation {
    //Constantes
    private static final int DEFAULT_CAPACITY = 1;
    private static final int GROWTH_RATE = 2;

    //Inicializa variáveis de instância
    private double[] samples;
    private int size = 0;

    private boolean isFull() {
        return size == samples.length;
    }

    private void grow() {
        double[] tmp = new double[GROWTH_RATE * samples.length];
        for (int i=0; i<size; i++) {
            tmp[i] = samples[i];
            }
        samples = tmp;
    }

    //Regista a amostra
    public void addSample(double temp) {
        if(isFull()) {grow();}
        samples[size++] = temp;
        //equivale a samples[size]=temp; size++;
    }

    //Remove a amostra da posição n (índice n-1)
    public void removeFrom(int pos) {
        for (int i=pos-1; i<size-1; i++) { //vai até size-2 uma vez que o último elemento estará na posição size-1
            samples[i]=samples[i+1];
        }
        size--;
    }

    //Insere a amostra na posição n (índice n-1)
    public void insertAt(double temp, int pos) {
        openSpace(pos);
        samples[pos-1] = temp;
    }

    //Abre espaço na posição n (índice n-1)
    private void openSpace(int pos) {
        for (int i=size; i>pos-1; i--) { //vai até pos
            samples[i]=samples[i-1];
        }
        size++;
    }

    //Devolve o valor máximo de temperatura
    public double getMaximum() {
        double max = samples[0];
        for (int i=1; i<size; i++) {
            if (samples[i] > max) {
                max = samples[i];
            }
        }
        return max;
    }

    //Devolve o valor mínimo de temperatura
    public double getMinimum() {
        double min = samples[0];
        for (int i=1; i<size; i++) {
            if (samples[i] < min) {
                min = samples[i];
            }
        }
        return min;
    }

    //Devolve o valor médio de temperatura
    public double getAverage() {
        double sum = 0;
        for (int i=0; i<size; i++) {
            sum += samples[i];
        }
        return sum/size;
    }

    //Devolve um valor de temperatura
    // pre: i > 0 && i <= numberOfSamples()
    public double getSample(int t) {
        return samples[t-1];
    }

    //Devolve último se não for dado parâmetro
    public double getSample() {
        return samples[size-1];
    }

    //Devolve o n.º de amostras
    public int getNumberOfSamples() {
        return size;
    }

    //Devolve o primeiro n.º de ordem (i+1) da primeira ocorrência da temperatura
    public int firstOcurrenceOfSample(double temp) {
        int i = 0;
        while (i<size && temp != samples[i]) {i++;}
        if (i==size) {return 0;} else {return i+1;}
    }

    //Devolve o último n.º de ordem (i+1) da primeira ocorrência da temperatura
    public int lastOcurrenceOfSample(double temp) {
        int i = size;
        while (i>0 && temp != samples[i]) {i--;}
        if (i==0) {return 0;} else {return i+1;}
    }

    //Devolve o n.º de amostras maiores que temp
    public int countSamplesGreaterThan(double temp) {
        int count = 0;
        for (int i=0; i<size; i++) {
            if (samples[i]>temp) {count++;}
        }
        return count;
    }

    //Devolve o n.º de amostras menores que temp
    public int countSamplesLowerThan(double temp) {
        int count = 0;
        for (int i=0; i<size; i++) {
            if (samples[i]<temp) {count++;}
        }
        return count;
    }

    //Devolve o n.º de amostras menores que zero
    public double percentageOfNegatives() {
        double count = 0;
        for (int i=0; i<size; i++) {
            if (samples[i]<0) {count++;}
        }
        return (count/size)*100;
    }

    //Imprime a amostra
    public void printSamples() {
        for (int i=0; i<size; i++) {
            System.out.print(samples[i]);
            System.out.print("; ");
        }
        System.out.println();
    }

    //Constructors
    public WeatherStation() {
        samples = new double[DEFAULT_CAPACITY];
    }

    /*
    public WeatherStation(int i) {
        samples = new double[i];
    } */
}
