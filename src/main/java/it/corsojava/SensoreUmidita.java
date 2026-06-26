package it.corsojava;

public class SensoreUmidita extends Sensore {

    private double percentualeUmidita;

    public SensoreUmidita(
            int codice,
            String posizione,
            double percentualeUmidita ) {
        super(codice, posizione);
        setPercentualeUmidita(percentualeUmidita);
    }

    public double getPercentualeUmidita() {
        return percentualeUmidita;
    }

    public void setPercentualeUmidita(double percentualeUmidita) {
        if (percentualeUmidita < 0 || percentualeUmidita > 100) {
            throw new IllegalArgumentException(
                    "La percentuale di umidità deve essere tra 0 e 100."
            );
        }

        this.percentualeUmidita = percentualeUmidita;
    }

    @Override
    public String getTipo() {
        return "UMIDITA";
    }

    @Override
    public double getValore() {
        return percentualeUmidita;
    }

    @Override
    public void mostraDettagli() {
        System.out.println(
                "Sensore di umidità" +
                        " | Codice: " + getCodice() +
                        " | Posizione: " + getPosizione() +
                        " | Umidità: " + percentualeUmidita + "%"
        );
    }

    @Override
    public String toFileString() {
        return getTipo() + ";" +
                getCodice() + ";" +
                getPosizione() + ";" +
                percentualeUmidita + ";" +
                isAttivo();
    }

}
