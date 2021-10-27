package br.edu.utfpr.mercadinho.service;

import br.edu.utfpr.mercadinho.model.dao.GroceryDAO;
import br.edu.utfpr.mercadinho.model.domain.Grocery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GroceryService extends AbstractService<Long, Grocery> {
    public GroceryService() {
        dao = new GroceryDAO();
    }

    public Date getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateString = sdf.format(calendar.getTime());
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
