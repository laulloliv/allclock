package Model;

public class Pagamento {

	private String idCliente;
	private String nomeCartao;
	private String numCartao;
	private String valCartao;
	private String codCartao;
	private String tipoPagamento;
	private String parcelas;

	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pagamento(String idCliente, String nomeCartao, String numCartao, String valCartao, String codCartao,
			String tipoPagamento, String parcelas) {
		super();
		this.idCliente = idCliente;
		this.nomeCartao = nomeCartao;
		this.numCartao = numCartao;
		this.valCartao = valCartao;
		this.codCartao = codCartao;
		this.tipoPagamento = tipoPagamento;
		this.parcelas = parcelas;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getValCartao() {
		return valCartao;
	}

	public void setValCartao(String valCartao) {
		this.valCartao = valCartao;
	}

	public String getCodCartao() {
		return codCartao;
	}

	public void setCodCartao(String codCartao) {
		this.codCartao = codCartao;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}

}
