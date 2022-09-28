
package util;



import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConnectionFactory {
    //Classe para criar atributos para conex�o com o Banco de Dados.

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3307/" 
            + "euxo?characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static java.sql.Connection getConnection(){
        //M�todo para fazer a conex�o com o Banco de Dados.
        //O Try/Catch faz tratamento de erro como o try;/exception
//      //TLS_AES_256_GCM_SHA384
        try{
            Class.forName(DRIVER).getConstructor().newInstance();;
            return DriverManager.getConnection(URL, USER, PASS);
            //O DrivrManager faz a conex�o com os paramentro
        }catch (Exception ex){
            String mensage = "Erro de conex�o com o banco de dados.";
            throw new RuntimeException(mensage, ex);
        }
    }
    
    public static void CloseConnection(Connection connection){
        //M�todo para fechar a conex�o com o Banco de Dados.
        try{
            if (connection!= null){
                connection.close();
            }
        }catch (Exception ex){
            String mensage = "Erro ao fechar conex�o com o banco de dados.";
            throw new RuntimeException(mensage, ex);
        }
    }
    //Pode existir 2 ou mais metodos iguais, mas com quantidade de parametros 
    //diferentes, ou pelo menos 1 diferente
    public static void CloseConnection(Connection connection , 
            PreparedStatement statement){
        //M�todo para fechar a conex�o com o Banco de Dados e o statement.
        try{
            if (connection!= null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        }catch (Exception ex){
            String mensage = "Erro ao fechar conex�o com o banco de dados.";
            throw new RuntimeException(mensage, ex);
        }
    }
    
    public static void CloseConnection(Connection connection , 
            PreparedStatement statement, ResultSet resultSet){
        //M�todo para fechar a conex�o com o Banco de Dados e o statement.
        try{
            if (connection!= null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }catch (Exception ex){
            String mensage = "Erro ao fechar conex�o com o banco de dados.";
            throw new RuntimeException(mensage, ex);
        }
    }
    
}
