public class Artist {
    //Constantes TODO
    private static final int NOT_FOUND = -1;
    private static final int OEUVRE_EXISTS = 0;
    private static final int SUCCESS = 1;

    private String name;
    private Oeuvre[] oeuvres;
    private int count;

    /* Cria um artista com o nome dado e uma coleccao vazia de obras da sua autoria,
     * e coloca o contador de obras a zero.
     *
     * @pre name != null
     */
    public Artist(String name) {
        name = null;
    }

    public String getName() {
        return null;
    }

    // @return true, se o artista ja’ produziu alguma obra; // false, no caso contrario
    public boolean hasOeuvres() {
        return false;
    }

    /* Insere uma nova obra (no estado por vender) na coleccao de obras do artista,
     * se nao existir uma obra com o nome e o ano especificados.
     *
     * A operacao deve manter a coleccao de obras do artista por ordem crescente
     * de ano; em caso de empate no ano, por ordem alfabetica de nome da obra.
     *
     * @return OEUVRE_EXISTS, se ja’ existir uma obra com o nome e o ano dados;
     * SUCCESS, no caso contrario.
     *
     * @pre nameOvr != null && price > 0
     */
    public int addOeuvre(String nameOvr, int year, double price) {
        Oeuvre newOvr = new Oeuvre(name, nameOvr, year, price);
        if (hasOeuvres()) {
            int i = 0;
            while (i < count && !newOvr.equals(oeuvres[i]) && newOvr.greaterThan(oeuvres[i])) {
                i++;
            }
            if (newOvr.equals(oeuvres[i])) {
                return OEUVRE_EXISTS;
            } else {
                insertAt(newOvr, i);
            }
        }
        return SUCCESS;
    }


    // @return true, se existir na coleccao uma obra com o nome e o ano dados;
// false, no caso contrario.
// @pre nameOvr != null
    public boolean exists(String nameOvr, int year) {
        return getIndex(nameOvr, year) != NOT_FOUND;
    }


    /* Coloca o estado de uma obra, identificada pelo seu nome e ano, como vendida,
     * assumindo-se que o artista tem uma obra com o nome e o ano dados.
     *
     * @pre nameOvr != null && exists(nameOvr, year)
     */
    public void sell(String nameOvr, int year) {
        oeuvres[getIndex(nameOvr, year)].sell();
    }

    // @return a soma dos precos de todas as obras vendidas.
    public double valueSales() {
        int sales = 0;
        for (int i = 0; i < count; i++) {
            if (oeuvres[i].isSold()) {
                sales += oeuvres[i].getPrice();
            }
        }
        return sales;
    }

    /* @return o ano em que o autor produziu mais obras;
     * caso haja varios anos com o numero maximo de obras produzidas,
     * retorna o mais recente desses anos.
     *
     * @pre hasOeuvres()
     */

    public int bestYear() {
        int bestYear = 0;
        int bestYearCount = 0;
        int tmpYear = oeuvres[0].getYear();
        int tmpCount = 1;
        for (int i = 1; i < count; i++) {
            if (oeuvres[i].getYear() != tmpYear) {
                if (tmpCount > bestYearCount) {
                    bestYearCount = tmpCount;
                    bestYear = tmpYear;
                }
                tmpYear = oeuvres[i].getYear();
                tmpCount = 1;
            } else {
                tmpCount++;
            }
        }
        if (tmpCount > bestYearCount) {
            return tmpYear;
        } else return bestYear;
    }


    //Aux
    private void grow() {
        Oeuvre[] tmp = new Oeuvre[oeuvres.length + 1];
        for (int i = 0; i < oeuvres.length; i++) {
            tmp[i] = oeuvres[i];
        }
    }

    private boolean isFull() {
        return count == oeuvres.length;
    }

    private void insertAt(Oeuvre ovr, int index) {
        if (isFull()) {
            grow();
        }
        for (int i = count - 1; i >= index; i--) {
            oeuvres[i + 1] = oeuvres[i];
            oeuvres[index] = ovr;
            count++;
        }
    }

    private int getIndex(String nameOvr, int year) {
        int i = 0;
        while (i < count && oeuvres[i].getName() != nameOvr && oeuvres[i].getYear() != year) {
            i++;
        }
        if (i == count) {
            return NOT_FOUND;
        } else return i;
    }
}
