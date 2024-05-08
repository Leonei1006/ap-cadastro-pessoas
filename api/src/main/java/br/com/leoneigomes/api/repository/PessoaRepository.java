package br.com.leoneigomes.api.repository;

import br.com.leoneigomes.api.dto.PessoaDTO;
import br.com.leoneigomes.api.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

//    PessoaDTO criarPessoa(PessoaDTO pessoaDTO);
//
//    PessoaDTO consultarPessoa(Long id);
//
//    PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO);
//
//    void excluirPessoa(Long id);
}
