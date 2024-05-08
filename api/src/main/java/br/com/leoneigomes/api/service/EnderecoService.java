package br.com.leoneigomes.api.service;

import br.com.leoneigomes.api.dto.EnderecoDTO;
import br.com.leoneigomes.api.entity.Endereco;
import br.com.leoneigomes.api.entity.Pessoa;
import br.com.leoneigomes.api.repository.EnderecoRepository;
import br.com.leoneigomes.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco salvarEndereco(Long pessoaId, EnderecoDTO enderecoDTO) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            Pessoa pessoa = pessoaOptional.get();
            endereco.setPessoa(pessoa);
            return enderecoRepository.save(endereco);
        } else {
            throw new RuntimeException("Pessoa não encontrada com o ID: " + pessoaId);
        }
    }

    public Endereco atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            return enderecoRepository.save(endereco);
        } else {
            throw new RuntimeException("Endereço não encontrado com o ID: " + id);
        }
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
