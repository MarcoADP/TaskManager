import java.io.*;
import java.util.Calendar;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        InputStream input = null;

        input = new FileInputStream("config.properties");
        prop.load(input);

        String medida = prop.getProperty("medida");
        String intervalo = prop.getProperty("intervalo");
        String arquivo = prop.getProperty("arquivo");

        Timer time = new Timer();
        time.schedule(new ChecarTarefas(arquivo), 0L, getPeriodo(medida, intervalo));

    }

    private static long getPeriodo(String medida, String intervalo) {
        long interval = Long.parseLong(intervalo);
        medida = medida.toUpperCase();
        switch (medida){
            case "MILISSEGUNDOS":
                return interval;
            case "SEGUNDOS":
                return interval * 1000;
            case "MINUTOS":
                return interval * 1000 * 60;
            case "HORAS":
                return interval * 1000 * 60 * 60;
        }

        return 1000 * 60;
    }

}
