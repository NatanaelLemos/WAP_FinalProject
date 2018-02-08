package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.*;
import java.util.stream.Collectors;

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
        list.add(createFakeEmployee(2, true,"John",null,null,new Double(150.33),listOfDept.get(1),listOfPositions.get(1),null));
        list.add(createFakeEmployee(3, true,"Ninja",null,null,new Double(310),listOfDept.get(0),listOfPositions.get(2),null));
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

    @Override
    public Employee get(int id) {
        Optional<Employee> emp = listInstance.stream().filter(e -> e.getId() == id).findFirst();
        return emp.orElse(null);
    }

    @Override
    public void add(Employee employee) {
        Optional<Employee> emp = listInstance.stream().sorted(Comparator.comparing(Employee::getId).reversed()).findFirst();
        employee.setId((emp.isPresent() ? emp.get().getId() : 0) + 1);
        listInstance.add(employee);
    }

    @Override
    public void delete(Employee employee) {
        List<Employee> newListInstance = listInstance.stream().filter(e->(e.getId()!=employee.getId())).collect(Collectors.toList());
        listInstance = newListInstance;
    }
}
