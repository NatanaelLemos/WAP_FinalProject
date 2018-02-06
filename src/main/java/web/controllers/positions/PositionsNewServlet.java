package web.controllers.positions;

import application.services.PositionAppService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/positions/new")
public class PositionsNewServlet extends HttpServlet {
    private PositionAppService app = new PositionAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/positions/new.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Boolean openPosition = request.getParameter("openPosition") != null && request.getParameter("openPosition").equals("true");

        app.create(name, description, openPosition);

        response.sendRedirect("/positions");
    }
}
