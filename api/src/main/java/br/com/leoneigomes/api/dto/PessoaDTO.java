package br.com.leoneigomes.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaDTO {

    private String nomeCompleto;
    private String dataNascimento;
    private List<EnderecoDTO> enderecos;
}
