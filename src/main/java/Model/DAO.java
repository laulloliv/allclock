package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/allclock?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "@oliv31r4dba";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD CREATE */
	public void criarCliente(JavaBeans cliente) {

		String sql = "insert into cliente(nome,email,senha) values (?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getSenha());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	/*
	 * CRUD READ CLIENTE
	 */
	public ArrayList<String> listarCliente(JavaBeans oCliente) {

		ArrayList<String> cliente = new ArrayList<>();

		String read = "select * from cliente where email = (?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, oCliente.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String cNome = rs.getString("nome");
				String cEmail = rs.getString("email");
				String cSenha = rs.getString("senha");
				String cCpf = rs.getString("cpf");
				String cTelefone = rs.getString("telefone");
				

				Collections.addAll(cliente, cNome, cEmail, cSenha, cCpf, cTelefone);
			}
			
			con.close();

			return cliente;

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}
	
	/*
	 * CRUD READ ENDERECO
	 */
	public ArrayList<String> listarClienteEndereco(JavaBeans oCliente) {

		ArrayList<String> clienteEndereco = new ArrayList<>();

		String read = "select * from endereco where idCliente = (?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, oCliente.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String cLogradouro = rs.getString("logradouro");
				String cNumero = rs.getString("numero");
				String cCep = rs.getString("cep");
				String cCidade = rs.getString("cidade");
				String cEstado = rs.getString("estado");
				

				Collections.addAll(clienteEndereco, cLogradouro, cNumero, cCep, cCidade, cEstado);
			}
			
			con.close();

			return clienteEndereco;

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}
	
	/*
	 * CRUD READ PAGAMENTO
	 */
	public ArrayList<String> listarPedidoPagamento(JavaBeans oCliente) {

		ArrayList<String> pedidoPagamento = new ArrayList<>();

		String read = "select * from endereco where idCliente = (?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, oCliente.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String cNumCartao = rs.getString("numCartao");
				String cNomeCartao = rs.getString("nomeCartao");
				String cCodCartao = rs.getString("codCartao");
				String cValCartao = rs.getString("valCartao");
				String cTipoPagamento = rs.getString("tipoPagamento");
				String cParcelas = rs.getString("parcelas");
				

				Collections.addAll(pedidoPagamento, cNumCartao, cNomeCartao, cCodCartao, cValCartao, cTipoPagamento, cParcelas);
			}
			
			con.close();

			return pedidoPagamento;

		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}
	
	/*
	 * CRUD READ PEDIDO
	 */
	public ArrayList<String> listarPedido(JavaBeans cPedido) {

		ArrayList<String> pedido = new ArrayList<>();

		String read = "select * from pedido where idCliente = (?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, cPedido.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String cIdCliente = rs.getString("idCliente");
				String cProduto = rs.getString("produto");
				String cQtdProduto = rs.getString("qtdProduto");
				String cTotal = rs.getString("total");

				Collections.addAll(pedido, cIdCliente, cProduto, cQtdProduto, cTotal);
			}
			con.close();

			return pedido;
		

		} catch (Exception e) {

			System.out.println(e);
			return pedido;
		}
	}

	/*
	 * CRUD READ TO LOGIN
	 */
	public void fazerLogin(User user, ArrayList<String> cliente, ArrayList<String> endereco, ArrayList<String> pedido, HttpServletRequest request, HttpServletResponse response) {

		String read = "select email,senha from cliente where email = (?)";

		String username = "";
		String password = "";
		@SuppressWarnings("unused")
		boolean arr = pedido.isEmpty();
		String nada = "";
		

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			pst.setString(1, user.getUsername());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				username = rs.getString("email");
				password = rs.getString("senha");

			}

			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				System.out.println("WELCOME " + username);
				HttpSession sessao = request.getSession();
				
				//Dados Pessoais
				sessao.setAttribute("username", (username != null) ? username : nada);
				sessao.setAttribute("telefone", (cliente.get(4) != null) ? cliente.get(4) : "Telefone");
				sessao.setAttribute("nome", (cliente.get(0) != null) ? cliente.get(0) : nada);
				sessao.setAttribute("cpf", (cliente.get(3) != null) ? cliente.get(3) : "CPF");
				
				// Endereco
				sessao.setAttribute("logradouro", (endereco.isEmpty() != true) ? endereco.get(0) : "Logradouro");
				sessao.setAttribute("numero", (endereco.isEmpty() != true) ? endereco.get(2) : "Numero");
				sessao.setAttribute("cep", (endereco.isEmpty() != true) ? endereco.get(1) : "CEP");
				sessao.setAttribute("cidade", (endereco.isEmpty() != true) ? endereco.get(3) : "Cidade");
				sessao.setAttribute("estado", (endereco.isEmpty() != true) ? endereco.get(4) : "Estado");
				sessao.setAttribute("pedido", (arr == true) ? arr : null);
				response.sendRedirect("user.jsp");
				
				
			} else {
				response.sendRedirect("login.jsp");
			}

			con.close();
			return;	
			
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
			return;
		}
	}
	
	/*
	 * CRUD CREATE ENDERECO
	 */
	public void criarEndereco(JavaBeans cliente) {

		String sql = "INSERT INTO endereco(idCliente,logradouro,cep,numero,cidade,estado) VALUES (?,?,?,?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getEmail());
			pst.setString(2, cliente.getEndereco().getLogradouro());
			pst.setString(3, cliente.getEndereco().getCep());
			pst.setString(4, cliente.getEndereco().getNumero());
			pst.setString(5, cliente.getEndereco().getCidade());
			pst.setString(6, cliente.getEndereco().getEstado());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	
	/*
	 * CRUD UPDATE ENDERECO
	 */
	public void updEndereco(JavaBeans cliente) {

		String sql = "UPDATE endereco SET logradouro = (?), cep = (?), numero = (?), cidade = (?), estado = (?) WHERE idCliente = (?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getEndereco().getLogradouro());
			pst.setString(2, cliente.getEndereco().getNumero());
			pst.setString(3, cliente.getEndereco().getCep());
			pst.setString(4, cliente.getEndereco().getCidade());
			pst.setString(5, cliente.getEndereco().getEstado());
			pst.setString(6, cliente.getEmail());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	
	/*
	 * CRUD UPDATE CLIENTE
	 */
	public void updCliente(JavaBeans cliente) {

		String sql = "UPDATE cliente SET cpf = (?), telefone = (?), nome = (?) WHERE email = (?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getCpf());
			pst.setString(2, cliente.getTelefone());
			pst.setString(3, cliente.getNome());
			pst.setString(4, cliente.getEmail());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	
	
	/*
	 * CRUD UPDATE PEDIDO idCliente
	 */
	public void updPedido(JavaBeans cliente) {

		String sql = "UPDATE pedido SET idCliente = (?) WHERE idPedido = (?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getEmail());
			pst.setString(2, cliente.getPedido().getIdPedido());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	/*
	 * CRUD CREATE PEDIDO
	 */
	public void criarPedido(JavaBeans cliente) {

		String sql = "INSERT INTO pedido(idPedido,produto,qtdProduto,total) VALUES (?,?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getPedido().getIdPedido());
			pst.setString(2, cliente.getPedido().getProduto());
			pst.setString(3, cliente.getPedido().getQtdProduto());
			pst.setString(4, cliente.getPedido().getTotal());
			
			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	/*
	 * CRUD CREATE PAGAMENTO
	 */
	public void criarPagamento(JavaBeans cliente) {

		String sql = "INSERT INTO pagamento(idCliente,numCartao,nomeCartao,valCartao,codCartao,tipoPagamento,parcelas) VALUES (?,?,?,?,?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getEmail());
			pst.setString(2, cliente.getPagamento().getNumCartao());
			pst.setString(3, cliente.getPagamento().getNomeCartao());
			pst.setString(4, cliente.getPagamento().getValCartao());
			pst.setString(5, cliente.getPagamento().getCodCartao());
			pst.setString(6, cliente.getPagamento().getTipoPagamento());
			pst.setString(7, cliente.getPagamento().getParcelas());
			

			pst.executeUpdate();
			

			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	
	/*
	 * CRUD DELETE PEDIDO
	 */
	public void deletarPedido(JavaBeans cliente, HttpServletRequest request, HttpServletResponse response) {

		String sql = "DELETE from pedido WHERE idCliente = (?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getEmail());

			pst.executeUpdate();
			
			ArrayList<String> updlista = listarPedido(cliente);
			
			boolean arr = updlista.isEmpty(); 
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("pedido", arr);
			response.sendRedirect("user.jsp");

			con.close();


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		

	}


}
