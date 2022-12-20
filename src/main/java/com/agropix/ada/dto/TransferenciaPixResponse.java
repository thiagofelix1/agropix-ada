package com.agropix.ada.dto;

import com.agropix.ada.model.StatusTransferencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaPixResponse {
    private String chaveOrigem;
    private String chaveDestino;
    private Double valor;
    private String banco;
    private StatusTransferencia statusTransferencia;
}
