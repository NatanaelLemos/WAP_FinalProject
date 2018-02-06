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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getCoverLetterUrl() {
        return coverLetterUrl;
    }

    public void setCoverLetterUrl(String coverLetterUrl) {
        this.coverLetterUrl = coverLetterUrl;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public Boolean getHired() {
        return hired;
    }

    public void setHired(Boolean hired) {
        this.hired = hired;
    }
}
