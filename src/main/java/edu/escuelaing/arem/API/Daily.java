package edu.escuelaing.arem.API;

public class Daily extends Alpha{

    /**
     * Constructor de la clase
     * @param symbol identificador de una accion
     */
    public Daily(String symbol) {
        super("TIME_SERIES_DAILY", symbol);
    }

}