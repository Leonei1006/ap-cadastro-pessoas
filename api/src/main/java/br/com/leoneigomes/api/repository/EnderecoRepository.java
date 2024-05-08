package br.com.leoneigomes.api.repository;

import br.com.leoneigomes.api.dto.EnderecoDTO;
import br.com.leoneigomes.api.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
//    EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO);
//
//    EnderecoDTO atualizarEndereco(Long id, EnderecoDTO enderecoDTO);
//
//    void excluirEndereco(Long id);
}
