package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ItensCompraDAO;
import model.ItensCompra;
import model.PacotePartida;

@WebServlet(urlPatterns = { "/ItensCompra", "/create-ItensCompra", "/edit-ItensCompra", "/update-ItensCompra",
		"/delete-ItensCompra" })
public class ItensCompraController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ItensCompraDAO itensCompraDao = new ItensCompraDAO();
	ItensCompra itensCompra = new ItensCompra();
	PacotePartida pacotePartida = new PacotePartida();

	public ItensCompraController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/ItensCompra":
			read(request, response);
			break;
		case "/create-ItensCompra":
			create(request, response);
			break;
		case "/edit-ItensCompra":
			edit(request, response);
			break;
		case "/update-ItensCompra":
			update(request, response);
			break;
		case "/delete-ItensCompra":
			delete(request, response);
			break;

		default:
			response.sendRedirect("indexItensCompra.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ItensCompra> lista = itensCompraDao.getItensCompraList();

		request.setAttribute("itensCompra", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/ItensCompra/indexItensCompra.html");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pacotePartida.setIdPacotePartida(Integer.parseInt(request.getParameter("idPacotePartida")));
		itensCompra.setPacotePartida(pacotePartida);
		itensCompra.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		itensCompraDao.save(itensCompra);
		response.sendRedirect("itensCompra");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		itensCompra.setIdItensCompra(Integer.parseInt(request.getParameter("idItensCompra")));
		pacotePartida.setIdPacotePartida(Integer.parseInt(request.getParameter("idPacotePartida")));
		itensCompra.setPacotePartida(pacotePartida);
		itensCompra.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		itensCompraDao.update(itensCompra);
		response.sendRedirect("itensCompra");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idItensCompra = Integer.parseInt(request.getParameter("idItensCompra"));
		itensCompra = itensCompraDao.getItensCompraById(idItensCompra);
		request.setAttribute("idItensCompra", itensCompra.getIdItensCompra());
		request.setAttribute("idPacotePartida", itensCompra.getPacotePartida());
		request.setAttribute("quantidade", itensCompra.getQuantidade());

		RequestDispatcher rd = request.getRequestDispatcher("./views/ItensCompra/update.jsp");
		rd.forward(request, response);
	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idItensCompra = Integer.parseInt(request.getParameter("idItensCompra"));
		itensCompraDao.deleteById(idItensCompra);
		response.sendRedirect("itensCompra");
	}
}