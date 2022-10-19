package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partida {
	
	//ATRIBUTOS
	private int idPartida;
	private LocalDate  dataPartida;
	private String nomeCampeonato;
	private String timeCasa;
	private String timeVisitante;
	
	//Formata Data
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	//CONSTRUTOR
	public Partida() {
		
	};
	
	public Partida(String dataPartida, String nomeCampeonato, String timeCasa, String timeVisitante) {
		this.dataPartida = LocalDate.parse(dataPartida);
		this.nomeCampeonato = nomeCampeonato;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
	}
	
	public Partida(int idPartida, String dataPartida, String nomeCampeonato, String timeCasa, String timeVisitante) {
		this.idPartida = idPartida;
		this.dataPartida = LocalDate.parse(dataPartida);
		this.nomeCampeonato = nomeCampeonato;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
	}
	
	
	//GETTERS AND SETTERS
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public String getData() {
		return formata.format(dataPartida);
	}

	public void setData(String dataPartida) {
		this.dataPartida = LocalDate.parse(dataPartida);
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
	
	//MÉTDOS
	@Override
	public String toString() {
		return "***DADOS DA PARTIDA***"
				+ "\n ID: " + this.idPartida
				+ "\n Data da Partida: " + this.dataPartida
				+ "\n Campeonato: " + this.nomeCampeonato
				+ "\n Time da Casa: " + this.timeCasa
				+ "\n Time Visitante: " + this.timeVisitante;
	}

}
