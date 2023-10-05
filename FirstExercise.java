import entities.Dipendente;
import entities.enums.Dipartimento;
import entities.enums.Livello;

import java.util.Scanner;

public class FirstExercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dipendente dipendente = new Dipendente();
        System.out.println("Voi usare la configurazione facile o avanzato?");
        System.out.println("[1]: Facile  -  [2]: Avanzato");
        int choose1 = Integer.parseInt(input.nextLine());
        if (choose1 != 1 && choose1 != 2) {
            System.out.println("Non hai scelto una delle scelte proposte. Riprova");
            return;
        }
        System.out.println("Inserisci il tuo numero matricola: ");
        long matricola = Long.parseLong(input.nextLine());
        System.out.println("Scegli il tuo dipartimento");
        System.out.println("[1]: " + Dipartimento.AMMINISTRAZIONE + "  -  [2]: " + Dipartimento.VENDITE + "  -  [3]: " + Dipartimento.PRODUZIONE);
        int choose2 = Integer.parseInt(input.nextLine());

        switch (choose1) {
            case 1:
                costruzioneDipendente(choose2, matricola, dipendente);
                break;
            case 2:
                System.out.println("Inserisci il tuo stipendio mensile:");
                double stipendio = Double.parseDouble(input.nextLine());
                System.out.println("Inserisci i tuoi straordinari:");
                int importoOrarioStraordinario = Integer.parseInt(input.nextLine());
                System.out.println("Scegli il tuo livello");
                System.out.println("[1]: " + Livello.OPERIAIO + "  -  [2]: " + Livello.IMPIEGATO + "  -  [3]: " + Livello.QUADRO + "  -  [4]: " + Livello.DIRIGENTE);
                int choose3 = Integer.parseInt(input.nextLine());
                costruzioneDipendenteAvanzato(choose2, choose3, dipendente, matricola, stipendio, importoOrarioStraordinario);
                break;
            default:
                System.out.println("Non hai scelto una delle possibili scelte. Riprova");
                break;
        }

        input.close();
    }

    public static void costruzioneDipendente (int choose2, long matricola, Dipendente dipendente) {
        Dipartimento dipartimento = sceltaDipartimento(choose2);
        if (choose2 == 1 || choose2 == 2 || choose2 == 3) {
            dipendente.setDipendenteBase(matricola, dipartimento);
            stampaDatiDipendente(dipendente);
            System.out.println("----------------------- SEI STATO PROMOSSO -----------------------");
            dipendente.promuovi(dipendente.getLivello(), dipendente);
            System.out.println("----------------------- IL TUO STIPENDIO ANNUALE -----------------------");
            double stipendio = dipendente.getStipendio();
            calcolaPaga(stipendio);
            System.out.println("----------------------- IL TUO STIPENDIO ANNUALE CON STRAORDIANRI -----------------------");
            int importoOrarioStraordinario = dipendente.getImportoOrarioStraordinario();
            calcolaPaga(stipendio, importoOrarioStraordinario);
        } else {
            System.out.println("Non hai scelto uno dei possibili dipartimenti. Riprova");
        }

    }

    public static void costruzioneDipendenteAvanzato (int choose2, int choose3, Dipendente dipendente, long matricola, double stipendio, int importoOrarioStraordinario) {
        Dipartimento dipartimento = sceltaDipartimento(choose2);
        Livello livello = sceltaLivello(choose3);
        if ((choose2 == 1 || choose2 == 2 || choose2 == 3) && (choose3 == 1 || choose3 == 2 || choose3 == 3 || choose3 == 4)) {
            dipendente.setDipendente(matricola, stipendio, importoOrarioStraordinario, livello, dipartimento);
            stampaDatiDipendente(dipendente);
            System.out.println("----------------------- SEI STATO PROMOSSO -----------------------");
            dipendente.promuovi(dipendente.getLivello(), dipendente);
            System.out.println("----------------------- IL TUO STIPENDIO ANNUALE -----------------------");
            double stipendio1 = dipendente.getStipendio();
            calcolaPaga(stipendio1);
            System.out.println("----------------------- IL TUO STIPENDIO ANNUALE CON STRAORDIANRI -----------------------");
            int importoOrarioStraordinario1 = dipendente.getImportoOrarioStraordinario();
            calcolaPaga(stipendio1, importoOrarioStraordinario1);
        } else {
            System.out.println("Non hai scelto uno dei possibili dipartimenti e/o non hai scelto uno dei possibili livelli. Riprova");
        }
    }

    public static Dipartimento sceltaDipartimento (int choose2) {
        return switch (choose2) {
            case 1 -> Dipartimento.AMMINISTRAZIONE;
            case 2 -> Dipartimento.VENDITE;
            case 3 -> Dipartimento.PRODUZIONE;
            default -> Dipartimento.ERRORE;
        };
    }

    public static Livello sceltaLivello (int choose3) {
        return switch (choose3) {
            case 1 -> Livello.OPERIAIO;
            case 2 -> Livello.IMPIEGATO;
            case 3 -> Livello.QUADRO;
            case 4 -> Livello.DIRIGENTE;
            default -> Livello.ERRORE;
        };
    }

    public static void calcolaPaga (double stipendio) {
        System.out.println("Il tuo stipendio annuale è: " + (stipendio * 12));
    }

    public static void calcolaPaga (double stipendio, int importoOrarioStraordinario) {
        double guadagnoOra = stipendio / 30 / 24;
        double guadagnoStraordinari = importoOrarioStraordinario * guadagnoOra;
        System.out.println("Il tuo stipendio annuale compresi gli straordinari è: " + ((stipendio * 12) + guadagnoStraordinari));
    }

    public static void stampaDatiDipendente(Dipendente dipendente){
        System.out.println(dipendente);
    }

}
