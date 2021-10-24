package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Market;
import br.edu.utfpr.mercadinho.model.dto.MarketDTO;
import br.edu.utfpr.mercadinho.model.mapper.MarketMapper;
import br.edu.utfpr.mercadinho.service.MarketService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MarketController", value = "/mercados")
public class MarketController extends HttpServlet {

    MarketService marketService = new MarketService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Market> markets = marketService.findAll();
        List<MarketDTO> marketDTOS = new ArrayList<>();

        for (Market market : markets) {
            marketDTOS.add(MarketMapper.toDTO(market));
        }

        String json = new Gson().toJson(marketDTOS);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
