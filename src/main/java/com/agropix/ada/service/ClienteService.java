package com.agropix.ada.service;

import com.agropix.ada.dto.ClienteRequest;
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

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public Cliente save(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.toModel(clienteRequest);
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(UUID id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid id"));
    }

    public Cliente update(UUID uuid, ClienteRequest clienteRequest) {
        Cliente cliente = findById(uuid);
        cliente = clienteMapper.toModel(clienteRequest);
        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(UUID id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

}
