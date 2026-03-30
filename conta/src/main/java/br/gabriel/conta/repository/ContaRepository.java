package br.gabriel.conta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gabriel.conta.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findByTituloContaining(String titulo);

}
