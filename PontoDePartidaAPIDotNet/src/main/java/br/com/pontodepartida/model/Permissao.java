package br.com.pontodepartida.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Serializableé o processo no qual a instância de um objeto é transformada em
 * uma sequência de bytes e é útil quando precisamos enviar objetos pela rede,
 * salvar no disco, ou comunicar de uma JVM com outra
 **/

@Entity
@Table(name = "PERMISSAO")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPermissao;

	@Column(nullable = false, length = 20)
	private String tipoPermissao;

	// CONSTRUTORES
	/**
	 * super serve para chamar o construtor da superclasse. Ele sempre é chamado,
	 * mesmo quando não está explícito no código
	 **/
	public Permissao(Long idPermissao, String tipoPermissao) {
		super();
		this.idPermissao = idPermissao;
		this.tipoPermissao = tipoPermissao;
	}

	public Permissao() {

	}

	// GETTERS AND SETTERS
	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(String tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	// MÉTDOS
	@Override
	public int hashCode() {
		return Objects.hash(idPermissao, tipoPermissao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		return Objects.equals(idPermissao, other.idPermissao) && Objects.equals(tipoPermissao, other.tipoPermissao);
	}

	@Override
	public String toString() {
		return "***DADOS DAS PERMISSOES***" + "\n ID Permissão: " + this.idPermissao + "\n Tipo de Permissão: "
				+ this.tipoPermissao;
	}

}
