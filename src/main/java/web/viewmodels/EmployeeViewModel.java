package web.viewmodels;

import domain.entities.Employee;

/**
 * Created by sadok on 07/02/2018.
 */
public class EmployeeViewModel {

    private int id;
    private String name;
    private String positionName;
    private String departmentName;
    private String managerName;
    private double salary;

    public static EmployeeViewModel fromModel(Employee emp) {
        EmployeeViewModel vm = new EmployeeViewModel();
        vm.setId(emp.getId());
        vm.setName(emp.getName());
        vm.setDepartmentName(emp.getDepartment().getName());
        vm.setPositionName(emp.getPosition().getName());
        String managerName =  (emp.getManager() != null) ? emp.getManager().getName() : "";
        vm.setManagerName(managerName);
        vm.setSalary(emp.getCurrentSalary());
        return vm;
    }
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
