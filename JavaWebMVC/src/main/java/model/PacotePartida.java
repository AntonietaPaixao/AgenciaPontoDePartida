package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacotePartida {

	// ATRIBUTOS
	protected int idPacotePartida;
	protected String nomePacote;
	protected LocalDate dataSaida;
	protected LocalDate dataRetorno;
	protected double valorPacote;
	protected Partida partida;
	
	//Formata Data
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("d/MM/yyyy");

	// CONSTRUTOR
	public PacotePartida() {
	}

	public PacotePartida(String nomePacote, String dataSaida, String dataRetorno,
			double valorPacote, Partida partida) {
		this.nomePacote = nomePacote;
		this.dataSaida = LocalDate.parse(dataRetorno);
		this.dataRetorno = LocalDate.parse(dataRetorno);
		this.valorPacote = valorPacote;
		this.partida = partida;
	}

	public PacotePartida(int idPacotePartida, String nomePacote, String dataSaida, String dataRetorno,
			double valorPacote, Partida partida) {
		this.idPacotePartida = idPacotePartida;
		this.nomePacote = nomePacote;
		this.dataSaida = LocalDate.parse(dataRetorno);
		this.dataRetorno = LocalDate.parse(dataRetorno);
		this.valorPacote = valorPacote;
		this.partida = partida;
	}

	// GETTERS AND SETTERS
	public int getIdPacotePartida() {
		return idPacotePartida;
	}

	public void setIdPacotePartida(int idPacotePartida) {
		this.idPacotePartida = idPacotePartida;
	}

	public String getNomePacote() {
		return nomePacote;
	}

	public void setNomePacote(String nomePacote) {
		this.nomePacote = nomePacote;
	}

	public String getDataSaida() {
		return formata.format(dataSaida);
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = LocalDate.parse(dataSaida);
	}

	public String getDataRetorno() {
		return formata.format(dataRetorno);
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = LocalDate.parse(dataRetorno);
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
	public String toString() {
		return "***DADOS DO PACOTE***" + "\n ID: " + this.idPacotePartida + "\n Nome: " + this.nomePacote
				+ "\n Datada Saída: " + this.dataSaida + "\n Datada Retorno: " + this.dataRetorno + "\n Partida: "
				+ this.partida.toString();
	}

}
