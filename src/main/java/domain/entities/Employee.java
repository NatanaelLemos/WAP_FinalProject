package domain.entities;

//import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
public class Employee extends Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean active;
    private Date hireDate;
    private Date fireDate;
    private Double currentSalary;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id")
    private Department department;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "position_id")
    private Position position;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "manager_id")
    private Employee manager;

//    @OneToMany(
//            mappedBy = "manager",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<Employee> managedEmployees;

//    @OneToMany(
//            mappedBy = "reviewedEmployee",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<PerformanceReview> reviews;

//    @OneToMany(
//            mappedBy = "reviewedBy",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<PerformanceReview> reviewed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    public Double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(List<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public List<PerformanceReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<PerformanceReview> reviews) {
        this.reviews = reviews;
    }

    public List<PerformanceReview> getReviewed() {
        return reviewed;
    }

    public void setReviewed(List<PerformanceReview> reviewed) {
        this.reviewed = reviewed;
    }
}