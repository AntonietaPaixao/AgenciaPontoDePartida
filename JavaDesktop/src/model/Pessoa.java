package model;

public class Pessoa {
	
	//ATRIBUTOS
	protected int idPessoa;
	protected String cpf;
	protected String nomePessoa;
	protected String dataNascimento;
	protected char sexo;
	protected String email;
	protected String telefone;
	protected Endereco endereco;
	protected Permissoao permissao;
	
	
	//CONSTRUTOR
	//Permite criar pessoa sem endereço
	public Pessoa() {
		this.endereco = new Endereco();
		this.permissao = new Permissoao();
	}
	
	public Pessoa(String cpf,  String nomePessoa,  String dataNascimento, 
			char sexo, String email, String telefone, Endereco endereco, Permissoao permissao) {
		this.cpf = cpf;
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.permissao = permissao;
}

	public Pessoa(int idPessoa, String cpf,  String nomePessoa,  String dataNascimento, 
			char sexo, String email, String telefone, Endereco endereco, Permissoao permissao) {
		this.idPessoa = idPessoa;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Permissoao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissoao permissao) {
		this.permissao = permissao;
	}

	
	//MÉTODOS
	@Override
	public String toString() {
		return "***DADOS DA PESSOA***"
				+ "\n ID: " + idPessoa
				+ "\n CPF: " + cpf 
				+ "\n Nome: " + nomePessoa 
				+ "\n Data Nascimento: " + dataNascimento 
				+ "\n Sexo: " + sexo
				+ "\n Email: " + email
				+ "\n Telefone: " + telefone
				+ "\n Endereço: " + endereco.toString() 
				+ "\n Tipo Permissão: " + permissao.getTipoPermissao();
	}

}
