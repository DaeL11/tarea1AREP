package edu.escuelaing.arem.API;

import edu.escuelaing.arem.APIClass;

public class Monthly extends APIClass {

    public Monthly(String symbol) {
        super("TIME_SERIES_MONTHLY", symbol);
    }

}