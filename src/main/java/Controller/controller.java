package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.Endereco;
import Model.JavaBeans;
import Model.Pagamento;
import Model.Pedido;
import Model.User;

/**
 * Servlet implementation class controller
 */
@WebServlet(urlPatterns = {"/controller", "/main", "/home", "/index", "/userDataUpdate", "/userUpdEndereco", "/userload", "/buyEnd", "/user", "/buy", "/buyPag", "/buyFinal", "/cadastro", "/login"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Criar o objeto para conexão com o banco de dados
	DAO dao = new DAO();
	//Criar o objeto javabeans
	JavaBeans cliente = new JavaBeans();
	//Criar o objeto user
	User user = new User();

    /**
     * Default constructor. 
     */
    public controller() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
		String action = request.getServletPath();
		
		if (action.equals("/buy")) {
			selectBuy(request, response);
		} else if (action.equals("/main")) {
			goMain(request, response);
		} else if (action.equals("/buyEnd")) {
			endBuy(request, response);
		}else if (action.equals("/user")) {
			loginUser(request, response);
		}else if (action.equals("/buyPag")) {
			pagBuy(request, response);
		} else if (action.equals("/buyFinal")) {
			finalBuy(request, response);
		}else if (action.equals("/login")) {
			areaUser(request, response);
		}else if (action.equals("/cadastro")) {
			cad(request, response);
		}else if (action.equals("/userload")) {
			cancelaPedido(request, response);
		}else if (action.equals("/userDataUpdate")) {
			updDados(request, response);
		}else if (action.equals("/userUpdEndereco")) {
			updEndereco(request, response);
		}
		else {
			goMain(request, response);
		}
	}
	
	protected void selectBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.sendRedirect("buy.jsp");
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.sendRedirect("login.jsp");
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Inserir os dados dor form no objeto JavaBeans
		
		user.setUsername(request.getParameter("email"));
		user.setPassword(request.getParameter("senha"));
		cliente.setEmail(request.getParameter("email"));
				
		//Invocar o método ler
		dao.fazerLogin(user, dao.listarCliente(cliente), dao.listarClienteEndereco(cliente), dao.listarPedido(cliente), request, response);
		
	}
	
	protected void areaUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Inserir os dados dor form no objeto JavaBeans
		
		System.out.println(request.getParameter("nome"));
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		
		//Invocar o método inserir
		dao.criarCliente(cliente);
		
		//Redirecionara para uma página
		response.sendRedirect("login.jsp");
	}
	
	
	
	protected void updDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("email"));
		
		//Inserir dados
		cliente.setEmail(request.getParameter("email"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setNome(request.getParameter("nome"));
				
		//Invocar método UPDATE
		dao.updCliente(cliente);

		ArrayList<String> updlista = dao.listarCliente(cliente);
		@SuppressWarnings("unused")
		ArrayList<String> pedido = dao.listarPedido(cliente);
		
		boolean arr = pedido.isEmpty();
		
		//Redirecionar rota
		HttpSession sessao = request.getSession();
		sessao.setAttribute("nome", updlista.get(0));
		sessao.setAttribute("cpf", updlista.get(3));
		sessao.setAttribute("email", updlista.get(1));
		sessao.setAttribute("telefone", updlista.get(4));
		sessao.setAttribute("pedido", (arr != true) ? false: true);
		response.sendRedirect("user.jsp");

	}
	
	protected void updEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("email"));
		
		@SuppressWarnings("unused")
		Endereco updEndereco = new Endereco(request.getParameter("email"),request.getParameter("logradouro"), 
				request.getParameter("cep"), request.getParameter("numero"), request.getParameter("cidade"),
				request.getParameter("estado"));
		
		//Inserir dados
		cliente.setEndereco(updEndereco);
		cliente.setEmail(request.getParameter("email"));
				
		//Invocar método UPDATE
		dao.updEndereco(cliente);

		ArrayList<String> updlista = dao.listarCliente(cliente);
		@SuppressWarnings("unused")
		ArrayList<String> updlistaEnd = dao.listarClienteEndereco(cliente);
		@SuppressWarnings("unused")
		ArrayList<String> pedido = dao.listarPedido(cliente);
		
		boolean arr = pedido.isEmpty();
		
		//Redirecionar rota
		HttpSession sessao = request.getSession();
		sessao.setAttribute("nome", updlista.get(0));
		sessao.setAttribute("cpf", updlista.get(3));
		sessao.setAttribute("email", updlista.get(1));
		sessao.setAttribute("telefone", updlista.get(4));		
		sessao.setAttribute("logradouro", updlistaEnd.get(0));
		sessao.setAttribute("cep", updlistaEnd.get(1));
		sessao.setAttribute("numero", updlistaEnd.get(2));
		sessao.setAttribute("cidade", updlistaEnd.get(3));
		sessao.setAttribute("estado", updlistaEnd.get(4));
		sessao.setAttribute("pedido", (arr != true) ? false : true);
		response.sendRedirect("user.jsp");

	}
	
	
	protected void cad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("cadastro.jsp");
	}
	
	protected void goMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("index.jsp");
	}
	
	
	
	protected void cancelaPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//Inserir dados
		cliente.setEmail(request.getParameter("email"));
		
		//Invocar método DELETE
		dao.deletarPedido(cliente, request, response);
		
	}
	
	
	
	
	protected void endBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// Inserir os dados dor form no objeto JavaBeans
		
		Pedido pedido = new Pedido(request.getParameter("idPedido"), request.getParameter("iProd"), request.getParameter("iQtd"), request.getParameter("iTotal"));
		cliente.setPedido(pedido);
		//Invocar o método inserir
		dao.criarPedido(cliente);
						
		//Redirecionara para uma página
		HttpSession sessao = request.getSession();
		sessao.setAttribute("idPedido", cliente.getPedido().getIdPedido());
		sessao.setAttribute("total", cliente.getPedido().getTotal());
		response.sendRedirect("buyEnd.jsp");
	}
	
	protected void pagBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Endereco endereco = new Endereco(request.getParameter("email"),request.getParameter("logradouro"),
				request.getParameter("cep"), request.getParameter("numero"), request.getParameter("cidade"),
				request.getParameter("estado"));
		
		// Inserir os dados dor form no objeto JavaBeans
		
		cliente.setEndereco(endereco);
		
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		
		
		//Invocar o método inserir
		dao.criarEndereco(cliente);
		dao.updPedido(cliente);
		dao.updCliente(cliente);
				
		//Redirecionara para uma página
			HttpSession sessao = request.getSession();
			sessao.setAttribute("email", cliente.getEmail());
			sessao.setAttribute("total", cliente.getPedido().getTotal());
			response.sendRedirect("buyPag.jsp");
	}

	protected void finalBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Inserir os dados dor form no objeto JavaBeans
		
		Pagamento pagamento = new Pagamento(request.getParameter("email"), request.getParameter("numCartao"),
				request.getParameter("nomeCartao"),request.getParameter("validade"),request.getParameter("codCartao"),
				request.getParameter("tipoPagamento"),request.getParameter("parcelas"));
				
		cliente.setPagamento(pagamento);
		cliente.setEmail(request.getParameter("email"));
		@SuppressWarnings("unused")
		ArrayList<String> endereco = dao.listarClienteEndereco(cliente);
		@SuppressWarnings("unused")
		ArrayList<String> pedido = dao.listarPedido(cliente);
		
		//Invocar o método inserir
		dao.criarPagamento(cliente);
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("email", cliente.getEmail());
		sessao.setAttribute("logradouro", endereco.get(0));
		sessao.setAttribute("numero", endereco.get(1));
		sessao.setAttribute("cep", endereco.get(2));
		sessao.setAttribute("tipoPagamento", pagamento.getTipoPagamento());
		sessao.setAttribute("parcelas", pagamento.getParcelas());
		sessao.setAttribute("produto", pedido.get(1));
		sessao.setAttribute("qtdProduto", pedido.get(2));
		sessao.setAttribute("total", pedido.get(3));
		response.sendRedirect("buyFinal.jsp");
		
	}

}
