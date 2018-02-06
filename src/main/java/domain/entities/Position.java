package domain.entities;

//import javax.persistence.*;
import java.util.List;

//@Entity
public class Position {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(length = 20)
    private String name;

//    @Column(length = 200)
    private String description;

    private Boolean isOpenPosition;

//    @OneToMany(
//            mappedBy = "position",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<Employee> employees;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOpenPosition() {
        return isOpenPosition;
    }

    public void setOpenPosition(Boolean openPosition) {
        isOpenPosition = openPosition;
    }
}
