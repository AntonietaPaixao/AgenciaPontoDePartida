package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EnderecoDAO;
import model.Endereco;


@WebServlet(urlPatterns = {"/Endereco", "/create-Endereco", "/edit-Endereco", "/update-Endereco", "/delete-Endereco"})
public class EnderecoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	EnderecoDAO EnderecoDao = new EnderecoDAO();
	Endereco Endereco = new Endereco();
	
	public EnderecoController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/Endereco":
			read(request, response);
			break;
		case "/create-Endereco":
			create(request, response);
			break;
		case "/edit-Endereco":
			edit(request, response);
			break;
		case "/update-Endereco":
			update(request, response);
			break;
		case "/delete-Endereco":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Endereco> lista = EnderecoDao.getEnderecoList();
		
		request.setAttribute("endereco", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Endereco/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Endereco.setCidade(request.getParameter("cidade"));
		Endereco.setEstadoUf(request.getParameter("estadoUf"));
		Endereco.setLogradouro(request.getParameter("logradouro"));
		Endereco.setBairro(request.getParameter("bairro"));
		Endereco.setNumero(request.getParameter("numero"));

		EnderecoDao.save(Endereco);
		response.sendRedirect("Endereco");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Endereco.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
	Endereco.setCidade(request.getParameter("cidade"));
	Endereco.setEstadoUf(request.getParameter("estadouf"));
	Endereco.setLogradouro(request.getParameter("logradouro"));
	Endereco.setBairro(request.getParameter("bairro"));
	Endereco.setNumero(request.getParameter("numero"));

	EnderecoDao.update(Endereco);
	response.sendRedirect("Endereco");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
		Endereco = EnderecoDao.getEnderecoById(idEndereco);
		request.setAttribute("idEndereco", Endereco.getIdEndereco());
		request.setAttribute("cidade", Endereco.getCidade());
		request.setAttribute("estadouf", Endereco.getEstadoUf());
		request.setAttribute("logradouro", Endereco.getLogradouro());
		request.setAttribute("bairro", Endereco.getBairro());
		request.setAttribute("numero", Endereco.getNumero());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Endereco/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
		EnderecoDao.deleteById(idEndereco);
		response.sendRedirect("Endereco");
}
}