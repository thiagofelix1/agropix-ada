package com.agropix.ada.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequest {

    private String nome;

    private String cpf;

    private String email;

    private String telefone;
}
