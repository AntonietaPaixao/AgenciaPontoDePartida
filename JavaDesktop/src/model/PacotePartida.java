package model;

public class PacotePartida {

	// ATRIBUTOS
	protected int idPacotePartida;
	protected String nomePacote;
	protected String dataSaida;
	protected String dataRetorno;
	protected double valorPacote;
	protected Partida partida;

	// CONSTRUTOR
	public PacotePartida() {
	}

	public PacotePartida(String nomePacote, String dataSaida, String dataRetorno,
			double valorPacote, Partida partida) {
		this.nomePacote = nomePacote;
		this.dataSaida = dataSaida;
		this.dataRetorno = dataRetorno;
		this.valorPacote = valorPacote;
		this.partida = partida;
	}

	public PacotePartida(int idPacotePartida, String nomePacote, String dataSaida, String dataRetorno,
			double valorPacote, Partida partida) {
		this.idPacotePartida = idPacotePartida;
		this.nomePacote = nomePacote;
		this.dataSaida = dataSaida;
		this.dataRetorno = dataRetorno;
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
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
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
	public String toString() {
		return "***DADOS DO PACOTE***" + "\n ID: " + this.idPacotePartida + "\n Nome: " + this.nomePacote
				+ "\n Datada Saída: " + this.dataSaida + "\n Datada Retorno: " + this.dataRetorno + "\n Partida: "
				+ this.partida.toString();
	}

}
