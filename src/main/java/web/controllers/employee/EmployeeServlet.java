package web.controllers.employee;

import application.services.DepartmentAppService;
import application.services.EmployeeAppService;
import com.google.gson.Gson;
import domain.entities.Employee;
import web.viewmodels.DataTableResult;
import web.viewmodels.EmployeeViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sadok on 07/02/2018.
 */

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeAppService app = new EmployeeAppService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("deptId")!=null){
            req.setAttribute("deptId",req.getParameter("deptId"));
        }
        System.out.println("attr === "+req.getAttribute("deptId"));
        req.getRequestDispatcher("jsp/employee/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int from = Integer.parseInt(request.getParameter("start"));
        int to = Integer.parseInt(request.getParameter("length"));

        System.out.println("param === "+request.getParameter("deptId"));
        List<Employee> list = null;
        if(request.getParameter("deptId")!=null){
            list = new ArrayList<>();
            list = app.getEmployeesByDept(Integer.parseInt(request.getParameter("deptId")));
        }


        List<EmployeeViewModel> employees = app
                .getEmployees(from,to,list).stream()
                .map(EmployeeViewModel::fromModel)
                .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(
                new Gson().toJson(
                        DataTableResult.get(
                                employees,
                                app.count(list),
                                employees.size()
                        )
                )
        );
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete employee....");
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        app.deleteEmployee(employeeId);
    }
}
