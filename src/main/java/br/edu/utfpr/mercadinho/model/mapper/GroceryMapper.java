package br.edu.utfpr.mercadinho.model.mapper;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import br.edu.utfpr.mercadinho.model.dto.GroceryDTO;

public class GroceryMapper {
    public static Grocery toEntity(GroceryDTO dto) {
        Grocery entity = new Grocery(dto.getTotal(), dto.getDate(), dto.getMarket());
        return entity;
    }

    public static GroceryDTO toDTO(Grocery entity) {
        GroceryDTO dto = new GroceryDTO(entity.getId(), entity.getTotal(), entity.getDate(), entity.getMarket());
        return dto;
    }
}
