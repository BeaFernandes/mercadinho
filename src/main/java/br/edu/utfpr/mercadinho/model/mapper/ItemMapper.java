package br.edu.utfpr.mercadinho.model.mapper;

import br.edu.utfpr.mercadinho.model.domain.Item;
import br.edu.utfpr.mercadinho.model.dto.ItemDTO;

public class ItemMapper {
    public static Item toEntity(ItemDTO dto) {
        Item entity = new Item(dto.getName(), dto.getPrice(), dto.getAmount(), dto.getTotal(), dto.getGrocery());
        return entity;
    }

    public static ItemDTO toDTO(Item entity) {
        ItemDTO dto = new ItemDTO(entity.getId(), entity.getName(), entity.getPrice(), entity.getAmount(), entity.getTotal(), entity.getGrocery());
        return dto;
    }
}
