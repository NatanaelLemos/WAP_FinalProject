package domain.entities;

//import javax.persistence.*;
import java.util.List;

//@Entity
public class Department {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(length = 30)
    private String name;

//    @OneToMany(
//            mappedBy = "department",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(! (obj instanceof Department)){
            return false;
        }
        Department dep = (Department) obj;
        if(dep.getName().equals(this.getName())){
            return true;
        }else
            return false;
    }
}
