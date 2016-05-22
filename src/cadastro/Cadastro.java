/**
 * Classe para implementação do Cadastro
 */
package cadastro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Cadastro {	
	public static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>(); //CPF
	public static HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>(); //Cod
	public static HashMap<Integer, Venda> vendas = new HashMap<Integer, Venda>(); //Cod
	public static ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
	
	/**
	 * @param Cliente
	 */
	public void incluirCliente(Cliente cli) {
		clientes.put(cli.getCpf(), cli);
	}
	
	/**
	 * @param Cliente
	 */
	public void excluirCliente(Cliente cli) {
		clientes.remove(cli);
	} 
	
	/**
	 * @param cpf
	 * @return 1 Cliente com o CPF
	 * @throws SisVendasException
	 */
	public Cliente clientePeloCPF(String cpf) throws SisVendasException {
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf);
		} else {
			throw new SisVendasException("Não existe cliente para o cpf");
		}
	}
	
	/**
	 * @param nome
	 * @return Clientes com o nome
	 * @throws SisVendasException
	 */
	public ArrayList<Cliente> clientesAlfabeticamente(String nome) throws SisVendasException {
		if (clientes.containsValue(nome)) {
			return (ArrayList<Cliente>) clientes.values();
		} else {
			throw new SisVendasException("Não existe nenhum cliente para o nome");
		}
	}
	
	/**
	 * @param Produto
	 */
	public void incluirProduto(Produto pro) {
		produtos.put(pro.getCodigo(), pro);
	}
	
	
	/**
	 * @param Produto
	 */
	public void excluirProduto(Produto pro) {
		produtos.remove(pro);
	} 
	
	/**
	 * @param cod
	 * @return Produto do codigo
	 * @throws SisVendasException
	 */
	public Produto produtoPeloCod(Integer cod) throws SisVendasException {
		if (produtos.containsKey(cod)) {
			return produtos.get(cod);
		} else {
			throw new SisVendasException("Não existe produto para o código");
		}
	}
	
	/**
	 * @param nome
	 * @return Produtos com o nome
	 * @throws SisVendasException
	 */
	public ArrayList<Produto> produtosAlfabeticamente(String nome) throws SisVendasException {
		ArrayList<Produto> prod = new ArrayList<Produto>();
		for (Produto produto : produtos.values()) {
			if (produto.getNome().contains(nome))
				prod.add(produto);
		}
		
		if(prod.isEmpty())
			throw new SisVendasException("Não existe nenhum produto para o nome");
		else
			return prod;
	}
	
	/**
	 * @param Venda
	 */
	public void incluirVenda(Venda ven) {
		vendas.put(ven.getNumVenda(), ven);
	}
	
	/**
	 * @param Venda
	 */
	public void excluirVenda(Venda ven) {
		vendas.remove(ven.getNumVenda());
	} 
	
	/**
	 * @param cod
	 * @return Vendas pelo codigo
	 * @throws SisVendasException
	 */
	public Venda vendaPeloCod(Integer cod) throws SisVendasException {
		if (vendas.containsKey(cod)) {
			return vendas.get(cod);
		} else {
			throw new SisVendasException("Não existe venda para o código");
		}
	}
	
	public ArrayList<Venda> vendasDoClienteOrderDataDesc(Cliente cli) throws SisVendasException {
		ArrayList<Venda> retorno = new ArrayList<Venda>();
		for (Venda item : retorno) {
			if (item.getCliente().getCpf().equals(cli.getCpf()))
				retorno.add(item);
		}
		
		Collections.sort(retorno);
		
		if(retorno.equals(null))
			return retorno;
		else
			throw new SisVendasException("Não existe nenhuma venda para o cliente");
	}
	
	public ArrayList<Venda> vendasPorPeriodoOrderNomeDataDesc(GregorianCalendar inicio, GregorianCalendar termino)	{
		ArrayList<Venda> retorno = new ArrayList<Venda>();
		for (Venda item : retorno) {
			if (item.getDataVenda().after(inicio) && item.getDataVenda().before(termino))
				retorno.add(item);
		}
			
		Collections.sort(retorno);
		
		return retorno;
	}
	
	public String vendasPorClienteOrderClienteAsc(GregorianCalendar inicio, GregorianCalendar termino) {
		//SELECT nome, COUNT(1), venda_total FROM venda JOIN cliente ON cliente.id = venda.cliente_id WHERE dt_venda BETWEEN inicio AND termino ORDER BY nome;
		String nome = null;
		int cont = 0;
		double total = 0;
		ArrayList<Venda> retorno = new ArrayList<>();
		for (Venda item : retorno) {
			if (item.getDataVenda().after(inicio) && item.getDataVenda().before(termino)) {
				nome = item.getCliente().getNome();
				cont++;
				total += produtos.get(item.getVendaItens()).getPrecoUnitario(); 
			}
		}
		
		return String.format("Cliente: %1$s - Quantidade que comprou: %2$s - Total das compras: %3$s", nome, cont, total);	
	}
	
	public static void IncluirItemVenda(ItemVenda item){
		itensVenda.add(item);
	}
}
