import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ChecarTarefas extends TimerTask {

    String filename;

    public ChecarTarefas(String arquivo) {
        filename = arquivo;
    }

    @Override
    public void run() {
        readCsv();
    }

    private void readCsv() {
        String line = "";
        String cvsSplitBy = ",";
        List tarefas = new ArrayList<Tarefa>();
        Boolean first = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int campos = 0;
            while ((line = br.readLine()) != null) {
                String[] resultado = line.split(cvsSplitBy);
                if(first){
                    first = false;
                    campos = resultado.length;
                } else {
                    if(resultado.length == campos){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNome(resultado[0]);
                        tarefa.setDescricao(resultado[1]);
                        tarefa.setLocal(resultado[2]);
                        tarefa.setDataInicio(converteData(resultado[3]));
                        tarefa.setDataTermino(converteData(resultado[4]));
                        System.out.println(tarefa);
                        tarefas.add(tarefa);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Date converteData(String text) throws Exception {
        if(!text.equals("-")){
            String formatDateTime = "dd/MM/yyyy HH:mm";
            String formatDate = "dd/MM/yyyy";
            SimpleDateFormat fDT = new SimpleDateFormat(formatDateTime);
            SimpleDateFormat fD = new SimpleDateFormat(formatDate);
            if(text.length() == formatDateTime.length())
                return fDT.parse(text);
            return fD.parse(text);
        }
        return null;
    }
}
