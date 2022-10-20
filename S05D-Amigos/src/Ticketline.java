public class Ticketline {
    private final int ticket_number;
    private final int friends;
    private final int[] ticketsIn;
    private int[] ticketsOut;

    //Verifica se o amigo na posição pos já recebeu todos os bilhetes que pediu
    private boolean isFull(int pos) {return ticketsOut[pos]==ticketsIn[pos];}

    //Distribui bilhetes
    public int[] distributeTickets() {
        ticketsOut = new int[friends];
        int nonFullFriends = friends;
        for (int i=0;i<friends;i++) {
            if (isFull(i)) {nonFullFriends--;}
        }
        int tickets_total = Math.min(ticket_number, getTotalRequests());
        boolean checkForParity = true;
        int i = 0;
        while (tickets_total > 0 && checkForParity && ticket_number >= friends) { //se não dá para distribuir 1 para cada amigo acaba já a distribuição
            if (!isFull(i)) {
                ticketsOut[i]++;
                tickets_total--;
                if (isFull(i)) {nonFullFriends--;} //faz nova verificação após dar 1 bilhete
            }
            if (i < ticketsOut.length - 1) {
                i++;
            } else {
                if (tickets_total < nonFullFriends) {
                    checkForParity = false;
                } //não dá mais bilhetes de sobra se ficarem amigos a arder
                i = 0;
            }
        }
        return ticketsOut;
    }

    //Devolve o total de bilhetes pedidos
    private int getTotalRequests() {
        int sumRequests = 0;
        for (int i=0; i<ticketsIn.length;i++) {
            sumRequests += ticketsIn[i];
        }
        return sumRequests;
    }

    /* //Devolve o total de bilhetes recebidos pelo amigo na posição pos
    public int getTickets(int pos) {return ticketsOut[pos];} */

    //Constructor
    public Ticketline(int tn, int fn, int[] tin) {
        ticket_number = tn;
        friends = fn;
        ticketsIn = tin;
    }
}
