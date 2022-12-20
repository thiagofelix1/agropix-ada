package com.agropix.ada.controller;

import com.agropix.ada.dto.TipoContaRequest;
import com.agropix.ada.dto.TipoContaResponse;
import com.agropix.ada.mapper.TipoContaMapper;
import com.agropix.ada.model.TipoConta;
import com.agropix.ada.service.TipoContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tipo-conta")
@RequiredArgsConstructor
public class TipoContaController {

    private final TipoContaService service;
    private final TipoContaMapper mapper;

    @PostMapping()
    public ResponseEntity<TipoContaResponse> create(@Valid @RequestBody TipoContaRequest tipoContaRequest) {
        TipoConta tipoConta = service.create(tipoContaRequest);
        TipoContaResponse tipoContaResponse = mapper.toResponse(tipoConta);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoContaResponse);
    }

    @GetMapping()
    public ResponseEntity<List<TipoContaResponse>> findAll() {
        List<TipoConta> tipoContaList = service.findAll();
        List<TipoContaResponse> tipoContaResponseList = mapper.toTipoContaResponseList(tipoContaList);
        return ResponseEntity.status(HttpStatus.OK).body(tipoContaResponseList);
    }

    @GetMapping("{tipoContaId}")
    public ResponseEntity<TipoContaResponse> findById(@PathVariable UUID tipoContaId) {
        TipoConta tipoConta = service.findTipoContaById(tipoContaId);
        TipoContaResponse tipoContaResponse = mapper.toResponse(tipoConta);
        return ResponseEntity.status(HttpStatus.OK).body(tipoContaResponse);
    }

    @PutMapping("{tipoContaId}")
    public ResponseEntity<TipoContaResponse> update(@Valid @RequestBody TipoContaRequest tipoContaRequest, @PathVariable UUID tipoContaId) {
        TipoConta tipoConta = service.update(tipoContaId, tipoContaRequest);
        TipoContaResponse tipoContaResponse = mapper.toResponse(tipoConta);
        return ResponseEntity.status(HttpStatus.OK).body(tipoContaResponse);
    }

    @DeleteMapping("{tipoContaId}")
    public void delete(@PathVariable UUID tipoContaId) {
        service.delete(tipoContaId);
    }

}
