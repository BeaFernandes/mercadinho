package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.model.domain.Item;
import br.edu.utfpr.mercadinho.model.domain.Market;
import br.edu.utfpr.mercadinho.model.dto.ItemDTO;
import br.edu.utfpr.mercadinho.model.mapper.ItemMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddItemController", value = "/adicionar-item")
public class AddItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        String amountString = request.getParameter("amount");
        String totalString = request.getParameter("total_per_item");
        Integer amount = Integer.parseInt(amountString);
        float price = Float.valueOf(priceString).floatValue();
        float totalPerItem = Float.valueOf(totalString).floatValue();


        List<Item> items = (List<Item>) request.getSession().getAttribute("items");
        if(items == null){
            items = new ArrayList<Item>();
        }

        int total = request.getSession().getAttribute("total") == null ? 0 : (Integer) request.getSession().getAttribute("total");

        Item item = new Item(name, price, amount, totalPerItem);
        items.add(item);
        total += item.getTotal();

        request.getSession().setAttribute("items", items);
        request.getSession().setAttribute("total", total);
        response.sendRedirect("nova-compra");
    }
}
