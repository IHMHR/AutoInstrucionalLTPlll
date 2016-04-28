/**
 * Classe contendo atributos e metodos de Vendas
 */
package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Venda {	
	
	private static int sequentialId = 0;
	
	private int numVenda;
	private Cliente cliente;
	private GregorianCalendar dataVenda;
	private ArrayList<ItemVenda> vendaItens;
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda, ArrayList<ItemVenda> vendaItens) {
		super();
		this.numVenda = sequentialId;
		this.cliente = cliente;
		this.dataVenda = dataVenda;
		this.vendaItens = vendaItens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public int getNumVenda() {
		return numVenda;
	}

	@Override
	public String toString() {
		return "Dados da Venda \nnumVenda=" + numVenda + ", cliente=" + cliente + ", dataVenda=" + dataVenda;
	}
}
