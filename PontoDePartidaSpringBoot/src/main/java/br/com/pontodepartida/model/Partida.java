package br.com.pontodepartida.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "PARTIDA")
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartida;

	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataPartida;

	@Column(nullable = false, length = 20)
	private String nomeCampeonato;

	@Column(nullable = false, length = 15)
	private String timeCasa;

	@Column(nullable = false, length = 15)
	private String timeVisitante;

	// CONSTRUTORES
	public Partida(Long idPartida, LocalDate dataPartida, String nomeCampeonato, String timeCasa,
			String timeVisitante) {
		super();
		this.idPartida = idPartida;
		this.dataPartida = dataPartida;
		this.nomeCampeonato = nomeCampeonato;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
	}

	public Partida() {

	};

	// GETTERS AND SETTERS
	public Long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}

	public LocalDate getData() {
		return dataPartida;
	}

	public void setData(LocalDate dataPartida) {
		this.dataPartida = dataPartida;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public String getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(String timeCasa) {
		this.timeCasa = timeCasa;
	}

	public String getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(String timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	// MÉTDOS
	@Override
	public int hashCode() {
		return Objects.hash(dataPartida, idPartida, nomeCampeonato, timeCasa, timeVisitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(dataPartida, other.dataPartida) && Objects.equals(idPartida, other.idPartida)
				&& Objects.equals(nomeCampeonato, other.nomeCampeonato) && Objects.equals(timeCasa, other.timeCasa)
				&& Objects.equals(timeVisitante, other.timeVisitante);
	}

	@Override
	public String toString() {
		return "***DADOS DA PARTIDA***" + "\n ID: " + this.idPartida + "\n Data da Partida: " + this.dataPartida
				+ "\n Campeonato: " + this.nomeCampeonato + "\n Time da Casa: " + this.timeCasa + "\n Time Visitante: "
				+ this.timeVisitante;
	}

}
