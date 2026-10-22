package com.universidad.enviosservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ServicioCalculoEnvioTest {

    private final ServicioCalculoEnvio servicio =
            new ServicioCalculoEnvio();

    @Test
    void aplicaRecargoPorFragilidad() {
        // ESTANDAR: 100 * 0.5 = 50
        // Fragilidad: 50 * 1.15 = 57.5
        double costo = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "REGULAR", true
        );

        assertEquals(57.5, costo, 0.01);
    }

    @Test
    void aplicaDescuentoPremium() {
        // ESTANDAR: 50 * 0.90 = 45
        double costo = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "PREMIUM", false
        );

        assertEquals(45.0, costo, 0.01);
    }

    @Test
    void aplicaDescuentoCorporativo() {
        // ESTANDAR: 50 * 0.85 = 42.5
        double costo = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "CORPORATIVO", false
        );

        assertEquals(42.5, costo, 0.01);
    }

    @Test
    void aplicaFragilidadAntesDelDescuentoCorporativo() {
        // 50 * 1.15 = 57.5
        // 57.5 * 0.85 = 48.875
        double costo = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "CORPORATIVO", true
        );

        assertEquals(48.875, costo, 0.01);
    }

    @Test
    void rechazaMetodoDeEnvioNoSoportado() {
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> servicio.calcularCosto(
                        "ECONOMICO", 3.0, 100.0, "REGULAR", false
                )
        );

        assertEquals(
                "Metodo de envio no soportado: ECONOMICO",
                excepcion.getMessage()
        );
    }
}