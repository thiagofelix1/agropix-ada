package com.agropix.ada.controller;

import com.agropix.ada.dto.ContaRequest;
import com.agropix.ada.dto.ContaResponse;
import com.agropix.ada.mapper.ContaMapper;
import com.agropix.ada.model.Conta;
import com.agropix.ada.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/conta")
public class ContaController {

    private final ContaService service;
    private final ContaMapper mapper;

    @PostMapping()
    public ResponseEntity<ContaResponse> create(@Valid @RequestBody ContaRequest contaRequest) {
        Conta conta = service.save(contaRequest);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);
    }

    @GetMapping("{contaId}")
    public ResponseEntity<ContaResponse> findById(@PathVariable UUID contaId) {
        Conta conta = service.findById(contaId);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponse);
    }
    @GetMapping()
    public ResponseEntity<List<ContaResponse>> findAll() {
        List<Conta> listaContas = service.findAll();
        List<ContaResponse> contaResponse = mapper.toResponseList(listaContas);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponse);
    }

    @PutMapping("{contaId}")
    public ResponseEntity<ContaResponse> update(@Valid @RequestBody ContaRequest contaRequest, @PathVariable UUID contaId) {
        Conta conta = service.update(contaId, contaRequest);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponse);
    }

    @DeleteMapping("{contaId}")
    public void delete(@PathVariable UUID contaId) {
        service.delete(contaId);
    }

    @PostMapping("/{contaId}/deposito")
    public ResponseEntity<?> deposito(@Valid @RequestBody Double valor, @PathVariable UUID contaId) {
        Conta conta = service.deposit(contaId, valor);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponse);
    }

    @PostMapping("/{contaId}/saque")
    public ResponseEntity<?> saque(@Valid @RequestBody Double valor, @PathVariable UUID contaId) {
        Conta conta = service.withdraw(contaId, valor);
        ContaResponse contaResponse = mapper.toResponse(conta);
        return ResponseEntity.status(HttpStatus.OK).body(contaResponse);
    }

}
