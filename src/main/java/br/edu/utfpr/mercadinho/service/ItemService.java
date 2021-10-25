package br.edu.utfpr.mercadinho.service;

import br.edu.utfpr.mercadinho.model.dao.ItemDAO;
import br.edu.utfpr.mercadinho.model.domain.Item;

public class ItemService extends AbstractService<Long, Item> {
    public ItemService() {
        dao = new ItemDAO();
    }
}
