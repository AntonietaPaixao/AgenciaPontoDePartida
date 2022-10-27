package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {

	// ATRIBUTOS
	private int idCompra;
	private double valorCompra;
	private LocalDate dataCompra;
	private int quantidadePacotes;
//DUVIDA:A declaração dessa forma, já é uma instanciação de um objeto?	
	private Pessoa pessoa; 
	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	
	//Formata Data
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("d/MM/yyyy");

	// CONSTRUTORES
	public Compra() {
		this.pessoa = new Pessoa();
	};

	public Compra(String dataCompra, Pessoa pessoa) {
		this.dataCompra = LocalDate.parse(dataCompra);
		this.pessoa = pessoa;
	}
	
	public Compra(int idCompra, String dataCompra, Pessoa pessoa) {
		this.idCompra = idCompra;
		this.dataCompra = LocalDate.parse(dataCompra);
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
		return formata.format(dataCompra);
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = LocalDate.parse(dataCompra);
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
		calculaValorQuantidadeMais();
		
	}

	public void removeItem(ItensCompra item) {
		itensCompra.remove(item);
		calculaValorQuantidadeMenos();

	}
	
	public void calculaValorQuantidadeMais() {
		double valor = 0.0;
		int quant = 0;
		
		for (ItensCompra itm : itensCompra) {
			valor += itm.subTotal();
			quant++;
		}
		quantidadePacotes = quant;
		valorCompra=valor;	
		
	}
	
	public void calculaValorQuantidadeMenos() {
		double valor = valorCompra;
		int quant = quantidadePacotes;
		
		for (ItensCompra itm : itensCompra) {
			valor -= itm.subTotal();
			quant--;
		}
		quantidadePacotes = quant;
		valorCompra=valor;		
		
	}
	
	
	@Override
	public String toString() {
		return "***DADOS DA COMPRA***" + "\n ID: " + idCompra + "\n Valor da compra: " + valorCompra
				+ "\n Datada da compra: " + dataCompra + "\n Quantidade de pacotes: " + quantidadePacotes
				+ "\n Cliente: " + this.pessoa.toString();
	}

}
