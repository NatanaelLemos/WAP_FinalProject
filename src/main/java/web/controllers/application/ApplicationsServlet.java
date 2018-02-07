package web.controllers.application;

import application.services.ApplicationAppService;
import application.services.PositionAppService;
import com.google.gson.Gson;
import domain.entities.JobApplication;
import domain.entities.Position;
import web.viewmodels.DataTableResult;
import web.viewmodels.JobApplicationViewModel;
import web.viewmodels.PositionViewModel;
import web.viewmodels.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/applications")
public class ApplicationsServlet extends HttpServlet {
    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/application/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int from = Integer.parseInt(request.getParameter("start"));
        int to = Integer.parseInt(request.getParameter("length"));

        List<JobApplication> applications = null;
        UserRole userRole = (UserRole)request.getSession().getAttribute("role");
        int total = 0;

        if(userRole == UserRole.JOB_APPLICANT){
            int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
            applications = app.getApplicantApplications(userId, from, to);
            total = app.countApplicantApplications(userId);
        } else{
            applications = app.getApplications(from, to);
            total = app.countAllApplications();
        }

        List<JobApplicationViewModel> vms = applications.stream()
                                            .map(JobApplicationViewModel::fromModel)
                                            .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(
                new Gson().toJson(
                        DataTableResult.get(vms, total, vms.size())
                )
        );
        out.flush();
    }
}