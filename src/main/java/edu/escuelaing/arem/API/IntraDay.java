package edu.escuelaing.arem.API;


public class IntraDay extends Alpha{

    public IntraDay(String symbol, String interval) {
        super("TIME_SERIES_INTRADAY", symbol);
        parameters.add(2, "&interval=");
        input.add(2, interval);
        buildQuery();
    }

}
