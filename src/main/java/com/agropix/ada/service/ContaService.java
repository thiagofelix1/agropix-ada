package com.agropix.ada.service;


import com.agropix.ada.dto.ContaRequest;
import com.agropix.ada.dto.ContaResponse;
import com.agropix.ada.mapper.ContaMapper;
import com.agropix.ada.model.Conta;
import com.agropix.ada.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;
    private  final ContaMapper mapper;

    // ToDo: Create Conta Service
    public ContaResponse save(ContaRequest contaRequest) {
        Conta conta = mapper.toModel(contaRequest);
        repository.save(conta);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return contaResponse;
    }

    // ToDo: Read Conta Service
    public ContaResponse findById(UUID contaId) {
        Conta conta = repository.findById(contaId).get();
        ContaResponse contaResponse = mapper.toResponse(conta);
        return contaResponse;
    }

    // ToDo: Update Conta Service

    // ToDo: Delete Conta Service

}