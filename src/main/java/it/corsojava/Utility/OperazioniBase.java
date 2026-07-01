package it.corsojava.Utility;

public class OperazioniBase {

    public int somma(int a, int b) {
        return a+b;
    }

    public float divisione(int a, int b) {
        if(b == 0) {
            return 0;
            //throw new IllegalArgumentException("Valore non valido");
        }
        return (float) a /b;
    }

    public int prodotto(int a, int b) {
        return a*b;
    }

    public boolean isNumeroPositivo(int a){
        if(a>0) {
            return true;
        }
        return false;
    }

}
