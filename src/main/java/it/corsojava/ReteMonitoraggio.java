package it.corsojava;

import it.corsojava.Exceptions.CodiceSensoreDuplicatoException;
import it.corsojava.Exceptions.SensoreNonTrovatoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReteMonitoraggio {
    private Map<Integer, Sensore> sensori;

    public ReteMonitoraggio() {
        sensori = new HashMap<Integer, Sensore>();
    }

    public List<Sensore> getSensori() {
        return new ArrayList<>(sensori.values());
    }

    public void aggiungiSensore(Sensore sensore) throws CodiceSensoreDuplicatoException {
        if(sensore == null) {
            throw new IllegalArgumentException("Il sensore non puo' essere null.");
        }

        int codice = sensore.getCodice();

        if(sensori.containsKey(codice)) {
            throw new CodiceSensoreDuplicatoException("Esiste già un  sensore con questo codice: " + codice);
        }

        sensori.put(codice, sensore);
    }

    public Sensore cerca(int codice) throws SensoreNonTrovatoException {

        Sensore sensore = sensori.get(codice);

        if(sensore == null) {
            throw new SensoreNonTrovatoException("Il sensore con il codice "+  codice + " non esiste");
        }

        return sensore;

    }

    public boolean contieneCodice(int codice) {
        return sensori.containsKey(codice);
    }

    public boolean rimuovi(int codice) {
        return sensori.remove(codice) != null;
    }

    public void visualizzaTutti() {

        if(sensori.isEmpty()) {
            System.out.println("La rete non contiene sensori!");
            return;
        }

        for(Sensore s: sensori.values()) {
            s.mostraDettagli();
        }
    }


};

