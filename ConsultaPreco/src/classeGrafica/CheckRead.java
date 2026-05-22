package classeGrafica;

import DAO.ContatoBank;
import consultapreco.dadosConsut;
import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckRead {

    ContatoBank banco = new ContatoBank();
    dadosConsut dado = new dadosConsut();

    public void statusCheckRede(dadosConsut dados) {
        String machineLocal = null, adressLocal = null;
        //      VERIFICA IP E NOME DA MÁQUINA
        System.out.println("Verficando nome de Máquina e IP;");
        try {
            machineLocal = InetAddress.getLocalHost().getHostName();
            System.out.println(machineLocal);
            adressLocal = InetAddress.getLocalHost().getHostAddress();
            System.out.println("IP Local "+adressLocal);

        } catch (UnknownHostException e) {
            System.out.println("Adaptador de Rede Ausente \n" + e);
        }

        if (!adressLocal.equals("127.0.0.1")) {
            System.out.println("IP: " + adressLocal + "  Conectado!");
            statusCheckServer(adressLocal);

        } else {

            System.out.println("NÃO CONECTADO!");

        }
    }

    private void statusCheckServer(String Adress) {
        char adressIP[] = Adress.toCharArray();;
        boolean serveEncontrado = true;
        String URLbank = null;
        String formaIpServer = "";
        int contaPonto = 0;
        for (int i = 0; i < adressIP.length; i++) {
//            System.out.println(""+adressIP[i]);
            if (adressIP[i] == '.') {
                contaPonto++;
                System.out.println(formaIpServer);
            }
            if (contaPonto < 3) {
                formaIpServer = formaIpServer + "" + adressIP[i];
            }
        }
        // conectServer.setText(formaIpServer+".");
        //System.out.println(formaIpServer);
        do {
            for (int i = 101; i < 110; i++) {
                URLbank = "jdbc:mysql://" + formaIpServer + "." + i + ":3306/consinco";
                System.out.println("Pesquisando Servidor: " + i + " ...");
                banco.conectarURL(URLbank, dado);

                if (URLbank.equals(dado.getURL())) {
                    serveEncontrado = false;
                    System.out.println("Link Guardado " + dado.getURL());
                    banco.fechar();
                    System.out.println(serveEncontrado);
                    i=110;                   
                }
                
                
            }

        } while (serveEncontrado);
    }
}
