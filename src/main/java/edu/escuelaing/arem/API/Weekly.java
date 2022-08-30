package edu.escuelaing.arem.API;

public class Weekly extends Alpha{

    /**
     * Constructor de la clase
     * @param symbol identificador de una accion
     */
    public Weekly(String symbol) {
        super("TIME_SERIES_WEEKLY", symbol);
    }

}
