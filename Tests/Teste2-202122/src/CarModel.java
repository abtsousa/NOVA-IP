public class CarModel {
    private String brandName; // nome da marca (e.g., Honda, Renault, etc.)
    private String modelName; // nome do modelo (e.g., Clio, Uno, etc.)
    private int price; // preço do modelo (valor fixo; não há descontos)
    private int stock; // número de exemplares disponíveis na loja
    private int sold; // número de exemplares já vendidos

    /**
     * construtor: Inicializa um modelo com os valores indicados
     * e zero automóveis vendidos.
     *
     * @pre brandName != null && modelName != null && price > 0 && stock >= 0
     */
    public CarModel(String brandName, String modelName, int price, int stock) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
    }

    /**
     * construtor: Inicializa um modelo com os valores indicados
     * e zero automóveis vendidos.
     *
     * @pre brandName != null && modelName != null && price > 0 && stock >= 0
     */
    public CarModel(String brandName, String modelName, int price, int stock, int sold) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getSold() {
        return sold;
    }

    /**
     * Aumenta o stock.
     *
     * @pre: quantity > 0
     */
    public void addToStock(int quantity) {
        stock += quantity;
    }

    /**
     * Regista a venda de mais um exemplar do modelo.
     * Portanto, decrementa as existências e incrementa as vendas.
     *
     * @pre: getStock() > 0
     */
    public void sell() {
        this.stock--;
        this.sold++;
    }

    public int compareTo(CarModel other) {
        if (brandName != other.getBrandName()) { //DEBUG other.brandName?
            return brandName.compareTo(other.getBrandName());
        } else if (modelName != other.getModelName()) {
            return modelName.compareTo(other.getModelName());
        } else {
            return price - other.getPrice();
        }
    }
}
