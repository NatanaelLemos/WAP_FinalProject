package web.controllers;

import application.services.LoginAppService;
import web.viewmodels.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginAppService app = new LoginAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String remember = req.getParameter("remember");
        if(remember!=null && remember.equals("on")){
            Cookie cookie = new Cookie("email",req.getParameter("email"));
            cookie.setMaxAge(3600*30);
            resp.addCookie(cookie);
        }else{
            for (Cookie cookie : req.getCookies()) {
                if(cookie.getName().equals("email")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }

        String email =req.getParameter("email");

        if(app.getOfficerByEmail(email) != null) {
            session.setAttribute("userId",app.getOfficerByEmail(email).getId());
            session.setAttribute("role", UserRole.HR_OFFICER);
        }else if (app.getEmployeeByEmail(email) != null){
            session.setAttribute("userId",app.getEmployeeByEmail(email).getId());
            session.setAttribute("role", UserRole.EMPLOYEE);
        }else if(app.getApplicantByEmail(email) != null) {
            session.setAttribute("userId",app.getApplicantByEmail(email).getId());
            session.setAttribute("role", UserRole.JOB_APPLICANT);
        }else {
            resp.sendRedirect("/login");
            return;
        }

        resp.sendRedirect("/home");
    }
}
