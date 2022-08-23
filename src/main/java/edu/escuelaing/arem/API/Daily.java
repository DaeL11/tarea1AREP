package edu.escuelaing.arem.API;

public class Daily extends APIClass{

    public Daily(String symbol) {
        super("TIME_SERIES_DAILY", symbol);
    }

}