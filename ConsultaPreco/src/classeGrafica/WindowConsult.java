package classeGrafica;

import DAO.ContatoBank;
import consultapreco.ArquivoLog;

import consultapreco.dadosConsut;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author rafael.anjos
 * COMPILAÇÃO 29/11/2016 v1.0
 */
public class WindowConsult extends javax.swing.JFrame {

    String messageCodigo = "INFORME O CÓDIGO DE BARRAS DO PRODUTO";
    URL url = this.getClass().getResource("super_logo.png");
    String servidorPDV;
    Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
    Timer timer;
    String URL;
    dadosConsut dado = new dadosConsut();
    ContatoBank busca = new ContatoBank();
    String codigoBusca;
    ArquivoLog log = new ArquivoLog();
//    CheckRead checkrede = new CheckRead();

    /**
     * Creates new form WindowConsult
     */
    public WindowConsult() {
        initComponents();
        statusCheckRede();
        URL = dado.getURL();
//        System.out.println(dado.getURL());
        dadoLoja();
        segmentoLoja();

        //INICIA JANELA MAXIMIZADA       
        setExtendedState(MAXIMIZED_BOTH);
//      PARA SETAR A JANELA NO CENTRO DO DISPLAY
        this.setLocationRelativeTo(null);
//        SETAR ICONE NA PARTE SUPERIOR DA APLICAÇAO
        this.setIconImage(imagemTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsult = new javax.swing.JPanel();
        jPanelBaseInferior = new javax.swing.JPanel();
        jPanelBaseInferior2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFieldCodigo = new javax.swing.JTextField();
        jPanelBaseSuperior = new javax.swing.JPanel();
        jPanelBseSuperior2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextMedida = new javax.swing.JTextField();
        jFormatPreco = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelMessages = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminal Consulta de Preço Supernorte");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelConsult.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConsult.setPreferredSize(new java.awt.Dimension(720, 1080));

        jPanelBaseInferior.setBackground(new java.awt.Color(255, 102, 0));

        jPanelBaseInferior2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Cooper Black", 2, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Supernorte");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelBaseInferior2Layout = new javax.swing.GroupLayout(jPanelBaseInferior2);
        jPanelBaseInferior2.setLayout(jPanelBaseInferior2Layout);
        jPanelBaseInferior2Layout.setHorizontalGroup(
            jPanelBaseInferior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelBaseInferior2Layout.setVerticalGroup(
            jPanelBaseInferior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFieldCodigo.setBackground(new java.awt.Color(255, 102, 0));
        jFieldCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jFieldCodigo.setForeground(new java.awt.Color(204, 204, 204));
        jFieldCodigo.setToolTipText("");
        jFieldCodigo.setBorder(null);
        jFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFieldCodigoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaseInferiorLayout = new javax.swing.GroupLayout(jPanelBaseInferior);
        jPanelBaseInferior.setLayout(jPanelBaseInferiorLayout);
        jPanelBaseInferiorLayout.setHorizontalGroup(
            jPanelBaseInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseInferior2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelBaseInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBaseInferiorLayout.setVerticalGroup(
            jPanelBaseInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseInferiorLayout.createSequentialGroup()
                .addComponent(jFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelBaseInferior2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelBaseSuperior.setBackground(new java.awt.Color(255, 102, 0));

        jPanelBseSuperior2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cooper Black", 2, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Preço");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelBseSuperior2Layout = new javax.swing.GroupLayout(jPanelBseSuperior2);
        jPanelBseSuperior2.setLayout(jPanelBseSuperior2Layout);
        jPanelBseSuperior2Layout.setHorizontalGroup(
            jPanelBseSuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        jPanelBseSuperior2Layout.setVerticalGroup(
            jPanelBseSuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBaseSuperiorLayout = new javax.swing.GroupLayout(jPanelBaseSuperior);
        jPanelBaseSuperior.setLayout(jPanelBaseSuperiorLayout);
        jPanelBaseSuperiorLayout.setHorizontalGroup(
            jPanelBaseSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBseSuperior2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelBaseSuperiorLayout.setVerticalGroup(
            jPanelBaseSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseSuperiorLayout.createSequentialGroup()
                .addComponent(jPanelBseSuperior2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jTextMedida.setFont(new java.awt.Font("Tahoma", 1, 105)); // NOI18N
        jTextMedida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextMedida.setBorder(null);
        jTextMedida.setFocusable(false);

        jFormatPreco.setEditable(false);
        jFormatPreco.setBorder(null);
        jFormatPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormatPreco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormatPreco.setFocusable(false);
        jFormatPreco.setFont(new java.awt.Font("Tahoma", 1, 120)); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 102, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(4);
        jTextArea1.setTabSize(0);
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelMessages.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMessages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessages.setText("PASSE O CÓDIGO DE BARRAS DO PRODUTO NO LEITOR");
        jLabelMessages.setToolTipText("");

        javax.swing.GroupLayout jPanelConsultLayout = new javax.swing.GroupLayout(jPanelConsult);
        jPanelConsult.setLayout(jPanelConsultLayout);
        jPanelConsultLayout.setHorizontalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabelMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBaseInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormatPreco))
                .addContainerGap())
        );
        jPanelConsultLayout.setVerticalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultLayout.createSequentialGroup()
                .addComponent(jPanelBaseSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormatPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBaseInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConsult, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFieldCodigoKeyPressed
        //abaixo é só mudar o ENTER para o código que da tecla que vc deseja...
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            setaCampos();
            TimerLimpar();
        }
        //System.out.println("Qualquer Tecla!!! "+evt);
    }//GEN-LAST:event_jFieldCodigoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowConsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowConsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowConsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowConsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new WindowConsult().setVisible(true);

//                System.out.println(System.currentTimeMillis());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jFieldCodigo;
    private javax.swing.JFormattedTextField jFormatPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMessages;
    private javax.swing.JPanel jPanelBaseInferior;
    private javax.swing.JPanel jPanelBaseInferior2;
    private javax.swing.JPanel jPanelBaseSuperior;
    private javax.swing.JPanel jPanelBseSuperior2;
    private javax.swing.JPanel jPanelConsult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextMedida;
    // End of variables declaration//GEN-END:variables

    public void setLimpar() {

        jTextArea1.setText(null);
        jTextMedida.setText(null);
        jFormatPreco.setText(null);
    }

    private void setaCampos() {
        codigoBusca = jFieldCodigo.getText();
        //LIMPA CAMPOS IMEDIATAMENTE CASO PASSE O PRODUTO NOVAMENTE RÁPIDO
        jFieldCodigo.setText(null);

        busca.buscar(codigoBusca, dado, URL);

        //SETA DADO PARA OS CAMPOS APÓS CONSULTA
        jTextMedida.setText(dado.getMedida());
        //jFieldCodigo.setText(dado.getCodigoProd());
        jTextArea1.setText(dado.getProdDesc());
        jFormatPreco.setText(dado.getPreco());
        jLabelMessages.setText("CÓDIGO: " + dado.getCodigoProd());

        //    FORMATA O CAMPO PARA INSERIR VALOR DO PRODUTO FORMATADO
        Double valor = Double.valueOf(dado.getPreco());
        NumberFormat precoFormatado = NumberFormat.getCurrencyInstance();
        jFormatPreco.setText(precoFormatado.format(valor));

        log.gravaLog(dado.getLoja(), dado.getCodigoProd(), dado.getProdDesc(), dado.getPreco());
    }

    private void dadoLoja() {
        String strQuery = "SELECT b.nomereduzido FROM tb_parametro AS a JOIN tb_empresa AS b ON a.valor = b.nroempresa \n"
                + " WHERE a.grupo = 'geral' AND a.parametro = 'Nroempresa'";
        busca.buscarLoja(dado, strQuery, URL);
        this.setTitle("Terminal Consulta de Preço Supernorte " + dado.getLoja() + " - SERVIDOR: (" + servidorPDV + ") Compilação 16-10-2018");
    }

    private void segmentoLoja() {
        String strQuery = "SELECT valor FROM tb_parametro WHERE grupo = 'geral' AND parametro = 'NroSegmento'";
        busca.buscarSegmento(dado, strQuery, URL);
//        System.out.println("Segmento: "+dado.getSegmento());
    }

    class retornaNullo extends TimerTask {

        @Override
        public void run() {
//            System.out.println("Time's up Este!");
            jTextArea1.setText(null);
            jTextMedida.setText(null);
            jFormatPreco.setText(null);
            jLabelMessages.setText(messageCodigo);
            //Parar Execução do Timer
            timer.cancel();
        }
    }

    public void TimerLimpar() {
        timer = new Timer();
        timer.schedule(new retornaNullo(), 7 * 1000);
    }

    public String getIP(String ip) {

        return null;
    }

    ContatoBank banco = new ContatoBank();

    public void statusCheckRede() {
        String machineLocal = null, adressLocal = null;
        //      VERIFICA IP E NOME DA MÁQUINA
        System.out.println("DETECTANDO HOSTA MÁQUINA E IP;");
        try {
            machineLocal = InetAddress.getLocalHost().getHostName();
            System.out.println(machineLocal);
            adressLocal = InetAddress.getLocalHost().getHostAddress();
            System.out.println("IP Local 2 "+adressLocal);

        } catch (UnknownHostException e) {
            System.out.println("Adaptador de Rede Ausente \n" + e);
        }

        if (!adressLocal.equals("127.0.0.1")) {
            System.out.println("IP: " + adressLocal + "  CONECTADO!");
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

            }
            if (contaPonto < 3) {
                formaIpServer = formaIpServer + "" + adressIP[i];
            }
        }

        System.out.println(formaIpServer);
        // conectServer.setText(formaIpServer+".");
        //System.out.println(formaIpServer);
        do {
            for (int i = 101; i <= 110; i++) {
                URLbank = "jdbc:mysql://" + formaIpServer + "." + i + ":3306/consinco";
                System.out.println("Pesquisando Servidor: " + i + " ...");
                banco.conectarURL(URLbank, dado);

                if (URLbank.equals(dado.getURL())) {
                    serveEncontrado = false;
                    servidorPDV = "" + i;
                    System.out.println("Link Guardado " + dado.getURL());
                    banco.fechar();
                    System.out.println(serveEncontrado);
                    i = 110;
                }
            }

        } while (serveEncontrado);
    }
}
