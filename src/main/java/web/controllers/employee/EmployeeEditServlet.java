package web.controllers.employee;

import application.services.EmployeeAppService;
import domain.data.repositories.DepartmentRepository;
import domain.data.repositories.EmployeeRepository;
import domain.data.repositories.PositionRepository;
import domain.entities.Address;
import domain.entities.Department;
import domain.entities.Employee;
import domain.entities.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/employees/edit")
public class EmployeeEditServlet extends HttpServlet {

    EmployeeAppService app = new EmployeeAppService();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        Employee employee = app.getEmployee(employeeId);
        System.out.println("hire date === "+employee.getHireDate());
        req.setAttribute("employeeInstance",employee);
        // get list of positions
        List<Position> positions = PositionRepository.listInstance;
        req.setAttribute("positions",positions);
        // get list of employees
        List<Employee> employees = EmployeeRepository.listInstance;
        // remove selected employee from the list
        employees = employees.stream().filter(emp->emp.getId()!=employeeId).collect(Collectors.toList());
        req.setAttribute("employees",employees);
        // get list of departments
        List<Department> departments = DepartmentRepository.listInstance;

        req.setAttribute("departments",departments);
        req.setAttribute("formatter",formatter);
        req.getRequestDispatcher("/jsp/employee/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        app.deleteEmployee(employeeId);
        String postionId = req.getParameter("postionId");
        String departmentId = req.getParameter("departmentId");
        String isActive = req.getParameter("isActive");
        String dateStart = req.getParameter("dateStart");
        String dateEnd = req.getParameter("dateEnd");
        String managerId = req.getParameter("managerId");
        String salary = req.getParameter("salary");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String homePhone = req.getParameter("homePhone");
        String cellPhone = req.getParameter("cellPhone");
        String stateHome = req.getParameter("stateHome");
        String cityHome = req.getParameter("cityHome");
        String zipHome = req.getParameter("zipHome");
        String streetHome = req.getParameter("streetHome");
        String stateMail = req.getParameter("stateMail");
        Address homeAddress = new Address(stateHome, cityHome,zipHome,streetHome);
        String cityMail = req.getParameter("cityMail");
        String zipMail = req.getParameter("zipMail");
        String streetMail = req.getParameter("streetMail");
        Address mailAddress = new Address(stateMail, cityMail,zipMail,streetMail);
        String dateBirth = req.getParameter("dateBirth");

        System.out.println("dateStart === "+dateStart);

        app.create(postionId,departmentId,isActive,dateStart,dateEnd,managerId,salary,name,email,homePhone,cellPhone,homeAddress,mailAddress,dateBirth);

        resp.sendRedirect("/employees");

    }
}
