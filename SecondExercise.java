import entities.Dipendente;
import entities.enums.Dipartimento;
import entities.enums.Livello;

public class SecondExercise {
    public static void main(String[] args) {
        Dipendente dip1 = new Dipendente();
        dip1.setDipendente(123456, 1238.23, 0, Livello.OPERIAIO, Dipartimento.PRODUZIONE);
        Dipendente dip2 = new Dipendente();
        dip2.setDipendente(123456, 1250.31, 10, Livello.OPERIAIO, Dipartimento.PRODUZIONE);
        Dipendente dip3 = new Dipendente();
        dip3.setDipendente(123456, 1403.23, 3, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
        Dipendente dip4 = new Dipendente();
        dip4.setDipendente(123456, 2130.01, 11, Livello.DIRIGENTE, Dipartimento.VENDITE);

        dip1.promuovi(dip1.getLivello(), dip1);
        System.out.println(dip2);
        dip3.promuovi(dip3.getLivello(), dip3);
        System.out.println(dip4);

        double tot = dip1.getStipendio() + dip2.getStipendio() + dip3.getStipendio() + dip4.getStipendio() + (20 * 30 * (1000 / 30 / 24));
        double totParz = dip1.getStipendio() + dip2.getStipendio() + dip3.getStipendio() + dip4.getStipendio();

        System.out.println("L'importo dovuto totale è: " + totParz);
        System.out.println("L'importo dovuto totale con straordunari è: " + tot);

    }

}
