package br.com.leoneigomes.api.controller;

import br.com.leoneigomes.api.dto.EnderecoDTO;
import br.com.leoneigomes.api.entity.Endereco;
import br.com.leoneigomes.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        Optional<Endereco> enderecoOptional = enderecoService.buscarEnderecoPorId(id);
        return enderecoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Endereco> salvarEndereco(@PathVariable Long pessoaId, @RequestBody EnderecoDTO enderecoDTO) {
        Endereco enderecoSalvo = enderecoService.salvarEndereco(pessoaId, enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
