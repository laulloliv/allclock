package Model;

public class Endereco {

	private String idCliente;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private String estado;	

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Endereco(String idCliente, String logradouro, String cep, String numero, String cidade, String estado) {
		super();
		this.idCliente = idCliente;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}


	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
