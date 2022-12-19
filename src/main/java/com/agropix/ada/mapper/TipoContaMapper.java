package com.agropix.ada.mapper;

import com.agropix.ada.dto.TipoContaRequest;
import com.agropix.ada.dto.TipoContaResponse;
import com.agropix.ada.model.TipoConta;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TipoContaMapper {

    TipoContaResponse toResponse(TipoConta tipoConta);
    TipoConta toModel(TipoContaRequest tipoContaRequest);
    List<TipoContaResponse> toTipoContaResponseList(List<TipoConta> listaTipoConta);

}
