package com.agropix.ada.mapper;

import com.agropix.ada.dto.ClienteRequest;
import com.agropix.ada.dto.ClienteResponse;
import com.agropix.ada.model.Cliente;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ClienteMapper {

    ClienteResponse toResponse(Cliente cliente);
    Cliente toModel(ClienteRequest clienteRequest);
    List<ClienteResponse> toResponseList(List<Cliente> listaClientes);

}
