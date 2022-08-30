package edu.escuelaing.arem.API;

import edu.escuelaing.arem.APIClass;

public class IntraDay extends APIClass {

    public IntraDay(String symbol, String interval) {
        super("TIME_SERIES_INTRADAY", symbol);
        parameters.add(2, "&interval=");
        input.add(2, interval);
        buildQuery();
    }

}
