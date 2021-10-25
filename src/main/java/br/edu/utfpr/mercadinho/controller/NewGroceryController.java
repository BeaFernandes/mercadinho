package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.model.domain.Item;
import br.edu.utfpr.mercadinho.model.domain.Market;
import br.edu.utfpr.mercadinho.model.dto.GroceryDTO;
import br.edu.utfpr.mercadinho.model.mapper.GroceryMapper;
import br.edu.utfpr.mercadinho.service.GroceryService;
import br.edu.utfpr.mercadinho.service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewGroceryController", value = "/nova-compra")
public class NewGroceryController extends HttpServlet {

    GroceryService groceryService = new GroceryService();
    ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/view/new-grocery.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String market = request.getParameter("market");
        getServletContext().setAttribute("market", market);
        List<Item> items = (List<Item>) request.getSession().getAttribute("items");
        int total = request.getSession().getAttribute("total") == null ? 0 : (Integer) request.getSession().getAttribute("total");


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = sdf.format(calendar.getTime());

        //if(items == null){
        //    String message = "Você precisa adicionar pelo menos um item.";
        //    request.setAttribute("flash.message", message);
        //    response.sendRedirect("nova-compra");
        //}

        Grocery grocery = new Grocery(total, date, market, items);

        groceryService.save(grocery);
        for (Item item : items) {
            item.setGrocery(grocery);
            itemService.save(item);
        }

        request.getSession().removeAttribute("items");
        request.getSession().removeAttribute("total");

        response.sendRedirect("suas-compras");
    }
}
