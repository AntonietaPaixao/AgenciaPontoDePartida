package br.com.pontodepartida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontodepartida.model.PacotePartida;

public interface PartidaRepository extends JpaRepository<PacotePartida, Long> {

}
