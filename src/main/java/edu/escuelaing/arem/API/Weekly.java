package edu.escuelaing.arem.API;

import edu.escuelaing.arem.APIClass;

public class Weekly extends APIClass{

    public Weekly(String symbol) {
        super("TIME_SERIES_WEEKLY", symbol);
    }

}
