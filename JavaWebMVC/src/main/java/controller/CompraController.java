package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CompraDAO;
import model.Compra;
import model.Pessoa;
import model.ItensCompra;

@WebServlet(urlPatterns = { "/Compra", "/create-Compra", "/edit-Compra", "/update-Compra",
		"/delete-Compra" })
public class CompraController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CompraDAO compraDao = new CompraDAO();
	Compra compra = new Compra();
	Pessoa pessoa = new Pessoa();
	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
			
	public CompraController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/Compra":
			read(request, response);
			break;
		case "/create-Compra":
			create(request, response);
			break;
		case "/edit-Compra":
			edit(request, response);
			break;
		case "/update-Compra":
			update(request, response);
			break;
		case "/delete-Compra":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra> lista = compraDao.getCompraList();

		request.setAttribute("compra", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/Compra/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		compra.setValorCompra(Double.parseDouble(request.getParameter("valorCompra")));
		compra.setDataCompra(request.getParameter("datacompra"));
		compra.setQuantidadePacotes(Integer.parseInt(request.getParameter("quantidadePacotes")));
		pessoa.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
		compra.setPessoa(pessoa);
		compra.setItensCompra(itensCompra);

		compraDao.save(compra);
		response.sendRedirect("compra");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		compra.setIdCompra(Integer.parseInt(request.getParameter("idCompra")));
		compra.setValorCompra(Double.parseDouble(request.getParameter("valorCompra")));
		compra.setDataCompra(request.getParameter("datacompra"));
		compra.setQuantidadePacotes(Integer.parseInt(request.getParameter("quantidadePacotes")));
		pessoa.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
		compra.setPessoa(pessoa);
		compra.setItensCompra(itensCompra);

		compraDao.update(compra);
		response.sendRedirect("compra");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCompra = Integer.parseInt(request.getParameter("idCompra"));
		compra = compraDao.getCompraById(idCompra);
		request.setAttribute("idCompra", compra.getIdCompra());
		request.setAttribute("valorCompra", compra.getValorCompra());
		request.setAttribute("dataCompra", compra.getDataCompra());
		request.setAttribute("quantidadePacotes", compra.getQuantidadePacotes());
		request.setAttribute("idPessoa", compra.getPessoa());
		request.setAttribute("idItensCompra", compra.getItensCompra());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Compra/update.jsp");
		rd.forward(request, response);
	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCompra = Integer.parseInt(request.getParameter("idCompra"));
		compraDao.deleteById(idCompra);
		response.sendRedirect("compra");
	}
}