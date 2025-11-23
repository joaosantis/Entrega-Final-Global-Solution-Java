package br.com.fiap.synapse.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.synapse.model.Colaborador;
import br.com.fiap.synapse.repository.ColaboradorRepository;

@RestController
@RequestMapping("/api/iob")
public class IoBController {

    @Autowired
    private ColaboradorRepository repository;

    // Endpoint: POST /api/iob/biometria
    @PostMapping("/biometria")
    public ResponseEntity<String> receberBiometria(@RequestBody BiometriaDTO dto) {
        System.out.println("--- DADOS IOB RECEBIDOS ---");
        System.out.println("Colab ID: " + dto.colaboradorId() + " | Stress: " + dto.nivelStress());

        // Busca ou cria um colaborador novo
        Colaborador c = repository.findById(dto.colaboradorId()).orElse(new Colaborador());
        
        // Se for novo, preenche dados fictícios
        if(c.getId() == null) {
            c.setNome("Colaborador " + dto.colaboradorId());
            c.setCargo("Analista");
        }
        
        // Atualiza os dados
        c.setNivelStress(dto.nivelStress());
        c.setNivelFoco(dto.nivelFoco());
        c.setBatimentos(dto.batimentos());
        c.setDataLeitura(LocalDateTime.now());
        
        repository.save(c);
        
        return ResponseEntity.ok("Dados recebidos com sucesso!");
    }
}

// DTO para mapear o JSON do Python
record BiometriaDTO(Long colaboradorId, Integer nivelStress, Integer nivelFoco, Integer batimentos) {}