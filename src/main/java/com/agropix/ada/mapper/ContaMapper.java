package com.agropix.ada.mapper;

import com.agropix.ada.dto.ContaRequest;
import com.agropix.ada.dto.ContaResponse;
import com.agropix.ada.model.Conta;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ContaMapper {

    ContaResponse toResponse(Conta conta);
    Conta toModel(ContaRequest contaRequest);
    List<ContaResponse> toResponseList(List<Conta> listaContas);

}
