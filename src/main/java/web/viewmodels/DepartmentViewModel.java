package web.viewmodels;

import application.services.DepartmentAppService;
import domain.entities.Department;
import domain.entities.Employee;

import java.util.List;

/**
 * Created by sadok on 07/02/2018.
 */
public class DepartmentViewModel {

    private int id;
    private String name;
    private int employeeNumber;

    public static DepartmentViewModel fromModel(Department d) {
        DepartmentViewModel vm = new DepartmentViewModel();
        vm.setId(d.getId());
        vm.setName(d.getName());
        int numberOfEmployee = DepartmentAppService.countEmployeeByDepartment(d);
        vm.setEmployeeNumber(numberOfEmployee);
        return vm;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
