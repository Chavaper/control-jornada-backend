package cl.bennu.controljornadabackend.controller.base;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String mensaje,
        String ruta,
        Map<String, String> detalles   // errores de validación por campo (puede ser null)
) {}