package it.corsojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class ArchivioSensori {
    private ArchivioSensori() {}

    public static void salva(
            String nomeFile,
            ReteMonitoraggio rete
    ) throws IOException {

        try(FileWriter writer = new FileWriter(nomeFile)) {
            for(Sensore sensore : rete.getSensori()) {
                writer.write(sensore.toFileString());
                writer.write(System.lineSeparator());
            }
        }
    }

    public static ReteMonitoraggio caricaDaFile(String nomeFile) throws FileNotFoundException {
        ReteMonitoraggio rm = new ReteMonitoraggio();
        File file = new File(nomeFile);

        if(!file.exists()) {
            throw new FileNotFoundException(nomeFile + " non trovata");
        }

        try (Scanner sc = new Scanner(file)) {

            while(sc.hasNextLine()) {

                String line = sc.nextLine().trim();
                try {
                    Sensore s = creaSensoreDaRiga(line);
                    rm.aggiungiSensore(s);
                } catch (Exception e) {
                    System.out.println("Riga non valida saltata!");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument: " + e.getMessage());
        }
        return rm;
    }

    private static Sensore creaSensoreDaRiga(String line) {
        if(line.isEmpty()) {
            throw new IllegalArgumentException("Riga vuota trovata!");
        }

        String[] splittedRow = line.split(";");

        if(splittedRow.length != 5) {
            throw new IllegalArgumentException("La riga deve avere 5 parti");
        }

        String tipo = splittedRow[0];
        int codice = Integer.parseInt(splittedRow[1]);
        String posizione = splittedRow[2];

        Sensore s;
        switch(tipo) {
            case "TEMPERATURA" -> {
                double temperatura = Double.parseDouble(splittedRow[3]);
                s = new SensoreTemperatura(codice, posizione, temperatura);
            }
            case "UMIDITA" -> {
                double umidita = Double.parseDouble(splittedRow[3]);
                s = new SensoreUmidita(codice, posizione, umidita);
            }
            default -> {
                throw new IllegalArgumentException("TIPO NON VALIDO");
            }
        }
        return s;
    }
}
