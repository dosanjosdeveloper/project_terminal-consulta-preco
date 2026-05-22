package DAO;

import Conexao.ConectaPlug;
import consultapreco.Console;
import consultapreco.dadosConsut;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author rafael.anjos
 */
public class ContatoBank {

    //Configura as variáveis de acordo com o banco
    private final String NOME = "user", SENHA = "pass";
    private Connection conecta;
    private Statement instrucao;

    //Conecta ao Banco (Não esquecer de adicionar a biblioteca)
    public void conectar(String URL) {
        System.out.println("Endereço URL: " + URL);
        try {
            conecta = ConectaPlug.conexao(URL, NOME, SENHA, ConectaPlug.MYSQL);
            instrucao = conecta.createStatement();
            System.out.println("Abre conexão!");

            //JOptionPane.showMessageDialog(null, "Conexão OK!","MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
//          JOptionPane.showMessageDialog(null, "Erro ao Carregar o Driver!\n ERRO: " + e, "ERRO", JOptionPane.ERROR);
            System.out.println("Sem conexão com Servidor!\n" + e);
            //JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR "+e,"MENSAGEM", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fechar() {
        try {
            //instrucao.close();
            conecta.close();
            System.out.println("Fecha Conexão");
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);

        }
    }

    public void buscar(String busca, dadosConsut dado, String URL) {
        conectar(URL);

        ResultSet resultSet;
        System.out.println("Verificando Requisitos Para Consulta do Produto...");
        try {
            resultSet = instrucao.executeQuery("SELECT c.codacesso, a.desccompleta, b.preco, b.promocao FROM(tb_produto AS a JOIN tb_prodpreco AS b ON a.seqproduto = b.seqproduto) \n"
                    + "JOIN tb_prodcodigo AS c ON  c.seqproduto = b.seqproduto WHERE b.qtdembalagem = '1' AND nrosegmento = '" + dado.getSegmento() + "' AND c.codacesso = '" + busca + "'");
//            System.out.println("SELECT c.codacesso, a.desccompleta, b.preco, b.promocao FROM(tb_produto AS a JOIN tb_prodpreco AS b ON a.seqproduto = b.seqproduto) \n"
//                    + "JOIN tb_prodcodigo AS c ON  c.seqproduto = b.seqproduto WHERE b.qtdembalagem = '1' AND nrosegmento = '"+dado.getSegmento()+"' AND c.codacesso = '" + busca + "'");
            while (resultSet.next()) {

                //   dado.setId_contato(Long.parseLong(resultSet.getString("id_contato")));
                dado.setCodigoProd(resultSet.getString("codacesso"));
                dado.setProdDesc(resultSet.getString("desccompleta"));
                dado.setPreco(resultSet.getString("preco"));
                dado.setPromocao(resultSet.getString("promocao"));
                dado.setMedida("UN");

//PARA CONSOLE
                System.out.println(" Produto encontrado; " + dado.getCodigoProd() + " " + dado.getProdDesc() + " " + dado.getPreco() + " " + dado.getPromocao());
            }

//            System.out.println(dado.getCodigoProd());
            if (!Objects.equals(busca, dado.getCodigoProd())) {
                // JOptionPane.showMessageDialog(null, "Dados Não Encontrado!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

                dado.setCodigoProd(busca);
                dado.setProdDesc("PRODUTO NÃO ENCONTRADO");
                dado.setPreco("0");
                dado.setPromocao(null);
                dado.setMedida(null);

                System.out.println("Produto não encontrado!");
            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
                dado.setCodigoProd(busca);
                dado.setProdDesc("FALHA CONEXÃO");
                dado.setPreco("0");
                dado.setPromocao(null);
                dado.setMedida(null);
//            JOptionPane.showMessageDialog(null, "CONEXÃO PERDIDA!\n REINICIE APLICAÇÃO POR FAVOR!", "FALHA CONEXÃO!!!", JOptionPane.WARNING_MESSAGE);
            System.out.println("Erro SQL! Verificar: \n" + e);
        }
        //System.out.println("Teste " + busca);
        fechar();
        //seta.setDadosProdct(dado);
    }

    // PARA FUNCIONAMENTO EM CONSOLE
    public void buscar(String busca, String URL) {
        Console seta = new Console();
        conectar(URL);
        dadosConsut dado = new dadosConsut();
        ResultSet resultSet;
        System.out.println("Verificando Requisitos Para Consulta do Produto...");
        try {
            resultSet = instrucao.executeQuery("SELECT c.codacesso, a.desccompleta, b.preco, b.promocao FROM(tb_produto AS a JOIN tb_prodpreco AS b ON a.seqproduto = b.seqproduto) \n"
                    + "JOIN tb_prodcodigo AS c ON  c.seqproduto = b.seqproduto WHERE b.qtdembalagem = '1' AND nrosegmento = '1' AND c.codacesso = '" + busca + "'");

            while (resultSet.next()) {

                //   dado.setId_contato(Long.parseLong(resultSet.getString("id_contato")));
                dado.setCodigoProd(resultSet.getString("codacesso"));
                dado.setProdDesc(resultSet.getString("desccompleta"));
                dado.setPreco(resultSet.getString("preco"));
                dado.setPromocao(resultSet.getString("promocao"));

//ENVIA PARA O PUBLIC
//PARA CONSOLE
                System.out.println(" Produto encontrado; " + dado.getCodigoProd() + " " + dado.getProdDesc() + " " + dado.getPreco() + " " + dado.getPromocao());
            }

//            System.out.println(dado.getCodigoProd());
            if (!Objects.equals(busca, dado.getCodigoProd())) {
                // JOptionPane.showMessageDialog(null, "Dados Não Encontrado!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Produto não encontrado!");
                dado.setCodigoProd(busca);
                dado.setProdDesc("PRODUTO NÃO ENCONTRADO");
                dado.setPreco(null);
                dado.setPromocao(null);
                seta.setDadosProdct(dado);
            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
            System.out.println("Erro SQL! Verificar: \n" + e);
        }
        //System.out.println("Teste " + busca);
        fechar();

        // seta.setDadosProdct(dado);
    }

    public void buscarLoja(dadosConsut dado, String busca, String URL) {

        conectar(URL);
//        dadosConsut dado = new dadosConsut();
        ResultSet resultSet;
        System.out.println("Verificando Loja...");
        try {
            resultSet = instrucao.executeQuery("" + busca);

            while (resultSet.next()) {

                //   dado.setId_contato(Long.parseLong(resultSet.getString("id_contato")));
                dado.setLoja(resultSet.getString("nomereduzido"));

                System.out.println("Loja encontrada: " + resultSet.getString("nomereduzido"));

            }

//            System.out.println(dado.getCodigoProd());
            if (dado.getLoja() == null) {
                // JOptionPane.showMessageDialog(null, "Dados Não Encontrado!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Loja Não Encontrada!");

            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
            System.out.println("Erro SQL! Verificar: \n" + e);
        }
        //System.out.println("Teste " + busca);
        fechar();

        // seta.setDadosProdct(dado);
    }

    public void buscarSegmento(dadosConsut dado, String busca, String URL) {

        conectar(URL);
//        dadosConsut dado = new dadosConsut();
        ResultSet resultSet;
        System.out.println("Verificando Segmento...");
        try {
            resultSet = instrucao.executeQuery("" + busca);

            while (resultSet.next()) {

                //   dado.setId_contato(Long.parseLong(resultSet.getString("id_contato")));
                dado.setSegmento(resultSet.getString("valor"));

                System.out.println("Segmento: " + resultSet.getString("valor"));

            }

//            System.out.println(dado.getCodigoProd());
            if (dado.getSegmento() == null) {
                // JOptionPane.showMessageDialog(null, "Dados Não Encontrado!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Não Encontrado!");

            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
            System.out.println("Erro SQL! Verificar: \n" + e);
        }
        //System.out.println("Teste " + busca);
        fechar();

        // seta.setDadosProdct(dado);
    }

    public void conectarURL(String URL, dadosConsut dado) {

        System.out.println("Endereço URL: " + URL);
        try {
            conecta = ConectaPlug.conexao(URL, NOME, SENHA, ConectaPlug.MYSQL);
            instrucao = conecta.createStatement();
            System.out.println("Abre conexão!");
            dado.setURL(URL);

            //JOptionPane.showMessageDialog(null, "Conexão OK!","MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
//          JOptionPane.showMessageDialog(null, "Erro ao Carregar o Driver!\n ERRO: " + e, "ERRO", JOptionPane.ERROR);
            System.out.println("Sem conexão com Servidor!\n" + e);
            //JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR "+e,"MENSAGEM", JOptionPane.ERROR_MESSAGE);
        }
    }

  
}
