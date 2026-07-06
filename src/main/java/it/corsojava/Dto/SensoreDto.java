package it.corsojava.dto;

import it.corsojava.model.Sensore;

public class SensoreDto {

    private String tipo;
    private int codice;
    private String posizione;
    private boolean attivo;
    private double valore;

    public SensoreDto() {
    }

    public SensoreDto(
            String tipo,
            int codice,
            String posizione,
            boolean attivo,
            double valore
    ) {
        this.tipo = tipo;
        this.codice = codice;
        this.posizione = posizione;
        this.attivo = attivo;
        this.valore = valore;
    }

    public static SensoreDto fromSensore(Sensore sensore) {
        if(sensore == null) {
            throw new IllegalArgumentException("Il sensore non può essere null");
        }

        return new SensoreDto(
                sensore.getTipo(),
                sensore.getCodice(),
                sensore.getPosizione(),
                sensore.isAttivo(),
                sensore.getValore()
        );
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }
}
