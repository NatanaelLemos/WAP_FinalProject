package application.services;

import domain.data.repositories.DepartmentRepository;
import domain.data.repositories.EmployeeRepository;
import domain.entities.Department;
import domain.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DepartmentAppService {

    private DepartmentRepository repo = new DepartmentRepository();

    public List<Department> getDepartments(int from, int to) {
        return repo.getAll().stream()
                .skip(from)
                .limit(to)
                .collect(Collectors.toList());
    }

    public int count(){
        return repo.getAll().size();
    }

    public static List<Employee> getEmployeesByDepartment(Department d){
        List<Employee> list = new ArrayList<>();
        list = EmployeeRepository.listInstance.stream().filter(employee -> employee.getDepartment().getId()== d.getId()).collect(Collectors.toList());
        return list;
    }

    public static int countEmployeeByDepartment(Department d){
        return (int) EmployeeRepository.listInstance.stream().filter(employee -> employee.getDepartment().getId()== d.getId()).count();
    }

    public synchronized boolean create(String name){
        Department d = new Department();
        d.setName(name);
        if(repo.getAll().contains(d)){
            System.out.println("department already exist");
            return false;
        }else{
            repo.add(d);
            System.out.println("department created successfully");
            return true;
        }
    }

    public boolean deleteDepartment(int deptId){
        Department department = getDepartment(deptId);
        System.out.println("department to delete === "+department.getName());
        repo.delete(department);
        return true;
    }

    public Department getDepartment(int id) {
        return repo.get(id);
    }
}
