package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PartidaDAO;
import model.Partida;


@WebServlet(urlPatterns = {"/Partida", "/create-Partida", "/edit-Partida", "/update-Partida", "/delete-Partida"})
public class PartidaController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	PartidaDAO partidaDao = new PartidaDAO();
	Partida partida = new Partida();
	
	public PartidaController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/Partida":
			read(request, response);
			break;
		case "/create-Partida":
			create(request, response);
			break;
		case "/edit-Partida":
			edit(request, response);
			break;
		case "/update-Partida":
			update(request, response);
			break;
		case "/delete-Partida":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("indexPartida.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Partida> lista = partidaDao.getPartidaList();
		
		request.setAttribute("partida", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Partida/indexPartida.html");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		partida.setData(request.getParameter("data"));
		partida.setNomeCampeonato(request.getParameter("nomeCampeonato"));
		partida.setTimeCasa(request.getParameter("timeCasa"));
		partida.setTimeVisitante(request.getParameter("timeVisitante"));

		partidaDao.save(partida);
		response.sendRedirect("partida");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	partida.setIdPartida(Integer.parseInt(request.getParameter("idPartida")));
	partida.setData(request.getParameter("data"));
	partida.setNomeCampeonato(request.getParameter("nomeCampeonato"));
	partida.setTimeCasa(request.getParameter("timeCasa"));
	partida.setTimeVisitante(request.getParameter("timeVisitante"));

	partidaDao.update(partida);
	response.sendRedirect("partida");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idPartida = Integer.parseInt(request.getParameter("idPartida"));
		partida = partidaDao.getPartidaById(idPartida);
		request.setAttribute("idPartida", partida.getIdPartida());
		request.setAttribute("data", partida.getData());
		request.setAttribute("nomeCampeonato", partida.getNomeCampeonato());
		request.setAttribute("timeCasa", partida.getTimeCasa());
		request.setAttribute("timeVisitante", partida.getTimeVisitante());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Partida/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPartida = Integer.parseInt(request.getParameter("idPartida"));
		partidaDao.deleteById(idPartida);
		response.sendRedirect("partida");
}
}