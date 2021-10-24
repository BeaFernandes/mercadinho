package br.edu.utfpr.mercadinho.model.mapper;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.model.dto.GroceryDTO;

public class GroceryMapper {
    public static Grocery toEntity(GroceryDTO dto) {
        Grocery entity = new Grocery(dto.getProduct(), dto.getPrice(), dto.getAmount(), dto.getTotalPerItem(), dto.getTotal(), dto.getMarket());
        return entity;
    }

    public static GroceryDTO toDTO(Grocery entity) {
        GroceryDTO dto = new GroceryDTO(entity.getProduct(), entity.getPrice(), entity.getAmount(), entity.getTotalPerItem(), entity.getTotal(), entity.getMarket());
        return dto;
    }
}
