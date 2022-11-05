package br.com.pontodepartida.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "COMPRA")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompra;

	@Column(nullable = false, length = 10)
	private double valorCompra;

	@Column(nullable = false, length = 10)
	private double valorDescontoPromocao;

	@Column(nullable = false, name = "dataCompra")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataCompra;

	@Column(nullable = false, length = 5)
	private int quantidadePacotes;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPermissao", nullable = false)
	private Pessoa pessoa;

	@OneToMany(mappedBy = "idItensCompra", fetch = FetchType.LAZY)
	private List<ItensCompra> itensCompra;

	// CONSTRUTORES

	public Compra(Long idCompra, double valorCompra, double valorDescontoPromocao, LocalDate dataCompra,
			int quantidadePacotes, Pessoa pessoa) {
		super();
		this.idCompra = idCompra;
		this.valorCompra = valorCompra;
		this.valorDescontoPromocao = valorDescontoPromocao;
		this.dataCompra = dataCompra;
		this.quantidadePacotes = quantidadePacotes;
		this.pessoa = pessoa;
	}

	public Compra() {
	};

	// GETTERS AND SETTERS
	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorDescontoPromocao() {
		return valorDescontoPromocao;
	}

	public void setVvalorDescontoPromocao(double valorDescontoPromocao) {
		this.valorDescontoPromocao = valorDescontoPromocao;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
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

	// MÉTODOS
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
		valorCompra = (valor - valorDescontoPromocao);

	}

	public void calculaValorQuantidadeMenos() {
		double valor = valorCompra;
		int quant = quantidadePacotes;

		for (ItensCompra itm : itensCompra) {
			valor -= itm.subTotal();
			quant--;
		}
		quantidadePacotes = quant;
		valorCompra = (valor - valorDescontoPromocao);

	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCompra, idCompra, itensCompra, pessoa, quantidadePacotes, valorCompra,
				valorDescontoPromocao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(dataCompra, other.dataCompra) && Objects.equals(idCompra, other.idCompra)
				&& Objects.equals(itensCompra, other.itensCompra) && Objects.equals(pessoa, other.pessoa)
				&& quantidadePacotes == other.quantidadePacotes
				&& Double.doubleToLongBits(valorCompra) == Double.doubleToLongBits(other.valorCompra)
				&& Double.doubleToLongBits(valorDescontoPromocao) == Double
						.doubleToLongBits(other.valorDescontoPromocao);
	}

	@Override
	public String toString() {
		return "***DADOS DA COMPRA***" + "\n ID: " + idCompra + "\n Valor da compra: " + valorCompra
				+ "\n Datada da compra: " + dataCompra + "\n Quantidade de pacotes: " + quantidadePacotes
				+ "\n Cliente: " + this.pessoa.toString();
	}

}
