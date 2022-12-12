package com.agropix.ada.mapper;

import com.agropix.ada.dto.ContaRequest;
import com.agropix.ada.dto.ContaResponse;
import com.agropix.ada.model.Conta;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ContaMapper {

    // ToDo: Create Conta Mapper

    ContaResponse toResponse(Conta conta);
    Conta toModel(ContaRequest contaRequest);

}
