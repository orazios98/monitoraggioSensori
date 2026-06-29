package it.corsojava;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class ArchivioSensoriJson {

    private ArchivioSensoriJson() {}

    public static void salva(
            String nomeFile,
            ReteMonitoraggio rete
    ) throws IOException {

        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter(nomeFile)) {
            gson.toJson(rete.getSensori(), writer);
        } catch (JsonIOException e) {
            System.out.println("Errore nel salvataggio JSON");
        }
    }


}
