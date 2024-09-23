package com.example.BODEGASTCCAPI.helpers.messages;

public enum Mensaje {

    PESO_NEGATIVO("El peso no puede ser negativo"),
    VOLUMEN_NEGATIVO("eL volumen no puede ser negativo"),
    FECHA_INVALIDA("Revisa la fecha ingresada")

    ;

    private String mensaje;

    Mensaje() {
    }

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
