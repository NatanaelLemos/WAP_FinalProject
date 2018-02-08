package web.controllers.department;

import application.services.DepartmentAppService;
import domain.entities.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/departments/edit")
public class DepartmentEditServlet extends HttpServlet {

    DepartmentAppService app = new DepartmentAppService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        Department d = app.getDepartment(deptId);
        String name = d.getName();
        req.setAttribute("name",name);
        req.setAttribute("deptId",deptId);
        req.getRequestDispatcher("/jsp/department/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        String newName = req.getParameter("name");
        Department d = app.getDepartment(deptId);
        d.setName(newName);
        resp.sendRedirect("/departments");
    }
}
