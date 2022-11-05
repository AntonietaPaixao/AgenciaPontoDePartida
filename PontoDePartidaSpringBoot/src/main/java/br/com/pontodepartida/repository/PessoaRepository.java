package br.com.pontodepartida.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontodepartida.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Optional<Pessoa> findByemail(String email);
}
