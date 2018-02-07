package web.controllers.positions;

import application.services.PositionAppService;
import domain.entities.Position;
import web.viewmodels.PositionViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/positions/edit")
public class PositionsEditServlet extends HttpServlet {
    private PositionAppService app = new PositionAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("id"));
        Position  p = app.getPosition(id);
        request.setAttribute("position", PositionViewModel.fromModel(p));
        request.getRequestDispatcher("/jsp/positions/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Boolean openPosition = request.getParameter("openPosition") != null && request.getParameter("openPosition").equals("true");

        app.edit(id, name, description, openPosition);
        response.sendRedirect("/positions");
    }
}
