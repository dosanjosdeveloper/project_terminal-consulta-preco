package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaPlug {
    //Informações para conexão, e tipo de driver ao banco
    public static final int MYSQL=0;
    private static final String MySQLDriver="com.mysql.jdbc.Driver";
    public static Connection conexao(String url, String nome, String senha, int banco ) throws SQLException {
        switch(banco){
            case MYSQL:
        {
            try {
                Class.forName(MySQLDriver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConectaPlug.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
                break;                          
        }
        return DriverManager.getConnection(url, nome,senha);
            
    }
}   


/**
 * Class cls = Main.class;
ProtectionDomain pDomain = cls.getProtectionDomain();
CodeSource cSource = pDomain.getCodeSource();
URL loc = cSource.getLocation();
JOptionPane.showMessageDialog(null, loc.toString().substring(5));
String comando = "java -jar " + loc.toString().substring(5);
JOptionPane.showMessageDialog(null, comando);
try {
	 Process Processo = Runtime.getRuntime().exec(comando);
     } catch ( IOException MensagemdeErro ) 
     {
	     System.out.println(MensagemdeErro);
     }
     System.exit(0);
*/
