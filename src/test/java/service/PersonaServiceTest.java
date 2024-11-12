package service;

import junit.framework.TestCase;
import org.junit.Test;

public class PersonaServiceTest extends TestCase {
    private PersonaService calculadora = new PersonaService();

    @Test
    public void testRaizNumeroPositivo() {
        // Test 1: Prueba con número positivo
        int n1 = 16;
        float resultadoEsperado = 4.0f;
        assertEquals(resultadoEsperado, calculadora.raiz(n1), 0.0001);
    }

    @Test
    public void testRaizNumeroNegativo() {
        // Test 2: Prueba con número negativo, se convierte a positivo
        int n1 = -25;
        float resultadoEsperado = 5.0f;
        assertEquals(resultadoEsperado, calculadora.raiz(n1), 0.0001);
    }

    @Test
    public void testRaizNumeroCero() {
        // Test 3: Prueba con cero
        int n1 = 0;
        float resultadoEsperado = 0.0f;
        assertEquals(resultadoEsperado, calculadora.raiz(n1), 0.0001);
    }

    @Test
    public void testPotenciaPositiva() {
        // Test 1: Base y exponente positivos
        int base = 2;
        int exponente = 3;
        double resultadoEsperado = 8.0;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPotenciaExponenteCero() {
        // Test 2: Exponente es cero
        int base = 5;
        int exponente = 0;
        double resultadoEsperado = 1.0;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPotenciaExponenteNegativo() {
        // Test 3: Exponente negativo
        int base = 2;
        int exponente = -3;
        double resultadoEsperado = 0.125;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPotenciaBaseCeroExponentePositivo() {
        // Test 4: Base es cero y exponente positivo
        int base = 0;
        int exponente = 4;
        double resultadoEsperado = 0.0;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPotenciaBaseNegativaExponentePar() {
        // Test 5: Base negativa y exponente par
        int base = -3;
        int exponente = 2;
        double resultadoEsperado = 9.0;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPotenciaBaseNegativaExponenteImpar() {
        // Test 6: Base negativa y exponente impar
        int base = -2;
        int exponente = 3;
        double resultadoEsperado = -8.0;
        assertEquals(resultadoEsperado, calculadora.potencia(base, exponente), 0.0001);
    }

    @Test
    public void testPiValorConstante() {
        // Test: Verifica que el metodo pi() devuelva el valor constante de Math.PI
        double resultadoEsperado = Math.PI;
        assertEquals(resultadoEsperado, calculadora.pi(), 0.0001);
    }
  
}