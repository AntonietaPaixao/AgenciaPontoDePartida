package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Endereco;
import model.Permissao;
import model.Pessoa;


public class PessoaDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	

	//Inicio SAVE
	public void save(Pessoa pessoa) {

		String sql = "INSERT INTO PESSOA (senha, nomePessoa, dataNascimento, sexo, email, telefone, idEndereco, idPermissao)" + " VALUES(?,?,?,?,?,?,?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pessoa.getSenha());
			pstm.setString(2, pessoa.getNomePessoa());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(pessoa.getDataNascimento()).getTime()));
			pstm.setString(4, String.valueOf(pessoa.getSexo()));
			pstm.setString(5, pessoa.getEmail());
   			pstm.setString(6, pessoa.getTelefone());
   			pstm.setInt(7, pessoa.getEndereco().getIdEndereco());
   			pstm.setInt(8, pessoa.getPermissao().getIdPermissao());
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
	public List<Pessoa> getPessoaList() {

		String sql = "SELECT * FROM PESSOA";

		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		ResultSet rset = null;
		
		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pessoa pessoa = new Pessoa();
				Endereco endereco = new Endereco();
				Permissao permissao = new Permissao();
				
				pessoa.setIdPessoa(rset.getInt("idPessoa"));				
				pessoa.setSenha(rset.getString("senha"));			
				pessoa.setNomePessoa(rset.getString("nomePessoa"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				pessoa.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
				pessoa.setSexo(rset.getString("sexo").charAt(0));				
				pessoa.setEmail(rset.getString("email"));
				pessoa.setTelefone(rset.getString("telefone"));
				endereco.setIdEndereco(rset.getInt("idEndereco"));
				pessoa.setEndereco(endereco);
				permissao.setIdPermissao(rset.getInt("idPermissao"));
				pessoa.setPermissao(permissao);

               	
				listaPessoa.add(pessoa);
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
		return listaPessoa;
	}

	//Inicio UPDATE
		public void update(Pessoa pessoa) {
			String sql = "UPDATE PESSOA SET senha = ?, nomePessoa= ?, dataNascimento= ?, sexo= ?, email= ?, telefone= ?, idEndereco=?, IdPermissao= ?" + "WHERE idPessoa = ?";

			try {
				conn = ConexaoMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, pessoa.getSenha());
				pstm.setString(2, pessoa.getNomePessoa());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				pstm.setDate(3, new Date(formatter.parse(pessoa.getDataNascimento()).getTime()));
				pstm.setString(4, String.valueOf(pessoa.getSexo()));
				pstm.setString(5, pessoa.getEmail());
	   			pstm.setString(6, pessoa.getTelefone());
	   			pstm.setInt(7, pessoa.getEndereco().getIdEndereco());
	   			pstm.setInt(8, pessoa.getPermissao().getIdPermissao());
	   			pstm.setInt(9, pessoa.getIdPessoa());
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

		String sql = "DELETE FROM PESSOA" + " WHERE idPessoa = ?";

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
	public Pessoa getPessoaById(int id) {

		String sql = "SELECT * FROM PESSOA" + " WHERE idPessoa = ?";
		Pessoa pessoa = new Pessoa();
		Endereco endereco = new Endereco();
		Permissao permissao = new Permissao();

		ResultSet rset = null;

		try {

			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();
			pessoa.setIdPessoa(rset.getInt("idPessoa"));
			pessoa.setSenha(rset.getString("senha"));
			pessoa.setNomePessoa(rset.getString("nomePessoa"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			pessoa.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
			pessoa.setSexo(rset.getString("sexo").charAt(0));
			pessoa.setEmail(rset.getString("email"));
            pessoa.setTelefone(rset.getString("telefone"));
            endereco.setIdEndereco(rset.getInt("idEndereco"));
            pessoa.setEndereco(endereco);
            permissao.setIdPermissao(rset.getInt("idPermissao"));
            pessoa.setPermissao(permissao);            


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
		return pessoa;
	}


}
