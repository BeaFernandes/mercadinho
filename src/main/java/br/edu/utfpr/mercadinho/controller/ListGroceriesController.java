package br.edu.utfpr.mercadinho.controller;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.service.GroceryService;
import jdk.nashorn.internal.ir.RuntimeNode;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        if(!cookieExists("sessionStart", request)){
            request.getRequestDispatcher("/sessao").forward(request, response);
        } else {
            request.setAttribute("groceries", groceries);
            request.setAttribute("sessionStart", getCookie("sessionStart", request).getValue());
            request.setAttribute("firstSession", getCookie("firstSession", request).getValue());
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        }
    }

    private Cookie getCookie(String name, HttpServletRequest request){
        Cookie myCookie = new Cookie("empty", "");
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)){
                    myCookie = cookie;
                }
            }
        }
        return myCookie;
    }

    private boolean cookieExists(String name, HttpServletRequest request){
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }
}