package entities;

import entities.enums.Dipartimento;
import entities.enums.Livello;

public class Dipendente {
    public double stipendioBase = 1000;
    private long matricola;
    private double stipendio;
    private int importoOrarioStraordinario;
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

    public void setDipendente(long matricola, double stipendio, int importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
        this.dipartimento = dipartimento;
    }

    public void promuovi(Livello livello, Dipendente dipendente) {
        if (livello == Livello.OPERIAIO) {
            this.livello = Livello.IMPIEGATO;
            this.stipendioBase = stipendioBase * 1.2;
            this.stipendio = stipendioBase;
            System.out.println(dipendente);

        } else if (livello == Livello.IMPIEGATO) {
            this.livello = Livello.QUADRO;
            this.stipendioBase = stipendioBase * 1.5;
            this.stipendio = stipendioBase;
            System.out.println(dipendente);


        } else if (livello == Livello.QUADRO) {
            this.livello = Livello.DIRIGENTE;
            this.stipendioBase = stipendioBase * 2;
            this.stipendio = stipendioBase;
            System.out.println(dipendente);


        } else if (livello == Livello.DIRIGENTE) {
            this.stipendioBase = stipendioBase * 2;
            this.livello = Livello.DIRIGENTE;
            System.out.println("Messaggio di errore");
        }
    }

    public long getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public int getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    @Override
    public String toString() {
        return "Dipendente { " +
                "stipendioBase: " + stipendioBase +
                ", matricola: " + matricola +
                ", stipendio: " + stipendio +
                "$, importoOrarioStraordinario: " + importoOrarioStraordinario +
                ", livello: " + livello +
                ", dipartimento: " + dipartimento +
                " }";
    }
}
