package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConexaoMySQL;

public class ReiniciaTabelaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Inicio DELETE
	public void deletaTabela(String tabela) {

		String sql = "DROP TABLE" + "?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tabela);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Inicio GET
	public void criaTabela(String tabela) {

		String sql1 = "CREATE TABLE PERMISSOES (\r\n" + "    idPermissoes INT NOT NULL UNIQUE AUTO_INCREMENT,\r\n"
				+ "    tipoPermissao VARCHAR(20),\r\n" + "	PRIMARY KEY (idPermissoes)\r\n" + ");";

		String sql2 = "CREATE TABLE ENDERECO (\r\n" + "    idEndereco INT NOT NULL UNIQUE AUTO_INCREMENT,\r\n"
				+ "    numero VARCHAR(10),\r\n" + "    logradouro VARCHAR(50),\r\n" + "    estadoUF VARCHAR(2),\r\n"
				+ "    bairro VARCHAR(20),\r\n" + "    cidade VARCHAR(20),\r\n" + "	PRIMARY KEY (idEndereco)\r\n"
				+ ");";

		String sql3 = "CREATE TABLE PESSOA (\r\n" + "    idPessoa INT NOT NULL UNIQUE AUTO_INCREMENT,\r\n"
				+ "    CPF VARCHAR(11),\r\n" + "    nomePessoa VARCHAR(50),\r\n" + "    dataNascimento DATE,\r\n"
				+ "    sexo VARCHAR(10),\r\n" + "    telefone VARCHAR(20),\r\n" + "    email VARCHAR(20),\r\n"
				+ "	idEndereco INT,\r\n" + "	idPermissoes INT,\r\n" + "	PRIMARY KEY (idPessoa),\r\n"
				+ "	FOREIGN KEY (idEndereco)\r\n" + "	REFERENCES ENDERECO(idEndereco),\r\n"
				+ "	FOREIGN KEY (idPermissoes)\r\n" + "	REFERENCES PERMISSOES(idPermissoes)\r\n" + "    );";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			if (tabela == "permissao") {
				pstm = conn.prepareStatement(sql1);
			} else if (tabela == "endereco") {
				pstm = conn.prepareStatement(sql2);
			} else {
				pstm = conn.prepareStatement(sql3);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
