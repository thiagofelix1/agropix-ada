package com.agropix.ada.controller;

import com.agropix.ada.dto.InfoChavePixBacen;
import com.agropix.ada.dto.NotificacaoBacenRequest;
import com.agropix.ada.dto.TransferenciaPixRequest;
import com.agropix.ada.dto.TransferenciaPixResponse;
import com.agropix.ada.service.TransferenciaPixService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transferencia-pix")
public class TransferenciaPixController {

    private final TransferenciaPixService service;

    @PostMapping
    public ResponseEntity<TransferenciaPixResponse> transfer(@Valid @RequestBody TransferenciaPixRequest transferenciaPixRequest) {
        TransferenciaPixResponse transferenciaPixResponse = service.transfer(transferenciaPixRequest);
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaPixResponse);
    }

    @GetMapping("/dados-chave/{chavePix}")
    public ResponseEntity<InfoChavePixBacen> getDadosChave(@PathVariable String chavePix) {
        InfoChavePixBacen infoChavePixBacen = service.buscarInformacoesChavePix(chavePix);
        return ResponseEntity.status(HttpStatus.OK).body(infoChavePixBacen);
    }

    @PostMapping("/notificacao")
    public ResponseEntity<?> getNotificacaoTransferencia(@Valid @RequestBody NotificacaoBacenRequest notificacaoBacenRequest) {
        service.receberPix(notificacaoBacenRequest.getChaveDestino(), notificacaoBacenRequest.getValor());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
