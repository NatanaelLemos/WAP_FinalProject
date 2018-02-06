package domain.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewed_employee_id")
    private Employee reviewedEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewed_by_id")
    private Employee reviewedBy;

    private Date date;

    @Column(length=500)
    private String comments;

    @Column(length=500)
    private String recommendations;
}
