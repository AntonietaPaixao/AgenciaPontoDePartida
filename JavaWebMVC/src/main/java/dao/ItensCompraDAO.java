package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.ItensCompra;
import model.PacotePartida;


public class ItensCompraDAO {

    Connection conn = null;
	PreparedStatement pstm = null;

	//Inicio SAVE
    public void save(ItensCompra itensCompra) {
		String sql = "INSERT INTO PERMISSOES (idPacotePartida, quantidade)" + " VALUES(?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, itensCompra.getPacotePartida().getIdPacotePartida());
			pstm.setInt(2, itensCompra.getQuantidade());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public List<ItensCompra> getItensCompraList(){
		
        String sql = "SELECT * FROM ITENSCOMPRA";

		List<ItensCompra> listaItensCompra = new ArrayList<ItensCompra>();
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				ItensCompra itensCompra = new ItensCompra();
				PacotePartida pacotePartida = new PacotePartida();

				itensCompra.setIdItensCompra(rset.getInt("idItensCompra"));
				pacotePartida.setIdPacotePartida(rset.getInt("idPacotePartida"));
				itensCompra.setPacotePartida(pacotePartida);
				itensCompra.setQuantidade(rset.getInt("quantidade"));

				listaItensCompra.add(itensCompra);
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
		return listaItensCompra;
	}


    //Inicio UPDATE
    public void update(ItensCompra itensCompra) {
		String sql = "UPDATE ITENSCOMPRA SET IdPacotePartida = ?, quantidade = ?" + " WHERE idItensCompra = ?";

		try {
            conn = ConexaoMySQL.createConnectionToMySQL();
            
			pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, itensCompra.getPacotePartida().getIdPacotePartida());
	        pstm.setInt(2, itensCompra.getQuantidade());
   			pstm.setInt(9, itensCompra.getIdItensCompra());
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
		String sql = "DELETE FROM ITENSCOMPRA" + " WHERE idItensCompra = ?";

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
    public ItensCompra getItensCompraById(int id) {
    	
		String sql = "SELECT * FROM ITENSCOMPRA" + " WHERE idItensCompra = ?";
		ItensCompra itensCompra = new ItensCompra();
		PacotePartida pacotePartida = new PacotePartida();
		
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			itensCompra.setIdItensCompra(rset.getInt("idItensCompra"));
			pacotePartida.setIdPacotePartida(rset.getInt("idPacotePartida"));
			itensCompra.setPacotePartida(pacotePartida);
			itensCompra.setQuantidade(rset.getInt("quantidade"));

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
		return itensCompra;
	}

}
