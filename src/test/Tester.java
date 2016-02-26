package test;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        Facade facade = new Facade(emf);
        
        Project project1 = new Project(); 
        ProjectUser user1 = new ProjectUser();
        Task task1 = new Task();
        
        facade.createProject(project1);
        facade.createUser(user1);
        facade.addUserToProject(user1, project1);
        facade.createTaskAndAddToProject(task1, project1);
        
        Project projectFound1 = facade.findProject(1);
        ProjectUser userFound1 = facade.findUser(1);
               
        System.out.println("Project found id: " + projectFound1.getId());        
        System.out.println("User found id: " + userFound1.getId());
        System.out.println("Users in Project " + projectFound1.getId() + ": ");
        
        for (ProjectUser contributor : projectFound1.getContributors()) {
            System.out.println("    User id: " + contributor.getId());      
        }
        System.out.println("Tasks in Project " + projectFound1.getId() + ": ");
        
        for (Task task : projectFound1.getTasks()) {
            System.out.println("    Task id: " + task.getId());      
        }
    }
}
