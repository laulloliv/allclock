package Model;

public class Pedido {
	
	private String idPedido;
	private String produto;
	private String qtdProduto;
	private String total;
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pedido(String idPedido, String produto, String qtdProduto, String total) {
		super();
		this.idPedido = idPedido;
		this.produto = produto;
		this.qtdProduto = qtdProduto;
		this.total = total;
	}



	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(String qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
