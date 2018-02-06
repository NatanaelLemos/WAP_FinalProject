package domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String name;

    @Column(length = 200)
    private String description;

    private Boolean isOpenPosition;

    @OneToMany(
            mappedBy = "position",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees;
}
