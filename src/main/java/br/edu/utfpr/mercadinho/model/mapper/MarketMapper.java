package br.edu.utfpr.mercadinho.model.mapper;

import br.edu.utfpr.mercadinho.model.domain.Market;
import br.edu.utfpr.mercadinho.model.dto.MarketDTO;

public class MarketMapper {

    public static Market toEntity(MarketDTO dto) {
        Market entity = new Market(dto.getName());
        return entity;
    }

    public static MarketDTO toDTO(Market entity) {
        MarketDTO dto = new MarketDTO(entity.getName());
        return dto;
    }
}
