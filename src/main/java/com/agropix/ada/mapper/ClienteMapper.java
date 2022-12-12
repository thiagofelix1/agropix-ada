package com.agropix.ada.mapper;

import com.agropix.ada.dto.ClienteRequest;
import com.agropix.ada.model.Cliente;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteMapper {

    public Cliente toModel(ClienteRequest clienteRequest);
}
