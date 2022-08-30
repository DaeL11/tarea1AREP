package edu.escuelaing.arem.API;

import edu.escuelaing.arem.APIClass;

public class Daily extends APIClass{

    public Daily(String symbol) {
        super("TIME_SERIES_DAILY", symbol);
    }

}