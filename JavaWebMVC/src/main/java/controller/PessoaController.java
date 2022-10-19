package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.Pessoa;
import model.Endereco;
import model.Permissao;


@WebServlet(urlPatterns = {"/Pessoa", "/create-Pessoa", "/edit-Pessoa", "/update-Pessoa", "/delete-Pessoa"})
public class PessoaController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	PessoaDAO pessoaDao = new PessoaDAO();
	Pessoa pessoa = new Pessoa();
	Endereco endereco = new Endereco();
	Permissao permissao = new Permissao();

	
	public PessoaController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/Pessoa":
			read(request, response);
			break;
		case "/create-Pessoa":
			create(request, response);
			break;
		case "/edit-Pessoa":
			edit(request, response);
			break;
		case "/update-Pessoa":
			update(request, response);
			break;
		case "/delete-Pessoa":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pessoa> lista = pessoaDao.getPessoaList();
		
		request.setAttribute("pessoa", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Pessoa/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		pessoa.setCpf(request.getParameter("cpf"));
		pessoa.setNomePessoa(request.getParameter("nomePessoa"));
		pessoa.setDataNascimento(request.getParameter("dataNascimento"));
		pessoa.setSexo(request.getParameter("sexo").charAt(0));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setTelefone(request.getParameter("telefone"));
		endereco.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
		pessoa.setEndereco(endereco);
		permissao.setIdPermissao(Integer.parseInt(request.getParameter("idPermissao")));
		pessoa.setPermissao(permissao);

		pessoaDao.save(pessoa);
		response.sendRedirect("pessoa");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pessoa.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
		pessoa.setCpf(request.getParameter("cpf"));
		pessoa.setNomePessoa(request.getParameter("nomePessoa"));
		pessoa.setDataNascimento(request.getParameter("dataNascimento"));
		pessoa.setSexo(request.getParameter("sexo").charAt(0));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setTelefone(request.getParameter("telefone"));
		endereco.setIdEndereco(Integer.parseInt(request.getParameter("idEndereco")));
		pessoa.setEndereco(endereco);
		permissao.setIdPermissao(Integer.parseInt(request.getParameter("idPermissao")));
		pessoa.setPermissao(permissao);

	pessoaDao.update(pessoa);
	response.sendRedirect("pessoa");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
		pessoa = pessoaDao.getPessoaById(idPessoa);
		request.setAttribute("idPessoa", pessoa.getIdPessoa());
		request.setAttribute("cpf", pessoa.getCpf());
		request.setAttribute("nomePessoa", pessoa.getNomePessoa());
		request.setAttribute("dataNascimento", pessoa.getDataNascimento());
		request.setAttribute("email", pessoa.getEmail());
		request.setAttribute("telefone", pessoa.getTelefone());
		request.setAttribute("sexo", pessoa.getSexo());
		request.setAttribute("idEndereco", pessoa.getEndereco());
		request.setAttribute("idPermissao", pessoa.getPermissao());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Pessoa/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
		pessoaDao.deleteById(idPessoa);
		response.sendRedirect("pessoa");
}
}