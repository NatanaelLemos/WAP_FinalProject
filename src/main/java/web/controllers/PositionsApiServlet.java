package web.controllers;

import application.services.PositionAppService;
import com.google.gson.Gson;
import web.viewmodels.PositionViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/api/positions")
public class PositionsApiServlet extends HttpServlet {

    private PositionAppService app = new PositionAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int from = Integer.parseInt(request.getParameter("from"));
        int to = Integer.parseInt(request.getParameter("to"));

        List<PositionViewModel> positions = app
                .getPositions(from, to).stream()
                .map(PositionViewModel::fromModel)
                .collect(Collectors.toList());

        request.setAttribute("positions", new Gson().toJson(positions));
    }
}