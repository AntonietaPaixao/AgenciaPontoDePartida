package br.com.pontodepartida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontodepartida.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
