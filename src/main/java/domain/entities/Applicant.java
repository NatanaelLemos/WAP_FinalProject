package domain.entities;

//import javax.persistence.  *;
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
}
