
package controller;



import java.sql.PreparedStatement;
import model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConnectionFactory;
import java.util.List;


//Class para criar os metodos para consultar,inserir,atualizar e deletar no DB
public class TaskController {
    
    public void save(Task task){
        String sql = "INSERT INTO tasks(idFkTask, name, description, completed, "
                + "comments, deadline, createdDate, updatedDate) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        //Essas duas variaveis est�o fora do bloco try, pois se estiver dentro
        //de try n�o podera ser acessada no finally para encerrar
        Connection connection = null;
        PreparedStatement statement = null;
        //Sempre que tiver uma situa��o que possa dar erro, deve-se colocar o 
        //bloco try
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdFkTask());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getCompleted());
            statement.setString(5, task.getComments());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            //O Date que o java passa � diferente a do SQL
            //Portanto esse Date entre Parenteses est� com o import 
            //java.SQL.Date
            
            System.out.println("idFk" + task.getIdFkTask() + "complete" 
                    + task.getCompleted() + "deadline" + task.getDeadline()
                    + "createdDate" + task.getCreatedDate() + "Update" 
                    + task.getUpdatedDate() );
            statement.setDate(7, new Date (task.getCreatedDate().getTime()));
            statement.setDate(8, new Date (task.getUpdatedDate().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " 
                    + ex.getMessage(), ex);
//             System.out.println("Erro de salvar no Banco de Dados");
        }finally{
            //Finaliza a conex�o e o statement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                
                System.out.println("CONEX�O FECHADA");
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conex�o", ex);
            }
        }
    }
    
    public void update(Task task){
        String sql = "UPDATE tasks SET idFkTask = ?, name = ?, description = ?,"
                + "completed = ?, comments = ?, deadline = ?,"
                + "createdDate = ?, updatedDate = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdFkTask());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getCompleted());
            statement.setString(5, task.getComments());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date (task.getCreatedDate().getTime()));
            statement.setDate(8, new Date(task.getUpdatedDate().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa " 
                    + ex.getMessage(), ex);
        }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conex�o", ex);
            }
        }
        
    }
    
    public void removeById(int taskId) throws SQLException{
        //Cria uma variavel para armazenar o comando SQL.
        String sql = "DELETE FROM tasks WHERE idFkTask = ?";
        //Criar 2 variaveis Connection e PreparedStatment
        Connection connection = null;
        PreparedStatement statement = null;
        try{//Abaixo o comando vai pedir a conex�o
            connection = ConnectionFactory.getConnection();
            //O statement Prepara o comando SQL para ser executado pela conex�o
            statement = connection.prepareStatement(sql);
            //Abaixo o statement prepara o paramentro da interroga��o
            //O numero 1 seta parametro da variavel "sql" a "?"
            statement.setInt(1, taskId); 
            //Agora � s� executar o comando no SQL e deleta uma tarefa
            statement.execute();
            //Esse Exception trata qualquer exec�o
        }catch (Exception ex){
            throw new RuntimeException("Erro ao deletar a tarefa." + 
                    ex.getMessage(), ex);
        //Esse bloco finally sempre ser� executado no bloco try
        //O finally foi criado para fechar a conex�o
       }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conex�o", ex);
            }
        }
    }
    // O parametro idFkTask � a chave estrageira
    public List<Task> getAll(int IdFkTask){
        String sql = "SELECT * FROM tasks where idFkTask = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        //Esse Result � para guardar a lista do retorno do DB SQL
        ResultSet resultSet = null;
        //Lista de tarefas que ser� devolvida quando a chamada do metodo acontecer
        List<Task> task = new ArrayList<Task>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, IdFkTask);
            //O execut.query() retorna uma lista que resultSet receber�
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                
                Task lista = new Task();
                lista.setId(resultSet.getInt("id"));
                lista.setIdFkTask(resultSet.getInt("idFkTask"));
                lista.setName(resultSet.getString("name"));
                lista.setDescription(resultSet.getString("description"));
                lista.setCompleted(resultSet.getBoolean("completed"));
                lista.setComments(resultSet.getString("comments"));
                lista.setDeadline(resultSet.getDate("deadline"));
                lista.setCreatedDate(resultSet.getDate("createdDate"));
                lista.setUpdatedDate(resultSet.getDate("updatedDate"));
                
                task.add(lista);
              
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar as tabelas" 
                    + ex.getMessage(), ex);
        }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conex�o", ex);
            }
        }    
        return task;
    }
    
}
