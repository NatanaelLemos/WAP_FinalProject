package domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean active;
    private Date hireDate;
    private Date fireDate;
    private Double currentSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(
            mappedBy = "manager",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> managedEmployees;

    @OneToMany(
            mappedBy = "reviewedEmployee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PerformanceReview> reviews;

    @OneToMany(
            mappedBy = "reviewedBy",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PerformanceReview> reviewed;
}