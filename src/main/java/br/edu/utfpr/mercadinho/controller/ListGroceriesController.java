package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.service.GroceryService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ListGroceriesController", value = "/suas-compras")
public class ListGroceriesController extends HttpServlet {

    GroceryService groceryService = new GroceryService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Grocery> groceries = groceryService.findAll();
        int counter = getServletContext().getAttribute("counter") == null ? 0 : (Integer) getServletContext().getAttribute("counter");
        getServletContext().setAttribute("counter", counter);

        request.setAttribute("groceries", groceries);

        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}