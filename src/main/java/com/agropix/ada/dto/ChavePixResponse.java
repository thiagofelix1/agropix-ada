package com.agropix.ada.dto;

import com.agropix.ada.model.Conta;
import lombok.Data;

@Data
public class ChavePixResponse {

    private String chavePix;

    private String tipo;

    private Conta conta;
}
