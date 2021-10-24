package br.edu.utfpr.mercadinho.service;

import br.edu.utfpr.mercadinho.model.dao.GroceryDAO;
import br.edu.utfpr.mercadinho.model.domain.Grocery;

public class GroceryService extends AbstractService<Long, Grocery> {
    public GroceryService() {
        dao = new GroceryDAO();
    }
}
