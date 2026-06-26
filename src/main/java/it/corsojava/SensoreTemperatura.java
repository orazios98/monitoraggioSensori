package it.corsojava;

public class SensoreTemperatura extends Sensore {
    private double temperatura;

    public SensoreTemperatura(
            int codice,
            String posizione,
            double temperatura ) {
        super(codice, posizione);
        setTemperatura(temperatura);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura < -20 || temperatura > 100) {
            throw new IllegalArgumentException(
                    "Temperatura iniziale non valida."
            );
        }
        this.temperatura = temperatura;
    }

    @Override
    public String getTipo() {
        return "TEMPERATURA";
    }

    @Override
    public double getValore() {
        return temperatura;
    }

    @Override
    public void mostraDettagli() {
        System.out.println(
                "Sensore di temperatura" +
                        " | Codice: " + getCodice() +
                        " | Posizione: " + getPosizione() +
                        " | Temperatura: " + temperatura + " °C");
    }

    @Override
    public String toFileString() {
        return getTipo() + ";" +
                getCodice() + ";" +
                getPosizione() + ";" +
                getTemperatura() + ";" +
                isAttivo();
    }


}
