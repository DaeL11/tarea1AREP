package edu.escuelaing.arem;

import static spark.Spark.*;

public class SparkWebApp
{
    public static void main( String[] args ){
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        get("/stock", (req, res) -> {
            res.type("application/json");
            return HttpConnection.getStock();
        });
    }
    private static int getPort(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}