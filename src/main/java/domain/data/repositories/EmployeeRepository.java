package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository extends RepositoryBase<Employee> implements IRepository<Employee> {

    public static List<Employee> listInstance;


    public EmployeeRepository() {
        super(Employee.class);
        if(listInstance == null){
            listInstance = createFakeList();
        }
    }

    private List<Employee> createFakeList() {
        List<Employee> list = new ArrayList<>();
        List<Department> listOfDept = DepartmentRepository.listInstance;
        List<Position> listOfPositions = PositionRepository.listInstance;
        list.add(createFakeEmployee(1, true,"Christopher",null,null,new Double(120),listOfDept.get(0),listOfPositions.get(0),null));
        list.add(createFakeEmployee(1, true,"John",null,null,new Double(150.33),listOfDept.get(1),listOfPositions.get(1),null));
        list.add(createFakeEmployee(1, true,"Ninja",null,null,new Double(310),listOfDept.get(0),listOfPositions.get(2),null));
        return list;
    }

    private Employee createFakeEmployee(int id, boolean active,String name, Date hireDate, Date fireDate, Double currentSalary,
                                        Department department, Position position, Employee manager) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setHireDate(hireDate);
        employee.setFireDate(fireDate);
        employee.setCurrentSalary(currentSalary);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setManager(manager);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(listInstance);
    }
}
