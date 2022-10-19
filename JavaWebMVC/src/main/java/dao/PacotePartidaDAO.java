package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.PacotePartida;
import model.Partida;


public class PacotePartidaDAO {

    Connection conn = null;
	PreparedStatement pstm = null;

	//Inicio SAVE
    public void save(PacotePartida pacotePartida) {
		String sql = "INSERT INTO PACOTEPARTIDA (nomePacote, dataSaida, dataRetorno, valorPacote, idPartida)" + " VALUES(?,?,?,?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacotePartida.getNomePacote());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(pacotePartida.getDataSaida()).getTime()));
			pstm.setDate(3, new Date(formatter.parse(pacotePartida.getDataRetorno()).getTime()));
			pstm.setDouble(4, pacotePartida.getValorPacote());
			pstm.setInt(5, pacotePartida.getPartida().getIdPartida());			
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
	public List<PacotePartida> getPacotePartidaList(){
		
        String sql = "SELECT * FROM PACOTEPARTIDA";

		List<PacotePartida> listaPacotePartida = new ArrayList<PacotePartida>();
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				PacotePartida pacotePartida = new PacotePartida();
				Partida partida = new Partida();
				
				pacotePartida.setIdPacotePartida(rset.getInt("idPacotePartida"));
				pacotePartida.setNomePacote(rset.getString("nomePacote"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				pacotePartida.setDataSaida(dateFormat.format(rset.getDate("dataSaida")));
				pacotePartida.setDataRetorno(dateFormat.format(rset.getDate("dataRetorno")));
				pacotePartida.setValorPacote(rset.getInt("valorPacote"));
				partida.setIdPartida(rset.getInt("idPartida"));
				pacotePartida.setPartida(partida);


				listaPacotePartida.add(pacotePartida);
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
		return listaPacotePartida;
	}


    //Inicio UPDATE
    public void update(PacotePartida pacotePartida) {
		String sql = "UPDATE PACOTEPARTIDA SET nomePacote = ?, dataSaida = ?, dataRetorno = ?, valorPacote = ?, idPartida = ?" + " WHERE idPacotePartida = ?";

		try {
            conn = ConexaoMySQL.createConnectionToMySQL();
			
            pstm = conn.prepareStatement(sql);
	        pstm.setString(1, pacotePartida.getNomePacote());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(pacotePartida.getDataSaida()).getTime()));
			pstm.setDate(3, new Date(formatter.parse(pacotePartida.getDataRetorno()).getTime()));
			pstm.setDouble(4, pacotePartida.getValorPacote());
			pstm.setInt(5, pacotePartida.getPartida().getIdPartida());
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
		String sql = "DELETE FROM PACOTEPARTIDA" + "WHERE idPacotePartida = ?";

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
    public PacotePartida getPacotePartidaById(int id) {
    	
		String sql = "select * from PACOTEPARTIDA WHERE idPacotePartida = ?";
		
		PacotePartida pacotePartida = new PacotePartida();
		Partida partida = new Partida();
	
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			pacotePartida.setIdPacotePartida(rset.getInt("idPacotePartida"));
			pacotePartida.setNomePacote(rset.getString("nomePacote"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			pacotePartida.setDataSaida(dateFormat.format(rset.getDate("dataSaida")));
			pacotePartida.setDataSaida(dateFormat.format(rset.getDate("dataRetorno")));
			pacotePartida.setValorPacote(rset.getDouble("valorPacote"));
			partida.setIdPartida(rset.getInt("idPartida"));


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
		return pacotePartida;
	}

}
