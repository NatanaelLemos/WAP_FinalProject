package web.controllers.applicant;

import application.services.ApplicationAppService;
import domain.entities.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/applicants/register")
public class ApplicantsRegisterServlet extends HttpServlet {
    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/applicants/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date birthdate = new Date();

        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            birthdate = format.parse(request.getParameter("birthdate"));
        } catch (Exception e) {
        }

        Applicant a = app.createApplicant(
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("phone"),
                birthdate
        );

        response.sendRedirect("/applicants/address?id=" + String.valueOf(a.getId()));
    }
}
