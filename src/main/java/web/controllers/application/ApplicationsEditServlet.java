package web.controllers.application;

import application.services.ApplicationAppService;
import com.google.gson.Gson;
import domain.entities.JobApplication;
import web.viewmodels.DataTableResult;
import web.viewmodels.JobApplicationViewModel;
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

@WebServlet("/applications/edit")
public class ApplicationsEditServlet extends HttpServlet {
    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        switch (status) {
            case "interviewed":
                app.setInterviewed(id);
                break;
            case "rejected":
                app.setRejected(id);
                break;
            case "accepted":
                app.setAccepted(id);
                break;
        }
    }
}