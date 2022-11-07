package br.com.pontodepartida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontodepartida.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
