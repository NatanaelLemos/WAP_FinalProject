package web.controllers.application;

import application.services.ApplicationAppService;
import com.google.gson.Gson;
import domain.entities.ApplicationStatus;
import web.viewmodels.ApplicationStatusViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/application/new")
public class ApplicationNewServlet extends HttpServlet {
    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int positionId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        ApplicationStatus status = app.getApplicationStatus(positionId, userId);

        out.print(new Gson().toJson(ApplicationStatusViewModel.fromModel(status)));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int positionId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        app.apply(positionId, userId);
    }
}
