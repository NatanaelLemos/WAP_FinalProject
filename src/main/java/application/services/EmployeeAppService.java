package application.services;

import domain.data.repositories.EmployeeRepository;
import domain.entities.Address;
import domain.entities.Department;
import domain.entities.Employee;
import domain.entities.Position;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sadok on 07/02/2018.
 */
public class EmployeeAppService {

    private EmployeeRepository repo = new EmployeeRepository();

    PositionAppService posService = new PositionAppService();
    DepartmentAppService deptService = new DepartmentAppService();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public List<Employee> getEmployees(int from, int to,List<Employee> list) {
        if(list == null) {
            return repo.getAll().stream()
                    .skip(from)
                    .limit(to)
                    .collect(Collectors.toList());
        }else{
            return list.stream()
                    .skip(from)
                    .limit(to)
                    .collect(Collectors.toList());
        }
    }

    public List<Employee> getEmployeesByDept(int deptId){
        return repo.getAll().stream().filter(employee -> employee.getDepartment().getId() == deptId).collect(Collectors.toList());
    }

    public int count(List<Employee> list){
        if(list == null)
            return repo.getAll().size();
        else
            return list.size();
    }

    public Employee getEmployee(int id) {
        return repo.get(id);
    }


    public synchronized boolean create(String postionId, String departmentId, String isActive, String dateStart, String endDate, String managerId, String salary,
                          String name, String email, String homePhone, String cellPhone, Address home,Address mail,String birthday){
        Employee newEmployee = new Employee();
        Position p = posService.getPosition(Integer.parseInt(postionId));
        newEmployee.setPosition(p);
        Department d = deptService.getDepartment(Integer.parseInt(departmentId));
        newEmployee.setDepartment(d);
        if(isActive != null){
            newEmployee.setActive(true);
        }else
            newEmployee.setActive(false);

        Date hireDate = null;
        if(dateStart!=null) {
            try {
                hireDate = new Date();
                hireDate = formatter.parse(dateStart);
            } catch (ParseException e) {
                System.out.println("exception hire date");
                hireDate = null;
            }
        }

        newEmployee.setHireDate(hireDate);
        Date fireDate = null;
        if(endDate != null) {
            try {
                fireDate = new Date();
                fireDate = formatter.parse(endDate);
            } catch (ParseException e) {
                fireDate = null;
            }
        }
        newEmployee.setFireDate(fireDate);

        int mngId = Integer.parseInt(managerId);
        if(mngId!=0){
            Employee manager = getEmployee(mngId);
            newEmployee.setManager(manager);
        }
        newEmployee.setCurrentSalary(Double.parseDouble(salary));
        newEmployee.setName(name);
        newEmployee.setEmail(email);
        newEmployee.setPhone(homePhone);
        newEmployee.setCellPhone(cellPhone);

        newEmployee.setAddress(home);
        newEmployee.setMailAddress(mail);
        Date birthDate = null;
        if(birthday != null) {
            try {
                birthDate = new Date();
                birthDate = formatter.parse(birthday);
            } catch (ParseException e) {
                birthDate = null;
            }
        }
        newEmployee.setBirthdate(birthDate);

        repo.add(newEmployee);
        return true;
    }

    public boolean deleteEmployee(int empId){
        Employee e = repo.get(empId);
        // get list of all employee where e is a manager
        List<Employee> managedEmployee = repo.getAll().stream().filter(emp->emp.getManager()!= null && emp.getManager().getId() == e.getId()).collect(Collectors.toList());
        List<Employee> allEmployee = repo.getAll();

        for(Employee employee :allEmployee){
            if(managedEmployee.contains(employee)){
                employee.setManager(null);
            }
        }
        EmployeeRepository.listInstance = allEmployee;
        // delete current employee
        repo.delete(e);
        return true;
    }
}
