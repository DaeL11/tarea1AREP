package edu.escuelaing.arem.API;

import edu.escuelaing.arem.APIClass;

public class Alpha extends APIClass{

    /**
     * Atributos predeterminados de AlphaAvantage
     */
    private static final String GET_URL = "https://www.alphavantage.co/query?";
    private static final String API_KEY = "&apikey=8US7JKS3WL37HQK9";

    /**
     * Constructor de la clase
     * @param function 
     * @param symbol
     */
    public Alpha(String function, String symbol) {
        super(GET_URL, API_KEY);
        buildParameters();
        input.add(function);
        input.add(symbol);
        buildQuery();
    }

    /**
     * Funcion que agrega al arraylist la funcion y el simbolo  
     * para una posterior consulta de parametros
     */
    public void buildParameters(){
        parameters.add("function=");
        parameters.add("&symbol=");
    }
    
}
