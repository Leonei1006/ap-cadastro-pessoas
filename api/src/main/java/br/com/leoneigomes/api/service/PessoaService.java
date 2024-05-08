package br.com.leoneigomes.api.service;

import br.com.leoneigomes.api.dto.PessoaDTO;
import br.com.leoneigomes.api.entity.Pessoa;
import br.com.leoneigomes.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa salvarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            BeanUtils.copyProperties(pessoaDTO, pessoa);
            return pessoaRepository.save(pessoa);
        } else {
            throw new RuntimeException("Pessoa não encontrada com o ID: " + id);
        }
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
