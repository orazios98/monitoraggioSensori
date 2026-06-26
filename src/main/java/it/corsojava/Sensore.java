package it.corsojava;

public abstract class Sensore {

    private int codice;
    private String posizione;
    private boolean attivo;

    public Sensore(int codice, String posizione) {
        if (codice <= 0) {
            throw new IllegalArgumentException(
                    "Il codice deve essere maggiore di zero."
            );
        }
        this.codice = codice;

        this.attivo = true;

        setPosizione(posizione);
    }

    public int getCodice() {
        return codice;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        if (posizione == null || posizione.isBlank()) {
            throw new IllegalArgumentException("La posizione non può essere vuota");
        }

        this.posizione = posizione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void attiva() {
        attivo = true;
    }

    public void disattiva() {
        attivo = false;
    }

    public abstract String getTipo();

    public abstract double getValore();

    public abstract void mostraDettagli();

    public abstract String toFileString();


}