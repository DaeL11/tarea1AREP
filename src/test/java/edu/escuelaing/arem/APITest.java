package edu.escuelaing.arem;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class APITest {
    
    /**
     * Funcion principal para realizar el Test del API
     * los hilos estan limitados a 10
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        int hilos = 5;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (hilos > 0) {
            hilos--;
            pool.execute(new APIRunnable());
        }
        pool.shutdown();
    }
}
