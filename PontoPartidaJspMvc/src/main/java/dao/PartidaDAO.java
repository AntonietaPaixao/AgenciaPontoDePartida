package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Partida;

public class PartidaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Inicio SAVE
	public void save(Partida partida) {

		String sql = "INSERT INTO PARTIDA (data, nomeCampeonato, timeCasa, timeVisitante)" + " VALUES(?,?,?,?)";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(1, new Date(formatter.parse(partida.getData()).getTime()));
			pstm.setString(2, partida.getNomeCampeonato());
			pstm.setString(3, partida.getTimeCasa());
			pstm.setString(4, partida.getTimeVisitante());
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
	public List<Partida> getPartidaList() {

		String sql = "SELECT * FROM PARTIDA";
		List<Partida> listaPartida = new ArrayList<Partida>();
		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Partida partida = new Partida();

				partida.setIdPartida(rset.getInt("idPartida"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				partida.setData(dateFormat.format(rset.getDate("data")));
				partida.setNomeCampeonato(rset.getString("nomeCampeonato"));
				partida.setTimeCasa(rset.getString("timeCasa"));
				partida.setTimeVisitante(rset.getString("timeVisitante"));

				listaPartida.add(partida);
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
		return listaPartida;
	}

	// Inicio UPDATE
	public void update(Partida partida) {
		String sql = "UPDATE PARTIDA SET data = ?, nomeCampeonato=?, timeCasaidade=?, timeConvidado=?"
				+ "WHERE idPartida = ?";

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(1, new Date(formatter.parse(partida.getData()).getTime()));
			pstm.setString(2, partida.getNomeCampeonato());
			pstm.setString(3, partida.getTimeCasa());
			pstm.setString(4, partida.getTimeVisitante());
			pstm.setInt(5, partida.getIdPartida());
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
	public void deleteById(int id) {

		String sql = "DELETE FROM PARTIDA WHERE idPartida = ?";

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

	// Inicio GET
	public Partida getPartidaById(int id) {

		String sql = "SELECT * FROM PARTIDA WHERE idPartida = ?";
		Partida partida = new Partida();

		ResultSet rset = null;

		try {
			conn = ConexaoMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			partida.setIdPartida(rset.getInt("idPartida"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			partida.setData(dateFormat.format(rset.getDate("data")));
			partida.setNomeCampeonato(rset.getString("nomeCampeonato"));
			partida.setTimeCasa(rset.getString("timeCasa"));
			partida.setTimeVisitante(rset.getString("timeVisitante"));

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
		return partida;
	}

}
