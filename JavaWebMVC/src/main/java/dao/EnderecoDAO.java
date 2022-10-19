package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Endereco;

public class EnderecoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	//Inicio SAVE
	public void save(Endereco endereco) {

		String sql = "INSERT INTO ENDERECO (cidade, estadoUf, logradouro, bairro, numero)" + " VALUES(?,?,?,?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, endereco.getCidade());
			pstm.setString(2, endereco.getEstadoUf());	
			pstm.setString(3, endereco.getLogradouro());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getNumero());
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

	//Inicio LIST
	public List<Endereco> getEnderecoList() {

		String sql = "SELECT * FROM ENDERECO";

		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		ResultSet rset = null;
		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(rset.getInt("idEndereco"));
				endereco.setCidade(rset.getString("cidade"));
				endereco.setEstadoUf(rset.getString("estadoUf"));
				endereco.setLogradouro(rset.getString("logradouro"));
				endereco.setBairro(rset.getString("bairro"));
				endereco.setNumero(rset.getString("numero"));
			
				listaEnderecos.add(endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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
		return listaEnderecos;
	}

	//Inicio UPDATE
	public void update(Endereco endereco) {
		String sql = "UPDATE ENDERECO SET cidade = ?, estadoUf = ?, logradouro = ?, bairro = ?, numero= ?" + " WHERE idEndereco = ?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, endereco.getCidade());
			pstm.setString(2, endereco.getEstadoUf());	
			pstm.setString(3, endereco.getLogradouro());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getNumero());
			pstm.setInt(6, endereco.getIdEndereco());
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
	
	//Inicio DELETE
	public void deleteById(int id) {

		String sql = "DELETE FROM ENDERECO" + " WHERE idEndereco = ?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
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

	//Inicio GET
	public Endereco getEnderecoById(int id) {

		String sql = "SELECT * FROM ENDERECO" + " WHERE idEndereco = ?";
		Endereco endereco = new Endereco();

		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			
			endereco.setIdEndereco(rset.getInt("idEndereco"));
			endereco.setCidade(rset.getString("cidade"));
			endereco.setEstadoUf(rset.getString("estadoUf"));
			endereco.setLogradouro(rset.getString("logradouro"));
			endereco.setBairro(rset.getString("bairro"));
			endereco.setNumero(rset.getString("numero"));
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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
		return endereco;
	}


}