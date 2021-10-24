package br.edu.utfpr.mercadinho.service;

import br.edu.utfpr.mercadinho.model.dao.MarketDAO;
import br.edu.utfpr.mercadinho.model.domain.Market;

public class MarketService extends AbstractService<Long, Market> {
    public MarketService() {
        dao = new MarketDAO();
    }
}
