package it.corsojava;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import it.corsojava.Exceptions.CodiceSensoreDuplicatoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)  {

        ReteMonitoraggio rm = new ReteMonitoraggio();

        Sensore s1 = new SensoreTemperatura(11, "aula 1", 28);
        Sensore s2 = new SensoreUmidita(12, "Aula 1", 70);
        Sensore s3 = new SensoreTemperatura(3, "Cortile", 35);
        Sensore s4 = new SensoreUmidita(4, "cortile", 55);
        Sensore s5 = new SensoreTemperatura(5, "Ripostiglio",15); //DISATTIVO
        Sensore s6 = new SensoreTemperatura(6,"Palestra",30);
        s5.disattiva();

        try {
            rm.aggiungiSensore(s3);
            rm.aggiungiSensore(s4);
            rm.aggiungiSensore(s5);
            rm.aggiungiSensore(s6);
            rm.aggiungiSensore(s1);
            rm.aggiungiSensore(s2);
        } catch (CodiceSensoreDuplicatoException e) {
            System.out.println("Codice ripetuto inserito. verifica!");
        }

        rm.visualizzaTutti();

        List<Sensore> sensoriInRete = rm.getSensori();


        Predicate<Sensore> sensoriAttivi = Sensore::isAttivo;
        Predicate<Sensore> sensoriAttivi2 = sensore -> sensore.isAttivo();
        Predicate<Sensore> sensoreCaldo = sensore -> sensore.isAttivo() && sensore.getValore() > 30;

        List<Sensore> result = sensoriInRete.stream()
                //.filter(Predicate<T> in questo caso è Predicate<Sensore>
                //.filter(Sensore::isAttivo)
                //.filter(sensore -> sensore.isAttivo())
                .filter(sensoriAttivi)
                .toList();

        Stream<String> streamSensor = sensoriInRete.stream()
                        .filter(Sensore::isAttivo)
                        .map(Sensore::getPosizione)
                        .distinct();

        List<String> listaPosizioni = streamSensor.toList();

        streamSensor = sensoriInRete.stream()
                .filter(Sensore::isAttivo)
                .map(Sensore::getPosizione)
                .distinct();

        long numeroPosizioni = streamSensor.count();

        System.out.println("Numero posizioni: " + numeroPosizioni);

        for(String s : listaPosizioni) {
            System.out.println("Pos: " + s);
        }

        streamSensor = sensoriInRete.stream()
                .filter(Sensore::isAttivo)
                .map(Sensore::getPosizione)
                .distinct();

        List<String> orderedPosition = streamSensor.sorted(
                Comparator.comparing(s-> s,
                        String.CASE_INSENSITIVE_ORDER
                )

        ).toList();

        for (String s : orderedPosition) {
            System.out.println("Ord pos: " + s);
        }




        System.out.println(result.size());


    }
}
