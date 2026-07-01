import it.corsojava.Utility.OperazioniBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;

import static org.junit.jupiter.api.Assertions.*;

public class OperazioniBaseTest {

    OperazioniBase createBaseOperationClass() {
        return new OperazioniBase();
    }

    @Test
    void testSomma() {

        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();

        // ACT
        int risultato = operazioni.somma(2,3);
        boolean isPositivo = operazioni.isNumeroPositivo(risultato);

        // TEST
        // 2 + 3 = 5 ??? --> risultato == 5 ??
        assertEquals(5, risultato);
        assertTrue(isPositivo);
    }

    @Test
    void testDivisione() {

        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();

        // ACT
        float risultato = operazioni.divisione(12,4);

        // TEST --> 12/4 = 3 --> risultato == 3?
        assertEquals(3, risultato);
    }

    @Test
    void divisionePerZero() {

        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();

        // ACT
        float risultato = operazioni.divisione(12,0);

        // TEST
        assertEquals(0, risultato, "la divisione non ritorna zero");

    }

    @Test
    void testNumeroPositivo() {
        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();
        // ACT
        boolean isPositivo = operazioni.isNumeroPositivo(10);
        // TEST
        //assertEquals(true, isPositivo);
        assertTrue(isPositivo);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 15, Integer.MAX_VALUE})
    void testNumeriPositivi(int a) {

        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();

        //ACT
        boolean isPositivo = operazioni.isNumeroPositivo(a);

        // TEST
        assertTrue(isPositivo);
    }


    @ParameterizedTest
    @CsvSource({
            "10, true",
            "50, true",
            "-1, false",
            "-100, false",
            "0, false"
    })
    void testNumeriPositiviENegativi(int numero, boolean expectedResult) {

        // ARRANGE
        OperazioniBase operazioni = createBaseOperationClass();

        //ACT
        boolean isPositivoResult = operazioni.isNumeroPositivo(numero);

        // TEST
        assertEquals(expectedResult, isPositivoResult);
    }
}
