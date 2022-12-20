package com.agropix.ada.dto;

import com.agropix.ada.model.Cliente;
import com.agropix.ada.model.TipoConta;
import lombok.Data;

import java.util.UUID;
@Data
public class ContaResponse {

    private UUID id;
    private Long numeroConta;
    private Integer digito;
    private String agencia;
    private Cliente cliente;
    private Double saldo;
    private TipoConta tipoConta;
    private String nomeBanco;

}
