/**
 * Classe contendo atributos e metodos de Itens das Vendas
 */
package dados;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acad�mico
 */
public class ItemVenda {
	private Produto produto;
	private double precoUnitario;
	private int quantVenda;
	private double valorVenda;
	
	public ItemVenda(Produto produto, double precoUnitario, int quantVenda, double valorVenda) {
		super();
		this.produto = produto;
		this.precoUnitario = precoUnitario;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return String.format("Dados dos Itens da Venda: Produto = %1$s, Pre�o Unit�rio = %2$s, Quantidade Venda = %3$s, Valor Venda = %4$s", produto, precoUnitario, quantVenda, valorVenda);
	}
}
