
package model;

import java.util.Date;


public class Task {
    
    private int id;
    private int idFkTask; //Chave Estrangeira
    private String product;
    private String address;
    private Boolean completed;
    private String contact;
    private Date deadline;
    private Date createdDate;
    private Date updatedDate;

    public Task( String product, String address, 
                Boolean completed, String contact, Date deadline, 
                Date createdDate, Date updatedDate) {
        this.product = product;
        this.address = address;
        this.completed = completed;
        this.contact = contact;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
                + idFkTask + ", Product=" + product + ", address=" 
                + address + ", completed=" + completed + ", contact=" 
                + contact + ", deadline=" + deadline + ", createdDate=" 
                + createdDate + ", updatedDate=" + updatedDate + '}';
    }
    
    
    
    
}



