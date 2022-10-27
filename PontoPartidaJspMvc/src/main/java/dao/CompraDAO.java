package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Compra;
import model.Pessoa;

public class CompraDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Inicio SAVE
	public void save(Compra compra) {

//DUVIDA: Qual o atributo eu uso para salvar um objeto do tipo list, no Banco de dados?			
		String sql = "INSERT INTO COMPRA (valorCompra, dataCompra, quantidadePacotes, idPessoa" /**idItensCompra???**/ +")" +" VALUES(?,?,?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, compra.getValorCompra());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(compra.getDataCompra()).getTime()));
			pstm.setInt(3, compra.getQuantidadePacotes());
			pstm.setInt(4, compra.getPessoa().getIdPessoa());
//DUVIDA: Como se salva lista de Itens no Banco de dados?			
			//pstm.setInt(5, compra.getIitensCompra().?????????);
			
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

	
	// Inicio LIST
	public List<Compra> getCompraList() {

		String sql = "SELECT * FROM COMPRA";

		List<Compra> listaCompra = new ArrayList<Compra>();

		ResultSet rset = null;
		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Compra compra = new Compra();
				Pessoa pessoa = new Pessoa();
//DUVIDA: Como se restaura um objeto do tipo List, do banco de dados?					
				//List<Compra> itensCompra = new ArrayList<Compra>()

				compra.setIdCompra(rset.getInt("idCompra"));
				compra.setValorCompra(rset.getDouble("valorCompra"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				compra.setDataCompra(dateFormat.format(rset.getDate("dataCompra")));
				compra.setQuantidadePacotes(rset.getInt("quantidadePacotes"));
				pessoa.setIdPessoa(rset.getInt("idPessoa"));
				compra.setPessoa(pessoa);
//DUVIDA: Como se restaura um objeto do tipo List, do banco de dados? Pelo ID?			
				//itensCompra.setIdItensCompra(rset.getInt("idItensCompra"));
				//compra.setItensCompra("itensCompra");

				listaCompra.add(compra);
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
		return listaCompra;
	}

	
	// Inicio UPDATE
	public void update(Compra compra) {
		String sql = "UPDATE Compra SET valorCompra = ?, dataCompra = ?, quantidadePacotes = ? idPessoa = ?" /**idItensCompra = ?**/ +"WHERE idCompra = ?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, compra.getValorCompra());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(compra.getDataCompra()).getTime()));
			pstm.setInt(3, compra.getQuantidadePacotes());
			pstm.setInt(4, compra.getPessoa().getIdPessoa());
//DUVIDA: Como se salva um objeto do tipo List no Banco de dados? Pelo ID?			
			//pstm.setInt(5, compra.getIitensCompra().getIdItensCompra());		
//DUVIDA: Como eu vou fazer para alterar (Adicionar ou remover) os itens de compra?	Pelos métodos de adicionar e remover?

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

	
	// Inicio DELETE
	public void deleteById(int idCompra) {

		String sql = "DELETE FROM COMPRA" + " WHERE idCompra = ?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCompra);
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
	public Compra getCompraById(int idCompra) {

		String sql = "SELECT * FROM Compra where idCompra = ?";
		Compra compra = new Compra();
		Pessoa pessoa = new Pessoa();

		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCompra);
			rset = pstm.executeQuery();
			rset.next();

			compra.setValorCompra(rset.getInt("valorCompra"));
			compra.setDataCompra(rset.getString("dataCompra"));
			compra.setQuantidadePacotes(rset.getInt("quantidadePacotes"));
			pessoa.setIdPessoa(rset.getInt("idPessoa"));	
			compra.setPessoa(pessoa);
//DUVIDA: Como se restaura um objeto do tipo List, do banco de dados? Pelo ID?			
			//itensCompra.setIdItensCompra(rset.getInt("idItensCompra"));
			//compra.setItensCompra("itensCompra");

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
		return compra;
	}

}