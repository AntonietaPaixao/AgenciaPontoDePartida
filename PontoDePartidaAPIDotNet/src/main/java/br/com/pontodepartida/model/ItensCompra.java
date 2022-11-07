package br.com.pontodepartida.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITENSCOMPRA")
public class ItensCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItensCompra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPacotePartida", nullable = false)
	private PacotePartida pacotePartida;

	@Column(nullable = false, length = 5)
	private int quantidade;

	// CONSTRUTORES
	public ItensCompra(Long idItensCompra, PacotePartida pacotePartida, int quantidade) {
		super();
		this.idItensCompra = idItensCompra;
		this.quantidade = quantidade;
		this.pacotePartida = pacotePartida;
	}

	public ItensCompra() {
	};

	// GETTERS AND SETTERS
	public Long getIdItensCompra() {
		return idItensCompra;
	}

	public void setIdItensCompra(Long idItensCompra) {
		this.idItensCompra = idItensCompra;
	}

	public PacotePartida getPacotePartida() {
		return pacotePartida;
	}

	public void setPacotePartida(PacotePartida pacotePartida) {
		this.pacotePartida = pacotePartida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// MÉTODOS
	public double subTotal() {
		double sub = pacotePartida.getValorPacote() * this.quantidade;
		return (sub);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItensCompra, pacotePartida, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensCompra other = (ItensCompra) obj;
		return Objects.equals(idItensCompra, other.idItensCompra) && Objects.equals(pacotePartida, other.pacotePartida)
				&& quantidade == other.quantidade;
	}

	@Override
	public String toString() {
		return "ItensCompra [idItensCompra=" + idItensCompra + ", pacotePartida=" + pacotePartida + ", quantidade="
				+ quantidade + "]";
	}

}
