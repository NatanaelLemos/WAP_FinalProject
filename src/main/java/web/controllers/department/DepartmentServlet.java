package web.controllers.department;

import application.services.DepartmentAppService;
import com.google.gson.Gson;
import web.viewmodels.DataTableResult;
import web.viewmodels.DepartmentViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sadok on 06/02/2018.
 */

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {

    private DepartmentAppService app = new DepartmentAppService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/department/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int from = Integer.parseInt(request.getParameter("start"));
        int to = Integer.parseInt(request.getParameter("length"));

        List<DepartmentViewModel> departments = app
                .getDepartments(from, to).stream()
                .map(DepartmentViewModel::fromModel)
                .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(
                new Gson().toJson(
                        DataTableResult.get(
                                departments,
                                app.count(),
                                departments.size()
                        )
                )
        );
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete department....");
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        app.deleteDepartment(deptId);
    }
}
