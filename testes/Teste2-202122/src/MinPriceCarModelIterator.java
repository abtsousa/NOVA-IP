public class MinPriceCarModelIterator {
    // Coloque aqui as constantes e as variáveis de instância.
    private CarModel[] models;
    private int size;
    private int minimumPrice;
    private int nextIndex;

    /**
     * construtor: Inicializa o iterador.
     *
     * @pre: models != null && size >= 0 && minimumPrice > 0
     */
    public MinPriceCarModelIterator(CarModel[] models, int size, int minimumPrice) {
        this.models = models;
        this.size = size;
        this.minimumPrice = minimumPrice;
        nextIndex = 0;
        advance();
    }

    /**
     * @return true se ainda existir algum elemento da sequência para next() retornar;
     * false caso contrário.
     */
    public boolean hasNext() {
        return nextIndex < size;
    }

    public CarModel next() {
        CarModel car = models[nextIndex++];
        advance();
        return car;
    }

    public void advance() {
        while (nextIndex < size && models[nextIndex].getPrice() < minimumPrice) {
            nextIndex++;
        }
    }
}

