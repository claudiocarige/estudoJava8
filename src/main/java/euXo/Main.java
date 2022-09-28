
package euXo;

import controller.ProjectController;
import java.util.List;
import java.util.Set;
import model.Project;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class Main {

    public static void main(String[] args) {
        
        ProjectController projectControler = new ProjectController();
        
//        Project project = new Project();
//        project.setName("Projeto EuXô");
//        project.setDescription("Testando o aplicativo do projeto EuXô");
//        projectControler.saveProject(project);
        
//        Project project1 = new Project();
//        project1.setName("Projeto 2 de teste");
//        project1.setDescription("Testando de novo o aplicativo do projeto EuXô");
//        projectControler.saveProject(project1);
        
//          Project project = new Project();
//          project.setName("Projeto 6 de teste");
//          project.setDescription("Testionando");
//          projectControler.saveProject(project);
//          project.setName("Mudando Projeto EuXô");
//          projectControler.Update(project);
        
          List<Project> projectList = projectControler.getAll();
          System.out.println("Total de projetos: " + projectList);
    }	
}
    

