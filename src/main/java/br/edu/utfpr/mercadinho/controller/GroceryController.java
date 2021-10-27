package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.model.domain.Item;
import br.edu.utfpr.mercadinho.service.GroceryService;
import br.edu.utfpr.mercadinho.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroceryController", value = "/sua-compra")
public class GroceryController extends HttpServlet {

    GroceryService groceryService = new GroceryService();
    ItemService itemService = new ItemService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        Grocery grocery = groceryService.getById(id);
        List<Item> items = itemService.listByForeignOrObjectProperty("grocery", grocery);

        request.setAttribute("total", grocery.getFormatedTotal());
        request.setAttribute("market", grocery.getMarket());
        request.setAttribute("date", grocery.getFormatedDate());
        request.setAttribute("items", items);

        //response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/view/grocery.jsp").forward(request, response);
    }

    public void destroy() {
    }
}