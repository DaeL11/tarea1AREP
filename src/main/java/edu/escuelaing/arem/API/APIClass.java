package edu.escuelaing.arem.API;

import java.io.IOException;
import java.util.ArrayList;
import edu.escuelaing.arem.HttpConnection;

public class APIClass{


    private static final String GET_URL = "https://www.alphavantage.co/query?";
    private static final String API_KEY = "&apikey=8US7JKS3WL37HQK9";

    protected ArrayList<String> parameters = new ArrayList<>();
    protected ArrayList<String> input = new ArrayList<>();
    private StringBuilder query;
    private Cache cache = Cache.getInstance();

    public APIClass(String function, String symbol) {
        buildParameters();
        input.add(function);
        input.add(symbol);
        buildQuery();
    }

    public void buildParameters() {
        parameters.add("function=");
        parameters.add("&symbol=");
    }

    public void buildQuery() {
        query = new StringBuilder();
        byte counter = 0;
        query.append(GET_URL);
        for (String parameter : parameters) {
            query.append(parameter);
            try {
                query.append(input.get(counter));
            } catch (IndexOutOfBoundsException indexBounds) {
                System.out.println("Intended out of bounds error access. Skipping");
                System.out.println("In AlphaVantageQuery.java - buildQuery()");
            }
            counter++;
        }
        query.append(API_KEY);
    }

    public String getStock() throws IOException {
        String response = "GET request not worked";
        if (cache.contains(query.toString())) {
            return cache.getKey(query.toString());
        } else {
            HttpConnection httpConnection = new HttpConnection();
            response = httpConnection.getStock(query.toString());
            if(response != "GET request not worked"){
                cache.insertCache(query.toString(), response);
            }
        }
        return response;
    }

}
