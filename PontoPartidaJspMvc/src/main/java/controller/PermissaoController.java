package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PermissaoDAO;
import model.Permissao;


@WebServlet(urlPatterns = {"/Permissao", "/create-Permissao", "/edit-Permissao", "/update-Permissao", "/delete-Permissao"})
public class PermissaoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	PermissaoDAO PermissaoDao = new PermissaoDAO();
	Permissao Permissao = new Permissao();
	
	public PermissaoController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/Permissao":
			read(request, response);
			break;
		case "/create-Permissao":
			create(request, response);
			break;
		case "/edit-Permissao":
			edit(request, response);
			break;
		case "/update-Permissao":
			update(request, response);
			break;
		case "/delete-Permissao":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("indexPermissao.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Permissao> lista = PermissaoDao.getPermissaoList();
		
		request.setAttribute("permissao", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Permissao/indexPermissao.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Permissao.setTipoPermissao(request.getParameter("tipoPermissao"));
		PermissaoDao.save(Permissao);
		response.sendRedirect("Permissao");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Permissao.setIdPermissao(Integer.parseInt(request.getParameter("idPermissao")));
	Permissao.setTipoPermissao(request.getParameter("tipoPermissao"));
	PermissaoDao.update(Permissao);
	response.sendRedirect("Permissao");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idPermissao = Integer.parseInt(request.getParameter("idPermissao"));
		Permissao = PermissaoDao.getPermissaoById(idPermissao);
		request.setAttribute("idPermissao", Permissao.getIdPermissao());
		request.setAttribute("tipoPermissao", Permissao.getTipoPermissao());
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Permissao/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPermissao = Integer.parseInt(request.getParameter("idPermissao"));
		PermissaoDao.deleteById(idPermissao);
		response.sendRedirect("Permissao");
}
}