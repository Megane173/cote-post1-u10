package com.universidad.enviosservice.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvioInternacionalStrategyTest {

    private EnvioInternacionalStrategy estrategia;

    @BeforeEach
    void setUp() {
        estrategia = new EnvioInternacionalStrategy();
    }

    @Test
    void calcularCosto_PesoHastaCincoKg() {
        double resultado = estrategia.calcular(3, 100);

        assertEquals(230.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_PesoEntreCincoYVeinteKg() {
        double resultado = estrategia.calcular(8, 100);

        assertEquals(239.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_PesoSuperiorAVeinteKg() {
        double resultado = estrategia.calcular(25, 100);

        assertEquals(297.5, resultado, 0.001);
    }

    @Test
    void calcularCosto_DistanciaExactamenteCincoMilKm() {
        double resultado = estrategia.calcular(3, 5000);

        assertEquals(9050.0, resultado, 0.001);
    }

    @Test
    void calcularCosto_DistanciaSuperiorACincoMilKm() {
        double resultado = estrategia.calcular(3, 5001);

        assertEquals(9151.8, resultado, 0.001);
    }
}