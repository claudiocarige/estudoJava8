

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConnectionFactory;
import model.Project;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;



public class ProjectController {
    
    public void saveProject(Project project){
        
        String sql = "INSERT INTO projects(name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabeleca uma conexão com o DB
            connection = ConnectionFactory.getConnection();
            //Cria uma PrepareStatement, class usada para executar a query
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            
            //Executa sql para inserção de dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar Projeto", ex);
        }finally{
           try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
    }
    
    public void Update(Project project){
        
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelece a conexãocm o banco de dados.
            connection = ConnectionFactory.getConnection();//Preparando query com o DB
            statement = connection.prepareStatement(sql);
            //Setando os valores
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.setInt(5,project.getIdProject());
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto. ", ex);
        }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
    }
    
    public void removeById(int idProject){
        
        String sql = "DELETE FROM projects WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,idProject);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar Projeto.", ex);
        }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
    }    
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        
        //Lista de Projetos que será devolvida quando a chamada do método 
        //acontecer
        List<Project> project = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        try {
            //Criando a conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Valor retornado pelo DB
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                
                Project lista = new Project();
                
                lista.setIdProject(resultSet.getInt("idProject"));
                lista.setName(resultSet.getString("name"));
                lista.setDescription(resultSet.getString("description"));
                lista.setCreatedAt(resultSet.getDate("createdAt"));
                lista.setUpdateAt(resultSet.getDate("updatedAt"));
                
                project.add(lista);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os projetos", ex);
        }finally{
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
        //Lista de tarefas que foi carregada pelo DB
        return project;
    }
    
   
}
