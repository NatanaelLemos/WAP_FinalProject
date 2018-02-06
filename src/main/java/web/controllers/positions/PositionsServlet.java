package web.controllers.positions;

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

@WebServlet("/positions")
public class PositionsServlet extends HttpServlet {

    private PositionAppService app = new PositionAppService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/positions/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int from = Integer.parseInt(request.getParameter("start"));
        int to = Integer.parseInt(request.getParameter("length"));

        List<PositionViewModel> positions = app
                .getPositions(from, to).stream()
                .map(PositionViewModel::fromModel)
                .collect(Collectors.toList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(
                new Gson().toJson(
                        DataTableResult.get(
                                positions,
                                app.count(),
                                positions.size()
                        )
                )
        );
        out.flush();
    }
}