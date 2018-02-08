package web.controllers;

import application.services.ApplicationAppService;
import application.services.DepartmentAppService;
import application.services.EmployeeAppService;
import application.services.PositionAppService;
import domain.entities.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    DepartmentAppService deptService = new DepartmentAppService();
    EmployeeAppService empService = new EmployeeAppService();
    PositionAppService posService = new PositionAppService();
    ApplicationAppService applicantService = new ApplicationAppService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("deptNumber",deptService.count());
        request.setAttribute("empNumber",empService.count(null));
        int openPositionNumber = posService.getPositionByStatus(true).size();
        request.setAttribute("openPositionNumber",openPositionNumber);
        request.setAttribute("jobApplicantionNumber",applicantService.countAllApplications());
        request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
    }
}
