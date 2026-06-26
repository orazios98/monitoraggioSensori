package it.corsojava;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Sensore> sensori = new ArrayList<>();

        SensoreTemperatura s1 = new SensoreTemperatura(1,"Aula 1", 29.3);

        s1.mostraDettagli();

        String j1 = gson.toJson(s1);

        System.out.println("j1:");
        System.out.println(j1);

        SensoreTemperatura s2;

        s2 = gson.fromJson(j1, SensoreTemperatura.class);

        System.out.println("S2: ");
        s2.mostraDettagli();


        sensori.add(s1);
        sensori.add(s2);

        String arrayJson1 = gson.toJson(sensori);

        System.out.println("arrayJson1:");
        System.out.println(arrayJson1);

    }
}
