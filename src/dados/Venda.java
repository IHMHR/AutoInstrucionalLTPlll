/**
 * Classe contendo atributos e metodos de Vendas
 */
package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Venda implements Serializable, Comparable<Venda> {	
	
	private static int sequentialId = 0;
	
	private int numVenda;
	

	private Cliente cliente;
	private GregorianCalendar dataVenda;
	private ArrayList<ItemVenda> vendaItens;
	
	/**
	 * @param cliente
	 * @param vendaItens
	 */
	public Venda(Cliente cliente, ArrayList<ItemVenda> vendaItens) {
		super();
		this.numVenda = sequentialId;
		this.cliente = cliente;
		this.dataVenda = new GregorianCalendar();
		this.vendaItens = vendaItens;
	}
	
	public static int getSequentialId() {
		return sequentialId;
	}

	public static void setSequentialId(int sequentialId) {
		Venda.sequentialId = sequentialId;
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
		return String.format("Dados da Venda: Número da venda = %1$s, Cliente = %2$s, Data da Venda = %3$s", numVenda, cliente.getNome(), LtpUtil.formatarData(dataVenda, "dd/MM/yyyy"));
	}

	@Override
	public int compareTo(Venda ven) {
		return cliente.getNome().compareTo(ven.cliente.getCpf());
	}
}
