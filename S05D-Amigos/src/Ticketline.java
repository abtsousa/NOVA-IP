public class Ticketline {
    private int ticket_number, friends;
    private int[] ticketsIn, ticketsOut;

    //TODO Verifica se o amigo na posição pos já recebeu todos os bilhetes que pediu
    private boolean isFull(int pos) {return ticketsOut[pos]==ticketsIn[pos];}

    //TODO Distribui bilhetes
    public int[] distributeTickets() {
        ticketsOut = new int[friends];
        int i = 0;
        do {
            if (!isFull(i)) {
                ticketsOut[i]++;
                ticket_number--;
            }
            i++;
        } while (ticketsIn!=ticketsOut);
    }

    //Constructor
    public Ticketline(int tn, int fn, int[] tin) {
        ticket_number = tn;
        friends = fn;
        ticketsIn = tin;
    }
}
