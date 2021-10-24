package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Market;
import br.edu.utfpr.mercadinho.model.dto.MarketDTO;
import br.edu.utfpr.mercadinho.model.mapper.MarketMapper;
import br.edu.utfpr.mercadinho.service.MarketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewMarketController", value = "/cadastrar-mercado")
public class NewMarketController extends HttpServlet {

    MarketService marketService = new MarketService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/view/new-market.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Market market = new Market(name);

        marketService.save(market);

        //request.getRequestDispatcher("/WEB-INF/view/new-grocery.jsp").forward(request, response);
        response.sendRedirect("nova-compra");
    }
}
