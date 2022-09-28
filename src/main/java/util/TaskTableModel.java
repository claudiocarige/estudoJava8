
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;


public class TaskTableModel extends AbstractTableModel{
    
    String[] columns = {"Nome", "Descri��o", "Prazo", "Tarefa Conclu�da", 
                        "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
    // 3 m�todos obrigat�rios da classe Abstract.
    @Override
    public int getRowCount() {
        //Informa quantas tarefas existem
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        //Informa quantas colunas existem
        return columns.length;
    }
    
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        // Informa quel tipo de dado existe na coluna
        if (tasks.isEmpty()){ //Verifica se a lista est� vazia
            return Object.class;
        }
        // Retorna a classe do dado da linha 0 da coluna x, retornando o tipo de dado da coluna
        return this.getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Qual valor deve ser exibido em cada linha ou coluna
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).getCompleted();        
            case 4: return "";
            case 5: return "";
            default:
                return "Dado n�o encontrado";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

        
    
}
