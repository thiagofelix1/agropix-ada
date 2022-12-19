package com.agropix.ada.service;


import com.agropix.ada.dto.ContaRequest;
import com.agropix.ada.exceptions.ItemNotExistsException;
import com.agropix.ada.mapper.ContaMapper;
import com.agropix.ada.model.Cliente;
import com.agropix.ada.model.Conta;
import com.agropix.ada.model.TipoConta;
import com.agropix.ada.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;
    private  final ContaMapper mapper;
    private final ClienteService clienteService;
    private final TipoContaService tipoContaService;

    public Conta save(ContaRequest contaRequest) {
        Conta conta = mapper.toModel(contaRequest);
        TipoConta tipoConta = tipoContaService.findTipoContaById(contaRequest.getTipoContaId());
        Cliente cliente = clienteService.findById(contaRequest.getClienteId());
        conta.setCliente(cliente);
        conta.setTipoConta(tipoConta);
        repository.save(conta);
        return conta;
    }

    public Conta findById(UUID contaId) {
        Conta conta = repository.findById(contaId)
                .orElseThrow(() -> new ItemNotExistsException("Conta não encontrada!"));
        return conta;
    }

    public Conta update(UUID contaId, ContaRequest contaRequest) {
        Conta conta = findById(contaId);
        conta = mapper.toModel(contaRequest);
        conta.setId(contaId);
        repository.save(conta);
        return conta;
    }

    public void delete(UUID contaId) {
        Conta conta = findById(contaId);
        repository.delete(conta);
    }

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta deposit(UUID contaId, Double valor) {
        Conta conta = findById(contaId);
        conta.deposito(valor);
        repository.save(conta);
        return conta;
    }

    public Conta withdraw(UUID contaId, Double valor) {
        Conta conta = findById(contaId);
        conta.saque(valor);
        repository.save(conta);
        return conta;
    }

}
