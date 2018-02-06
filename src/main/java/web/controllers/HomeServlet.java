package web.controllers;

import domain.data.repositories.AddressRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: this should be removed .
        AddressRepository r = new AddressRepository();
        r.getAll();

        request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
    }
}
