package domain.entities;

//import javax.persistence.*;
//
//@Entity
public class ApplicationStatus {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(length = 20)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ApplicationStatus pending() {
        ApplicationStatus status = new ApplicationStatus();
        status.setId(1);
        status.setName("Pending");
        return status;
    }

    public static ApplicationStatus interviewed() {
        ApplicationStatus status = new ApplicationStatus();
        status.setId(2);
        status.setName("Interviewed");
        return status;
    }

    public static ApplicationStatus rejected() {
        ApplicationStatus status = new ApplicationStatus();
        status.setId(3);
        status.setName("Rejected");
        return status;
    }

    public static ApplicationStatus accepted() {
        ApplicationStatus status = new ApplicationStatus();
        status.setId(4);
        status.setName("Accepted");
        return status;
    }
}
