package br.com.pontodepartida.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	@Column(nullable = false, length = 20)
	private String cidade;

	@Column(nullable = false, length = 2)
	private String estadoUf;

	@Column(nullable = false, length = 50)
	private String logradouro;

	@Column(nullable = false, length = 20)
	private String bairro;

	@Column(nullable = false, length = 10)
	private String numero;

	// CONTRUTORES
	public Endereco(Long idEndereco, String logradouro, String numero, String bairro, String cidade, String estadoUf) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estadoUf = estadoUf;
	}

	public Endereco() {

	}

	// GETTERS AND SETTERS
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoUf() {
		return estadoUf;
	}

	public void setEstadoUf(String estadoUf) {
		this.estadoUf = estadoUf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	// MÉTDOS
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, estadoUf, idEndereco, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estadoUf, other.estadoUf) && Objects.equals(idEndereco, other.idEndereco)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "***DADOS DO ENDEREÇO***" + "\n ID: " + idEndereco + "\n Rua.: " + logradouro + "\n Numero: " + numero
				+ "\n Bairro: " + bairro + "\n Cidade: " + cidade + "\n Estado: " + estadoUf;
	}

}
