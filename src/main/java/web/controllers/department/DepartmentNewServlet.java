package web.controllers.department;

import application.services.DepartmentAppService;
import domain.data.repositories.DepartmentRepository;
import domain.entities.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sadok on 07/02/2018.
 */

@WebServlet("/departments/new")
public class DepartmentNewServlet extends HttpServlet {

    DepartmentAppService app = new DepartmentAppService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/department/new.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        // name must be unique
        if(name != null){
            app.create(name);
        }
        resp.sendRedirect("/departments");
    }
}
