package br.com.pontodepartida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontodepartida.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
