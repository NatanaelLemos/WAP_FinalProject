package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class DepartmentRepository extends RepositoryBase<Department> implements IRepository<Department> {

    public static List<Department> listInstance;

    public DepartmentRepository() {
        super(Department.class);
        System.out.println("listInstance )=====>"+listInstance);
        if(listInstance == null){

            listInstance = createFakeList();
        }
    }

    private List<Department> createFakeList(){
        List<Department> list = new ArrayList<>();
        list.add(createFakeDepartment(1, "Execution"));
        list.add(createFakeDepartment(2, "Web Department"));
        list.add(createFakeDepartment(3, "Mobile Department"));
        return list;
    }

    private Department createFakeDepartment(int id, String name) {
        Department dep = new Department();
        dep.setId(id);
        dep.setName(name);
        return dep;
    }

    @Override
    public List<Department> getAll() {
        return new ArrayList<>(listInstance);
    }

    @Override
    public void add(Department department) {
        Optional<Department> dep = listInstance.stream().sorted(Comparator.comparing(Department::getId).reversed()).findFirst();
        department.setId((dep.isPresent() ? dep.get().getId() : 0) + 1);
        listInstance.add(department);
    }
}
