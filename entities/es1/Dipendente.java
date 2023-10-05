package entities.es1;

import entities.es1.enums.Dipartimento;
import entities.es1.enums.Livello;

public class Dipendente {
    public double stipendioBase = 1000;
    private long matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    public void setDipendenteBase (long matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = 30;
        this.livello = Livello.OPERIAIO;
    }

    public Dipendente(){}

    public void setDipendente(long matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
        this.dipartimento = dipartimento;
    }
    @Override
    public String toString() {
        return "Dipendente { " +
                "stipendioBase: " + stipendioBase +
                ", matricola: " + matricola +
                ", stipendio: " + stipendio +
                ", importoOrarioStraordinario: " + importoOrarioStraordinario +
                ", livello: " + livello +
                ", dipartimento: " + dipartimento +
                " }";
    }
}
