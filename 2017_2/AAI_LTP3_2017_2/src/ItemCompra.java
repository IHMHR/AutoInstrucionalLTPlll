public class ItemCompra
{
	private Produto produto;
	private int quantCompra;
	private double valorCompra;
	
	private ItemCompra(Produto _produto, int _quantCompra)
	{
		this.produto = _produto;
		this.quantCompra = _quantCompra;
		this.valorCompra = produto.getPrecoUnitario() * quantCompra;
	}
	
	private ItemCompra(Produto _produto, int _quantCompra, double _valorCompra)
	{
		this.produto = _produto;
		this.quantCompra = _quantCompra;
		this.valorCompra = _valorCompra;
	}

	public Produto getProduto()
	{
		return produto;
	}

	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}

	public int getQuantCompra()
	{
		return quantCompra;
	}

	public void setQuantCompra(int quantCompra)
	{
		this.quantCompra = quantCompra;
	}

	public double getValorCompra()
	{
		return valorCompra;
	}

	public void setValorCompra(double valorCompra)
	{
		this.valorCompra = valorCompra;
	}
	
	@Override
	public String toString()
	{
		return "ITEM DA COMPRA:\n" + produto.toString() + "\nQantidade: " + quantCompra + "\nValor: R$" + (valorCompra + "").replace(".", ",");
	}
}