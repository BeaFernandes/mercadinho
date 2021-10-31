package br.edu.utfpr.mercadinho.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "SessionCookieController", value = "/sessao")
public class SessionCookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateString = sdf.format(calendar.getTime());

        Cookie cookieSession = new Cookie("sessionStart", dateString);
        response.addCookie(cookieSession);

        if(!cookieExists("firstSession", request)){
            Cookie firstSessionCookie = new Cookie("firstSession", dateString);
            firstSessionCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(firstSessionCookie);
        }

        response.sendRedirect("suas-compras");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
