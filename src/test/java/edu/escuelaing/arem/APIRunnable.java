package edu.escuelaing.arem;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.escuelaing.arem.API.*;

public class APIRunnable implements Runnable{

    private static final List<String> categoria = Arrays.asList("Intraday","Daily","Monthly", "Weekly");

    @Override
    public void run() {
        Random random = new Random();
        String randomCategoria = categoria.get(random.nextInt(categoria.size()));
        String respuesta = new String();
        try {
            if (randomCategoria.equals("Intraday")) {
                IntraDay intraDay = new IntraDay("IBM", "5min");
                respuesta = intraDay.getStock();
            } else if (randomCategoria.equals("Daily")) {
                Daily daily = new Daily("IBM");
                respuesta = daily.getStock();
            } else if (randomCategoria.equals("Weekly")) {
                Weekly weekly = new Weekly("IBM");
                respuesta = weekly.getStock();
            } else if (randomCategoria.equals("Monthly")) {
                Monthly monthly = new Monthly("IBM");
                respuesta = monthly.getStock();
            }
            System.out.println(randomCategoria + ": " + respuesta.substring(0, 20));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
