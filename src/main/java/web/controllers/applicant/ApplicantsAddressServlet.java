package web.controllers.applicant;

import application.services.ApplicationAppService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/applicants/address")
public class ApplicantsAddressServlet extends HttpServlet {
    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("/jsp/applicants/address.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String street1 = request.getParameter("streetAddress1");
        String street2 = request.getParameter("streetAddress2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        app.createAddress(id, street1, street2, city, state, zip);

        response.sendRedirect("/login");
    }
}
