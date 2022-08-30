package edu.escuelaing.arem.API;

public class Monthly extends Alpha{

    /**
     * Constructor de la clase
     * @param symbol identificador de una accion
     */
    public Monthly(String symbol) {
        super("TIME_SERIES_MONTHLY", symbol);
    }

}