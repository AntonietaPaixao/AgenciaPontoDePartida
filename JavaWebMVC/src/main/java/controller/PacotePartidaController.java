package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PacotePartidaDAO;
import model.PacotePartida;
import model.Partida;

@WebServlet(urlPatterns = { "/PacotePartida", "/create-PacotePartida", "/edit-PacotePartida", "/update-PacotePartida",
		"/delete-PacotePartida" })
public class PacotePartidaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PacotePartidaDAO pacotePartidaDao = new PacotePartidaDAO();
	PacotePartida pacotePartida = new PacotePartida();
	Partida partida = new Partida();

	public PacotePartidaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/PacotePartida":
			read(request, response);
			break;
		case "/create-PacotePartida":
			create(request, response);
			break;
		case "/edit-PacotePartida":
			edit(request, response);
			break;
		case "/update-PacotePartida":
			update(request, response);
			break;
		case "/delete-PacotePartida":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PacotePartida> lista = pacotePartidaDao.getPacotePartidaList();

		request.setAttribute("pacotePartida", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/PacotePartida/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pacotePartida.setNomePacote(request.getParameter("nomePacote"));
		pacotePartida.setDataSaida(request.getParameter("dataSaida"));
		pacotePartida.setDataRetorno(request.getParameter("dataRetorno"));
		pacotePartida.setValorPacote(Double.parseDouble(request.getParameter("valorPacote")));
		partida.setIdPartida(Integer.parseInt(request.getParameter("idPartida")));
		pacotePartida.setPartida(partida);

		pacotePartidaDao.save(pacotePartida);
		response.sendRedirect("pacotePartida");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pacotePartida.setIdPacotePartida(Integer.parseInt(request.getParameter("idPacotePartida")));
		pacotePartida.setNomePacote(request.getParameter("nomePacote"));
		pacotePartida.setDataSaida(request.getParameter("dataSaida"));
		pacotePartida.setDataRetorno(request.getParameter("dataRetorno"));
		pacotePartida.setValorPacote(Double.parseDouble(request.getParameter("valorPacote")));
		partida.setIdPartida(Integer.parseInt(request.getParameter("idPartida")));
		pacotePartida.setPartida(partida);

		pacotePartidaDao.update(pacotePartida);
		response.sendRedirect("pacotePartida");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idPacotePartida = Integer.parseInt(request.getParameter("idPacotePartida"));
		pacotePartida = pacotePartidaDao.getPacotePartidaById(idPacotePartida);
		request.setAttribute("idPacotePartida", pacotePartida.getIdPacotePartida());
		request.setAttribute("nomePacote", pacotePartida.getNomePacote());
		request.setAttribute("dataSaida", pacotePartida.getDataSaida());
		request.setAttribute("dataRetorno", pacotePartida.getDataRetorno());
		request.setAttribute("valorPacote", pacotePartida.getValorPacote());
		request.setAttribute("idPartida", pacotePartida.getPartida());

		RequestDispatcher rd = request.getRequestDispatcher("./views/PacotePartida/update.jsp");
		rd.forward(request, response);
	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPacotePartida = Integer.parseInt(request.getParameter("idPacotePartida"));
		pacotePartidaDao.deleteById(idPacotePartida);
		response.sendRedirect("pacotePartida");
	}
}