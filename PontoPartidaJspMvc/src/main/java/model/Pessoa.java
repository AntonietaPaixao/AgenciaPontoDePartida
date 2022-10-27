package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	
	//ATRIBUTOS
	protected int idPessoa;
	protected String senha;
	protected String nomePessoa;
	protected LocalDate dataNascimento;
	protected char sexo;
	protected String email;
	protected String telefone;
	protected Endereco endereco;
	protected Permissao permissao;
	
	//Formatar Data
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("d/MM/yyyy");

	
	//CONSTRUTOR
	//Permite criar pessoa sem endereço
	public Pessoa() {
		this.endereco = new Endereco();
		this.permissao = new Permissao();
	}
	
	public Pessoa(String senha,  String nomePessoa,  String dataNascimento, 
			char sexo, String email, String telefone, Endereco endereco, Permissao permissao) {
		this.senha = senha;
		this.nomePessoa = nomePessoa;
		this.dataNascimento = LocalDate.parse(dataNascimento);
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.permissao = permissao;
}

	public Pessoa(int idPessoa, String senha,  String nomePessoa,  LocalDate dataNascimento, 
			char sexo, String email, String telefone, Endereco endereco, Permissao permissao) {
		this.idPessoa = idPessoa;
		this.senha = senha;
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.permissao = permissao;
}
	
	//GETTERS AND SETTERS
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDataNascimento() {
		return formata.format(dataNascimento);
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = LocalDate.parse(dataNascimento);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	
	//MÉTODOS
	@Override
	public String toString() {
		return "***DADOS DA PESSOA***"
				+ "\n ID: " + idPessoa
				+ "\n Nome: " + nomePessoa 
				+ "\n Data Nascimento: " + dataNascimento 
				+ "\n Sexo: " + sexo
				+ "\n Email: " + email
				+ "\n Telefone: " + telefone
				+ "\n Endereço: " + endereco.toString() 
				+ "\n Tipo Permissão: " + permissao.getTipoPermissao();
	}

}
