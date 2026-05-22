package consultapreco;

import DAO.ContatoBank;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author rafael.anjos
 */
public class Console {

    dadosConsut dado = new dadosConsut();

    public static void main(String[] args) throws UnknownHostException {
        ContatoBank busca = new ContatoBank();
        Scanner ler = new Scanner(System.in);

        try {
            System.out.println(InetAddress.getLocalHost().getHostName());
            System.out.println(InetAddress.getLocalHost().getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println(e);
        }

        if (!InetAddress.getLocalHost().getHostAddress().equals("127.0.0.1")) {
            System.out.println("Dispositivo em Rede!");
            System.out.printf("Entre com o código; ");
            String ler2 = ler.nextLine();
            //System.out.println(ler2);
//            busca.buscar(ler2);
        } else {
            System.out.println("Dipositivo Não Conectado!");
        }
    }

    public void setDadosProdct(dadosConsut dado) {
        //PARA CONSOLE
        System.out.println(" Produto encontrado; " + dado.getCodigoProd() + " " + dado.getProdDesc() + " " + dado.getPreco() + " " + dado.getPromocao());
    }

}
