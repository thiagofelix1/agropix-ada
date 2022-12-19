package com.agropix.ada.mapper;

import com.agropix.ada.dto.ChavePixRequest;
import com.agropix.ada.dto.ChavePixResponse;
import com.agropix.ada.model.ChavePix;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ChavePixMapper {

    ChavePixResponse toResponse(ChavePix chavePix);
    ChavePix toModel(ChavePixRequest chavePixRequest);
    List<ChavePixResponse> toResponseList(List<ChavePix> chavePixList);

}
