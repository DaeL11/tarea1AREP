package edu.escuelaing.arem;

import static spark.Spark.*;

import java.io.IOException;

import spark.Request;

import edu.escuelaing.arem.API.*;

public class SparkWebApp
{
    /**
     * Funcion principal
     * @param args
     */
    public static void main( String[] args ){
        port(getPort());
        staticFiles.location("/public");
        post("/hello", (req, res) -> "Hello " + req.queryParams("name"));
        get("/hello", (req, res) -> "Hello Heroku");
        get("/stock", (req, res) -> {
            res.type("application/json");
            return identifyFunction(req);
        });
    }

    /**
     * Funcion que se encarga de crear el objeto de acuerdo a la eleccion del usuario
     * @param req request
     * @return response del objeto
     * @throws IOException
     */
    private static String identifyFunction(Request req) throws IOException {
        String res = "";
        switch (req.queryParams("function")) {
            case "intraday":
                res = new IntraDay(req.queryParams("symbol"), req.queryParams("interval")).getStock();
                break;
            case "daily":
                res = new Daily(req.queryParams("symbol")).getStock();
                break;
            case "weekly":
                res = new Weekly(req.queryParams("symbol")).getStock();
                break;
            case "monthly":
                res = new Monthly(req.queryParams("symbol")).getStock();
                break;
            default:
                res = "Invalid function";
                break;
        }
        return res;
    }

    /**
     * Funcion con el fin de obtener el puerto por el cual correra el programa
     * @return puerto 
     */
    private static int getPort(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}