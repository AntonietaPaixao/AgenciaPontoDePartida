package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Permissao;

public class PermissaoDAO {

    Connection conn = null;
	PreparedStatement pstm = null;

	
    public void save(Permissao permissao) {
		String sql = "INSERT INTO PERMISSOES (tipoPermissao)" + " VALUES(?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, permissao.getTipoPermissao());
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
	public List<Permissao> getPermissaoList(){
		
        String sql = "SELECT * FROM PERMISSOES";

		List<Permissao> listaPermissao = new ArrayList<Permissao>();
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Permissao permissao = new Permissao();

				permissao.setIdPermissao(rset.getInt("idPermissao"));
				permissao.setTipoPermissao(rset.getString("tipoPermissao"));
				listaPermissao.add(permissao);
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
		return listaPermissao;
	}


    //Inicio UPDATE
    public void update(Permissao permissao) {
		String sql = "UPDATE PERMISSOES SET tipoPermissao = ?" + " WHERE idPermissao = ?";

		try {
            conn = ConexaoMySQL.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
	        pstm.setString(1, permissao.getTipoPermissao());
	        pstm.setInt(2, permissao.getIdPermissao());
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
		String sql = "DELETE FROM PERMISSOES" + " WHERE idPremissao = ?";

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
        public Permissao getPermissaoById(int id) {
		String sql = "SELECT * FROM PERMISSOES" + " WHERE idPermissao = ?";

		Permissao permissao = new Permissao();
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			permissao.setIdPermissao(rset.getInt("idPermissao"));
			permissao.setTipoPermissao(rset.getString("tipoPermissao"));

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
		return permissao;
	}

}
