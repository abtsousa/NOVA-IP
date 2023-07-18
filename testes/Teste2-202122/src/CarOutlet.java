import java.io.*;
import java.util.Scanner;
public class CarOutlet {

    //Constantes e variáveis de instância
    private CarModel[] cars;
    private int size;

    /**
     * construtor: Inicializa o objeto com a capacidade especificada e
     *                                              zero modelos registados.
     * @pre: capacity > 0
     */
    public CarOutlet(int capacity) {
        cars = new CarModel[capacity];
        size = 0;
    }

    /**
     * construtor de CarOutlet: Lê os dados a partir do ficheiro com o nome indicado.
     */
    public CarOutlet(String filename) throws FileNotFoundException {
        Scanner file = new Scanner(new FileReader(filename));
        int capacity = file.nextInt(); file.nextLine();
        cars = new CarModel[capacity];
        for (int i=0; i<size; i++) {
            String brandName = file.nextLine().trim();
            String modelName = file.nextLine().trim();
            int price = file.nextInt(); file.nextLine();
            int stock = file.nextInt(); file.nextLine();
            int sold = file.nextInt(); file.nextLine();
            addModel(brandName, modelName, price, stock, sold);
        }
        file.close();
    }

    /**
     * @return número de modelos registados.
     */
    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == cars.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @pre: brandName != null && modelName != null
     * @return true se existir o modelo identificado pelo nome da marca e pelo nome do
     * modelo (mesmo que o seu stock seja zero); false caso contrário
     */
    public boolean exists(String brandName, String modelName) {
        MinPriceCarModelIterator it = iterator(0); //@pre price >0
        while (it.hasNext()){
            CarModel car = it.next();
            if (car.getBrandName().equals(brandName) && car.getModelName().equals(modelName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regista um novo modelo de automóvel.
     * @pre brandName != null && modelName != null && price > 0
     * && !exists(brandName, modelName) && !isFull() && stock >= 0
     */
    public void addModel(String brandName, String modelName, int price, int stock) {
        cars[size++] = new CarModel(brandName, modelName, price, stock);
    }

    public void addModel(String brandName, String modelName, int price, int stock, int sold) {
        cars[size++] = new CarModel(brandName, modelName, price, stock, sold);
    }


    /**
     * Aumenta o stock de um modelo já registado. Não regista novos modelos.
     * @pre: brandName != null && modelName != null && exists(brandName, modelName) && quantity > 0
     */
    public void addToStock(String brandName, String modelName, int quantity) {
        MinPriceCarModelIterator it = iterator(0);
        CarModel car;
        do {
            car = it.next();
        } while (it.hasNext() && car.getBrandName() != brandName && car.getModelName() != modelName);
        car.addToStock(quantity); //DEBUG isto funciona ou só altera o iterador?
    }

    /**
     * Regista a venda de mais um exemplar do modelo especificado, caso exista stock.
     * @return true, caso a operação tenha sucesso; false, caso o modelo possua
     *         stock zero. Nesse segundo caso, o método não altera nada.
     * @pre: brandName != null && modelName != null && exists(brandName, modelName)
     */
    public boolean sell(String brandName, String modelName) {
        MinPriceCarModelIterator it = iterator(0);
        CarModel car;
        do {
            car = it.next();
        } while (it.hasNext() && !car.getBrandName().equals(brandName) && !car.getModelName().equals(modelName));
        if (car.getStock() == 0) {
            return false;
        } else {
            car.sell();
            return true;
        }
    }

    /**
     * @return um iterador com filtro para objetos da classe CarModel.
     * @pre: minimumPrice > 0
     */
    public MinPriceCarModelIterator iterator(int minimumPrice) {
        return new MinPriceCarModelIterator(cars, size, minimumPrice);
    }

    /**
     * @return valor total das vendas (soma dos preços dos exemplares vendidos)
     * até ao momento.
     */
    public int salesTotalAmount() {
        MinPriceCarModelIterator it = iterator(0);
        int sales = 0;
        while (it.hasNext()) {
            CarModel car = it.next();
            sales += car.getSold() * car.getPrice();
        }
        return sales;
    }
}