package model;

public class Endereco {

	// ATRIBUTOS
	private int idEndereco;
	private String cidade;
	private String estadoUf;
	private String logradouro;
	private String bairro;
	private String numero;

	// CONTRUTORES
	public Endereco() {

	}
	
	public Endereco(String logradouro, String numero, String bairro, String cidade, String estadoUf) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estadoUf = estadoUf;
	}
	
	public Endereco(int idEndereco, String logradouro, String numero, String bairro, String cidade, String estadoUf) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estadoUf = estadoUf;
	}	

	// GETTERS AND SETTERS
	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoUf() {
		return estadoUf;
	}

	public void setEstadoUf(String estadoUf) {
		this.estadoUf = estadoUf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	// MÉTDOS
	@Override
	public String toString() {
		return "***DADOS DO ENDEREÇO***" + "\n ID: " + idEndereco + "\n Rua.: " + logradouro + "\n Numero: " + numero
				+ "\n Bairro: " + bairro + "\n Cidade: " + cidade + "\n Estado: " + estadoUf;
	}


}
