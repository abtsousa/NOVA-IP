public class Inventory {
    private Product[] list;
    private int size;

    public Inventory() {
        size=0;
        list=new Product[size];
    }

    public boolean isFull() {
        return size == list.length;
    }

    //Pre: isFull()
    public void grow() {
        Product[] newList = new Product[list.length+1];
        int i=0;
        while (i<list.length) {
            newList[i] = list[i];
            i++;
        }
        list = newList;
    }

    //Call iterator
    public InventoryIterator iterator() {
        return new InventoryIterator(list,size);
    }

    public InventoryIterator sorteredIterator() {
        Product[] aux = new Product[size];
        for (int i = 0; i < size; i++) {
            aux[i] = list[i];
        }
        sort(aux, size);
        return new InventoryIterator(aux, size);
    }

    private void sort(Product[] inv, int size) {
        for (int i=0; i < size-1; i++) {
            int idx = i;
            for (int j=i+1; j< size; j++) {
                if (inv[j].nestedCompare(inv[idx]) > 0) {
                    idx = j;
                }
            }
            Product tmp = inv[i];
            inv[i] = inv[idx];
            inv[idx] = tmp;
        }
    }

    /**
     * Searches for product by name
     * @param name - search term
     * @return index on list
     */
    private int searchProduct(String name) {
        InventoryIterator it = iterator(); //Start iterator
        int i=0;
        while (it.hasNext()) { //Run iterator
            Product next = it.next();
            if (next.getName().equals(name)) {return i;} //return index if found
            i++;
        }
        return -1; // return -1 if not found
    }

    //Add product
    public void addProduct(String name, int price, int qty) {
        int index = searchProduct(name);
        if (index==-1) {
            if (isFull()) {grow();}
            Product product = new Product(name, price, qty);
            list[size] = product;
            size++;
            System.out.println("Produto adicionado");
        } else {
            System.out.println("Produto existente");
        }
    }

    public void removeProduct(String name) {
        int index = searchProduct(name);
        if (index==-1) {
            System.out.println("Produto inexistente");
        } else {
            for (int i = index; i < size-1; i++) {
                list[i]=list[i+1];
            }
            size--;
            System.out.println("Produto removido");
        }
    }

    public void growQty(String name, int qty) { //Pre: qty>0
        int index = searchProduct(name);
        if (index == -1) {
            System.out.println("Produto inexistente");
        } else {
            list[index].changeQty(qty);
            System.out.printf("Quantidade de %s aumentada em %d unidades\n", name, qty);
        }
    }

    public void shrinkQty(String name, int qty) { //Pre: qty>0
        int index = searchProduct(name);
        if (index == -1) {
            System.out.println("Produto inexistente");
        } else if (list[index].getQty()<qty){
            System.out.println("Impossível diminuir quantidade");
        } else {
            list[index].changeQty(-qty);
            System.out.printf("Quantidade de %s diminuída em %d unidades\n", name, qty);
        }
    }

    public void listAll(InventoryIterator it) {
        if (!it.hasNext()) {System.out.println("Não existem produtos");}
        while (it.hasNext()) { //Run iterator
            Product pr = it.next();
            System.out.printf("%s ; %d ; %d\n", pr.getName(), pr.getQty(), pr.getPrice());
        }
    }


    public void getInventoryValue() {
        InventoryIterator it = iterator(); //Start iterator
        if (!it.hasNext()) {System.out.println("Não existem produtos");}
        else {
            int value = 0;
            while (it.hasNext()) { //Run iterator
                Product pr = it.next();
                value += pr.getQty() * pr.getPrice();
            }
            System.out.printf("Valor total: %d\n", value);
        }
    }

    public int getInventoryQty() {
        InventoryIterator it = iterator(); //Start iterator
        int qty = 0;
        while (it.hasNext()) { //Run iterator
            Product product = it.next();
            qty += product.getQty();
        }
        return qty;
    }

}
