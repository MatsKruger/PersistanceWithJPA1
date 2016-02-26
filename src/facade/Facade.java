package facade;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class Facade {
    
    EntityManagerFactory emf;
    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    public void createUser(ProjectUser projectUser) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(projectUser);
            em.getTransaction().commit();
        } finally { 
            em.close(); 
        }
    }
    public ProjectUser findUser(int i) {
        EntityManager em = getEntityManager();
        
        ProjectUser projectUser = em.find(ProjectUser.class, i);
        
        return projectUser;
    }
    
    public List<ProjectUser> findAllUsers() {
        EntityManager em = getEntityManager();
        TypedQuery query = em.createQuery("SELECT e FROM ProjectUser e", ProjectUser.class);
        return (List<ProjectUser>) query.getResultList();
    }
    
    public void createProject(Project project) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } finally { 
            em.close(); 
        }
    }
    public void addUserToProject(ProjectUser projectUser, Project project) {
        EntityManager em = getEntityManager();
        project.addContributor(projectUser);
        try {
            em.getTransaction().begin();
            em.merge(project);
            em.getTransaction().commit();
        } finally { 
            em.close(); 
        }
    }
    public Project findProject(int i) {
        EntityManager em = getEntityManager();
        
        Project project = em.find(Project.class, i);
        
        return project;
    }
    public void createTaskAndAddToProject(Task task, Project project) {
        EntityManager em = getEntityManager();
        
        project.addTask(task);
        
        try {
            em.getTransaction().begin();
            em.merge(project);
            em.getTransaction().commit();
        } finally { 
            em.close(); 
        }
    }
    
    protected EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}
