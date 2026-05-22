/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultapreco;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ArquivoLog {

    public void gravaLog(String loja, String codigo, String produto, String preco) {
        Date d = new Date();
        StringBuffer data = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfData = new SimpleDateFormat("dd-MM-yyyy");
        data.append(sdfData.format(d));
        data.append(" ");
        System.out.println("" + data.toString() + sdf.format(d));

        String guardar = data.toString() + "" + sdf.format(d) + " " + loja + "  " + codigo + "\t" + produto + "\t\t\tR$:" + preco;
        File dir = new File("C:\\logConsulta");
        File arq = new File(dir, "Logs de " + data.toString() + ".log");

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String dados[] = guardar.split(";");

            for (int i = 0; i < dados.length; i++) {
                printWriter.println(dados[i]);
            }
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            criarDiretorioLog(guardar, arq);
            System.out.println("Criando diretório...");
            System.out.println(e.toString());

        }

    }

    protected void criarDiretorioLog(String salvar, File arq) {
        try {
            File diretorio = new File("C:\\LogConsulta");
            diretorio.mkdir();
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String dados[] = salvar.split(";");

            for (int i = 0; i < dados.length; i++) {
                printWriter.println(dados[i]);
            }
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            //   JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
    }

}
