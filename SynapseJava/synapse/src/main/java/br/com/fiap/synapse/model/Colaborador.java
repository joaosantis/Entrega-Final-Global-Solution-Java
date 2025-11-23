package br.com.fiap.synapse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity; // Importante para validação
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório") // Requisito: Validação
    private String nome;

    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    @Min(0) @Max(100) // Garante dados coerentes do IoB
    private Integer nivelStress;

    @Min(0) @Max(100)
    private Integer nivelFoco;

    @Min(0)
    private Integer batimentos;
    
    private LocalDateTime dataLeitura = LocalDateTime.now();
}