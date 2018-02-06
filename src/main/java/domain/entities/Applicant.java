package domain.entities;

//import javax.persistence.  *;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Applicant extends Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(
//            mappedBy = "applicant",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<JobApplication> application;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<JobApplication> getApplication() {
        return application;
    }

    public void setApplication(List<JobApplication> application) {
        this.application = application;
    }

    public Applicant(){
        application = new ArrayList<>();
    }
}
