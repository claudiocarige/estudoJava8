
package model;

import java.util.Date;


public class Task {
    
    private int id;
    private int idFkTask; //Chave Estrangeira
    private String name;
    private String description;
    private Boolean completed;
    private String comments;
    private Date deadline;
    private Date createdDate;
    private Date updatedDate;

    public Task( String name, String description, 
                Boolean completed, String comments, Date deadline, 
                Date createdDate, Date updatedDate) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.comments = comments;
        this.deadline = deadline;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
    /*Pode existir 2 Metodos construtor, mas o 2º não pode ter paramentro ou
      Ter paramentros diferentes do 1º construtor.
      Esse metodo quando for chamado vai criar o objeto na hora que for 
      Chamado setando a hora da chamada do metodo*/
    public Task(){
        this.completed = false;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFkTask() {
        return idFkTask;
    }

    public void setIdFkTask(int idFkTask) {
        this.idFkTask = idFkTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idFkTask=" 
                + idFkTask + ", name=" + name + ", description=" 
                + description + ", completed=" + completed + ", comments=" 
                + comments + ", deadline=" + deadline + ", createdDate=" 
                + createdDate + ", updatedDate=" + updatedDate + '}';
    }
    
    
    
    
}



