package br.com.fiap.synapse.repository;

import br.com.fiap.synapse.model.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Long> {
}