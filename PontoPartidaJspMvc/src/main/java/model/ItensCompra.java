package model;

public class ItensCompra {

	// ATRIBUTOS
	private int idItensCompra;
	private PacotePartida pacotePartida;
	private int quantidade;

	// CONSTRUTORES
	public ItensCompra() {
		this.pacotePartida = new PacotePartida();
	};

	public ItensCompra(PacotePartida pacotePartida, int quantidade) {
		this.quantidade = quantidade;
		this.pacotePartida = pacotePartida;
	}

	public ItensCompra(int idItensCompra, PacotePartida pacotePartida, int quantidade){
		this.idItensCompra = idItensCompra;
		this.quantidade=quantidade;
		this.pacotePartida = pacotePartida;
	}

	// GETTERS AND SETTERS

	public int getIdItensCompra() {
		return idItensCompra;
	}

	public void setIdItensCompra(int idItensCompra) {
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
		return (pacotePartida.getValorPacote() * this.quantidade);
	}

	@Override
	public String toString() {
		return "ItensCompra [idItensCompra=" + idItensCompra + ", pacotePartida=" + pacotePartida + ", quantidade="
				+ quantidade + "]";
	}

}
