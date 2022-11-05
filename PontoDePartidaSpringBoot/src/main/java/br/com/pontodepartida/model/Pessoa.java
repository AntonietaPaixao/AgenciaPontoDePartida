package br.com.pontodepartida.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.pontodepartida.model.Pessoa;

@Entity
@Table(name = "pessoa")
public class Pessoa implements UserDetails, Serializable  {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idPessoa;

	@Column(nullable = false, length = 20)
	protected String senha;

	@Column(nullable = false, length = 50)
	protected String nomePessoa;

	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	protected LocalDate dataNascimento;

	@Column(nullable = false, length = 5)
	protected char sexo;

	@Column(nullable = false, unique = true, length = 20)
	protected String email;

	@Column(nullable = false, length = 20)
	protected String telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEndereco", nullable = false)
	protected Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPermissao", nullable = false)
	protected Permissao permissao;

	// CONSTRUTORES
	public Pessoa(Long idPessoa, String senha, String nomePessoa, LocalDate dataNascimento, char sexo, String email,
			String telefone, Endereco endereco, Permissao permissao) {
		super();
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

	public Pessoa() {

	}

	// GETTERS AND SETTERS
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	// MÉTODOS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataNascimento, email, endereco, idPessoa, nomePessoa, permissao, senha, sexo, telefone);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(idPessoa, other.idPessoa)
				&& Objects.equals(nomePessoa, other.nomePessoa) && Objects.equals(permissao, other.permissao)
				&& Objects.equals(senha, other.senha) && sexo == other.sexo && Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "***DADOS DA PESSOA***" + "\n ID: " + idPessoa + "\n Nome: " + nomePessoa + "\n Data Nascimento: "
				+ dataNascimento + "\n Sexo: " + sexo + "\n Email: " + email + "\n Telefone: " + telefone
				+ "\n Endereço: " + endereco.toString() + "\n Tipo Permissão: " + permissao.getTipoPermissao();
	}
	
	public Pessoa orElseThrow(Pessoa pessoa) {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
