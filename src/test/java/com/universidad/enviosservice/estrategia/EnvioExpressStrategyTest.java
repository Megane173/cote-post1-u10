package com.universidad.enviosservice.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvioExpressStrategyTest {

    private EnvioExpressStrategy estrategia;

    @BeforeEach
    void setUp() {
        estrategia = new EnvioExpressStrategy();
    }

    @Test
    void calcular_PesoHastaCincoKg() {
        double resultado = estrategia.calcular(3, 100);

        assertEquals(156.0, resultado, 0.001);
    }

    @Test
    void calcular_PesoEntreCincoYVeinteKg() {
        double resultado = estrategia.calcular(8, 100);

        assertEquals(161.85, resultado, 0.001);
    }

    @Test
    void calcular_PesoSuperiorAVeinteKg() {
        double resultado = estrategia.calcular(25, 100);

        assertEquals(198.25, resultado, 0.001);
    }

    @Test
    void calcular_DistanciaExactamenteQuinientosKm() {
        double resultado = estrategia.calcular(3, 500);

        assertEquals(780.0, resultado, 0.001);
    }

    @Test
    void calcular_DistanciaSuperiorAQuinientosKm() {
        double resultado = estrategia.calcular(3, 501);

        assertEquals(814.06, resultado, 0.001);
    }
}