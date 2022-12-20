package com.agropix.ada.service;

import com.agropix.ada.dto.ClienteRequest;
import com.agropix.ada.exceptions.ItemNotExistsException;
import com.agropix.ada.mapper.ClienteMapper;
import com.agropix.ada.model.Cliente;
import com.agropix.ada.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public Cliente save(ClienteRequest clienteRequest) {
        Cliente cliente = mapper.toModel(clienteRequest);
        repository.save(cliente);
        return cliente;
    }

    public Cliente findById(UUID contaId) {
        return repository.findById(contaId)
                .orElseThrow(() -> new ItemNotExistsException("Cliente não encontrado!"));
    }

    public Cliente update(UUID clienteId, ClienteRequest clienteRequest) {
        Cliente cliente = findById(clienteId);
        cliente = mapper.toModel(clienteRequest);
        cliente.setId(clienteId);
        repository.save(cliente);
        return cliente;
    }

    public void delete(UUID clienteId) {
        Cliente cliente = findById(clienteId);
        repository.delete(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

}
