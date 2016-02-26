package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String description;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date created;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    
    @ManyToMany
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProjectUser> contributors;
    
    @JoinColumn(name = "PROJECT_ID")
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> tasks;

    public Project() {
        this.created = new Date();
    }
    
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public List<ProjectUser> getContributors() {
        return contributors;
    }
    
    public void addContributor(ProjectUser projectUser) {
        this.contributors.add(projectUser);
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println(this.tasks.size() + "nu");
    }
    
}
