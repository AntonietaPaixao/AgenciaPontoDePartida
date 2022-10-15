package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	// ATRIBUTOS
	private int idCompra;
	private double valorCompra;
	private String dataCompra;
	private int quantidadePacotes;
	private Pessoa pessoa;
	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();

	// CONSTRUTORES
	public Compra() {
		this.pessoa = new Pessoa();
	};

	public Compra(String dataCompra, int quantidadePacotes, Pessoa pessoa) {
		this.dataCompra = dataCompra;
		this.quantidadePacotes = quantidadePacotes;
		this.pessoa = pessoa;
	}
	
	public Compra(int idCompra, String dataCompra, int quantidadePacotes, Pessoa pessoa) {
		this.idCompra = idCompra;
		this.dataCompra = dataCompra;
		this.quantidadePacotes = quantidadePacotes;
		this.pessoa = pessoa;
	}
	
	// GETTERS AND SETTERS
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getQuantidadePacotes() {
		return quantidadePacotes;
	}

	public void setQuantidadePacotes(int quantPacotes) {
		this.quantidadePacotes = quantPacotes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ItensCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(List<ItensCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}

	
	//MÉTODOS
	public void acidionaItem(ItensCompra item) {
		itensCompra.add(item);
	}

	public void removeItem(ItensCompra item) {
		itensCompra.remove(item);
	}
	
	public void valorTotal() {

		double soma = 0.0;
		for (ItensCompra itm : itensCompra) {
			soma += itm.subTotal();
		}
		valorCompra=soma;
	}
	
	
	@Override
	public String toString() {
		return "***DADOS DA COMPRA***" + "\n ID: " + idCompra + "\n Valor da compra: " + valorCompra
				+ "\n Datada da compra: " + dataCompra + "\n Quantidade de pacotes: " + quantidadePacotes
				+ "\n Cliente: " + this.pessoa.toString();
	}

}
