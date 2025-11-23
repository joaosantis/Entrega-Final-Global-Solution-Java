package br.com.fiap.synapse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.synapse.model.Desafio;
import br.com.fiap.synapse.repository.DesafioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/desafios")
public class DesafioController {

    @Autowired
    private DesafioRepository repository;

    @PostMapping
    public ResponseEntity<Desafio> criar(@RequestBody @Valid Desafio desafio) {
        return ResponseEntity.ok(repository.save(desafio));
    }

    // Requisito: Paginação
    @GetMapping
    public Page<Desafio> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @PostMapping("/{id}/analise")
    public ResponseEntity<Desafio> analisar(@PathVariable Long id, @RequestBody AnaliseDTO dto) {
        return repository.findById(id).map(d -> {
            d.setSugestaoIa(dto.sugestao());
            d.setPerfilProfissional(dto.perfilProfissional());
            return ResponseEntity.ok(repository.save(d));
        }).orElse(ResponseEntity.notFound().build());
    }
}
record AnaliseDTO(String sugestao, String perfilProfissional) {}