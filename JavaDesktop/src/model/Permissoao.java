package model;

public class Permissoao {
	
	//ATRIBUTOS
	private int idPermissao;
	private String tipoPermissao;

	//CONTRUTORES
	public Permissoao() {
		
	}
	public Permissoao (String tipoPermissao)
	{
		this.tipoPermissao = tipoPermissao;
	}
	
	public Permissoao (int idPermissao, String tipoPermissao)
	{
		this.idPermissao = idPermissao;
		this.tipoPermissao = tipoPermissao;
	}
	
	//GETTERS AND SETTERS	
	public int getIdPermissao() {
		return idPermissao;
	}
	
	public void setIdPermissao(int idPermissao) {
		this.idPermissao = idPermissao;
	}
	public String getTipoPermissao() {
		return tipoPermissao;
	}
	public void setTipoPermissao(String tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}
	
	//MÉTDOS
	@Override
	public String toString() {
		return "***DADOS DAS PERMISSOES***"
		+ "\n ID Permissão: " + this.idPermissao
		+ "\n Tipo de Permissão: " + this.tipoPermissao;
	}
		
}
