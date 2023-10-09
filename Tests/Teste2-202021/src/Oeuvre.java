public class Oeuvre {
    private String author;
    private String name;
    private int year;
    private double price;
    private boolean sold;

    // Cria uma obra com autor, nome, ano e preco,
// e define o seu estado como por vender.
// @pre author != null && name != null && price > 0
    public Oeuvre(String author, String name, int year, double price) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.price = price;
        sold = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return sold;
    }

    // Coloca o estado da obra como vendida.
    public void sell() {
        sold = true;
    }

    // @return true, se o autor, o nome e o ano forem iguais, respectivamente,
//         ao autor, ao nome e ao ano de other;
// false, no caso contrario.
    public boolean equals(Oeuvre other) {
        return false;
    }

    /* Compara obras.
     *
     * @return true, se o autor for alfabeticamente maior que o autor de other;
    caso sejam do mesmo autor, se o ano for maior que o ano de other;
    caso sejam do mesmo autor e do mesmo ano, se o nome for
    alfabeticamente maior que o nome de other;
    *
    *
    *
    * @return false, nos restantes casos.
    *
     * @pre other != null
    */
    public boolean greaterThan(Oeuvre other) {
        if (!author.equals(other.getAuthor())) {
            return (author.compareTo(other.getAuthor()) > 0);
        } else if (year != other.getYear()) {
            return (year > other.getYear());
        } else {
            return (name.compareTo(other.getName()) > 0);
        }
    }
}
