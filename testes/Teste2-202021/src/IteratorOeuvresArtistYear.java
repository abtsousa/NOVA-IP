public class IteratorOeuvresArtistYear {
    private String name;
    private int year, currentOeuvre, size;
    private Oeuvre[] works;

    /* Dados um vector de objectos do tipo Oeuvre (totalmente ocupado, possivelmente
     * desordenado e possivelmente com obras de varios artistas), o nome dum artista
     * e um ano, constroi um iterador que da’ acesso ‘as obras do artista com o nome
     * dado que tenham sido concebidas no ano referido (se existir alguma).
     *
     * @pre works != null && name != null
     */
    public IteratorOeuvresArtistYear(Oeuvre[] works, String name, int year) {
        size = works.length;
        this.name = name;
        this.year = year;
        int currentOeuvre = 0;
        advance();
    }

    public boolean hasNext() {
        return currentOeuvre < size;
    }

    public Oeuvre next() {
        Oeuvre result = works[currentOeuvre++];
        advance();
        return result;
    }

    //Aux
    private void advance() {
        while (hasNext() && works[currentOeuvre].getYear() != year && works[currentOeuvre].getName() != name) {
            currentOeuvre++;
        }
    }
}