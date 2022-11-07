package br.com.pontodepartida.model;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "PACOTEPARTIDA")
public class PacotePartida implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idPacotePartida;

	@Column(nullable = false, length = 20)
	protected String nomePacote;

	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	protected LocalDate dataSaida;

	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	protected LocalDate dataRetorno;

	@Column(nullable = false, length = 10)
	protected double valorPacote;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPartida", nullable = false)
	protected Partida partida;

	// CONSTRUTORES
	public PacotePartida(Long idPacotePartida, String nomePacote, LocalDate dataSaida, LocalDate dataRetorno,
			double valorPacote, Partida partida) {
		this.idPacotePartida = idPacotePartida;
		this.nomePacote = nomePacote;
		this.dataSaida = dataRetorno;
		this.dataRetorno = dataRetorno;
		this.valorPacote = valorPacote;
		this.partida = partida;
	}

	public PacotePartida() {
	}

	// GETTERS AND SETTERS
	public Long getIdPacotePartida() {
		return idPacotePartida;
	}

	public void setIdPacotePartida(Long idPacotePartida) {
		this.idPacotePartida = idPacotePartida;
	}

	public String getNomePacote() {
		return nomePacote;
	}

	public void setNomePacote(String nomePacote) {
		this.nomePacote = nomePacote;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalDate getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public double getValorPacote() {
		return valorPacote;
	}

	public void setValorPacote(double valorPacote) {
		this.valorPacote = valorPacote;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	// MÉTDOS
	@Override
	public int hashCode() {
		return Objects.hash(dataRetorno, dataSaida, idPacotePartida, nomePacote, partida, valorPacote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacotePartida other = (PacotePartida) obj;
		return Objects.equals(dataRetorno, other.dataRetorno) && Objects.equals(dataSaida, other.dataSaida)
				&& Objects.equals(idPacotePartida, other.idPacotePartida)
				&& Objects.equals(nomePacote, other.nomePacote) && Objects.equals(partida, other.partida)
				&& Double.doubleToLongBits(valorPacote) == Double.doubleToLongBits(other.valorPacote);
	}

	@Override
	public String toString() {
		return "***DADOS DO PACOTE***" + "\n ID: " + this.idPacotePartida + "\n Nome: " + this.nomePacote
				+ "\n Datada Saída: " + this.dataSaida + "\n Datada Retorno: " + this.dataRetorno + "\n Partida: "
				+ this.partida.toString();
	}

}
