package com.agropix.ada.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class TransferenciaPixRequest {

    private String chaveOrigem;
    private String chaveDestino;

    @Min(value = 0, message = "Valor da operação não pode ser menor ou igual a 0")
    private Double valor;

}
