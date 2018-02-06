package domain.entities;

//import javax.persistence.*;
//
//@Entity
public class JobApplication {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "position_id")
    private Position position;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "status_id")
    private ApplicationStatus status;

    private String coverLetterUrl;
    private String resumeUrl;

    private Boolean hired;
}
