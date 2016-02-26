package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class ProjectUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String userName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date created;
    @ManyToMany(mappedBy = "contributors")
    private List<Project> projects;

    public ProjectUser() {
        this.created = new Date();
    }

    public ProjectUser(String userName) {
        this.userName = userName;
        this.created = new Date();;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated() {
        return created;
    }

    public List<Project> getProjects() {
        return projects;
    }
    
    public void addProject(Project project) {
        this.projects.add(project);
    }


    
}
