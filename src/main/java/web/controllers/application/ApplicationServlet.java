package web.controllers.application;

import application.services.ApplicationAppService;
import application.services.PositionAppService;
import com.google.gson.Gson;
import web.viewmodels.DataTableResult;
import web.viewmodels.PositionViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {

    private ApplicationAppService app = new ApplicationAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/application/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int from = Integer.parseInt(request.getParameter("start"));
        int to = Integer.parseInt(request.getParameter("length"));

        List<PositionViewModel> positions = app
                .getOpenPositions(from, to).stream()
                .map(PositionViewModel::fromModel)
                .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(
                new Gson().toJson(
                        DataTableResult.get(
                                positions,
                                app.countOpenPositions(),
                                positions.size()
                        )
                )
        );
        out.flush();
    }
}