package br.com.leoneigomes.api.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;
}
