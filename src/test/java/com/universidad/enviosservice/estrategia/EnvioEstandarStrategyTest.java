package com.universidad.enviosservice.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvioEstandarStrategyTest {

    private EnvioEstandarStrategy estrategia;

    @BeforeEach
    void setUp() {
        estrategia = new EnvioEstandarStrategy();
    }

    @Test
    void calcularCosto_PesoHastaCincoKg() {
        double resultado = estrategia.calcular(3, 100);

        assertEquals(50.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_PesoEntreCincoYVeinteKg() {
        double resultado = estrategia.calcular(8, 100);

        assertEquals(52.4, resultado, 0.001);
    }

    @Test
    void calcularCosto_PesoSuperiorAVeinteKg() {
        double resultado = estrategia.calcular(25, 100);

        assertEquals(68.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_DistanciaExactamenteQuinientosKm() {
        double resultado = estrategia.calcular(3, 500);

        assertEquals(250.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_DistanciaSuperiorAQuinientosKm() {
        double resultado = estrategia.calcular(3, 501);

        assertEquals(260.5, resultado, 0.001);
    }
}