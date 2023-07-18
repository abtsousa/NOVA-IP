import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }
    // Cria um vector de objectos do tipo Oeuvre e preenche-o completamente com a
// informacao no ficheiro de texto com o nome dado.
// Para simplificar, assuma que ha’ pelo menos uma obra do artista no ficheiro.
// @pre fileName != null
    public Oeuvre[] loadVec(String fileName) throws FileNotFoundException {
        String artist, name;
        int numOuv, year;
        double price;
        Scanner file = new Scanner(new FileReader(fileName));
        artist = file.nextLine().trim();
        numOuv = file.nextInt(); file.nextLine();
        Oeuvre[] list = new Oeuvre[numOuv];
        for (int i=0; i<numOuv; i++) {
            name = file.nextLine().trim();
            year = file.nextInt(); file.nextLine();
            price = file.nextDouble(); file.nextLine();
            Oeuvre ovr = new Oeuvre(artist, name, year, price);
            if (file.nextLine().trim().equals("true")) {ovr.sell();}
            list[i] = ovr;
        }
        file.close();
        return list;
    }

    // Escreve no ficheiro de texto com o nome dado o conteudo do vector de objectos do
// tipo Oeuvre, que esta’ completamente preenchido com obras de um unico artista.
// @pre works != null && works.length > 0 && fileName != null
    public void saveVec(Oeuvre[] works, String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        out.println(works[0].getAuthor());
        out.println(works.length);
        for (int i=0; i<works.length; i++) {
            Oeuvre oev = works[i];
            out.println(oev.getName());
            out.println(oev.getYear());
            out.println(oev.getPrice());
            out.println(oev.isSold());
        }
        out.close();
    }

}