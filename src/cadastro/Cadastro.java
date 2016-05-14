/**
 * Classe para implementação do Cadastro
 */
package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import dados.Cliente;
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
	
	public void incluirCliente(Cliente cli) {
		clientes.put(cli.getCpf(), cli);
	}
	
	public void excluirCliente(Cliente cli) {
		clientes.remove(cli);
	} 
	
	public ArrayList<Cliente> clientePeloCPF(String cpf) throws SisVendasException {
		if (clientes.containsKey(cpf)) {
			return (ArrayList<Cliente>) clientes.values();
		} else {
			throw new SisVendasException("Não existe cliente para o cpf");
		}
	}
	
	public ArrayList<Cliente> clientesAlfabeticamente(String nome) throws SisVendasException {
		if (clientes.containsValue(nome)) {
			return (ArrayList<Cliente>) clientes.values();
		} else {
			throw new SisVendasException("Não existe nenhum cliente para o nome");
		}
	}
	
	public void incluirProduto(Produto pro) {
		produtos.put(pro.getCodigo(), pro);
	}
	
	public void excluirProduto(Produto pro) {
		produtos.remove(pro);
	} 
	
	public ArrayList<Produto> produtoPeloCod(Integer cod) throws SisVendasException {
		if (produtos.containsKey(cod)) {
			return (ArrayList<Produto>) produtos.values();
		} else {
			throw new SisVendasException("Não existe produto para o código");
		}
	}
	
	public ArrayList<Produto> produtosAlfabeticamente(String nome) throws SisVendasException {
		if (produtos.containsValue(nome)) {
			return (ArrayList<Produto>) produtos.values();
		} else {
			throw new SisVendasException("Não existe nenhum produto para o nome");
		}
	}
	
	public void incluirVenda(Venda ven) {
		vendas.put(ven.getNumVenda(), ven);
	}
	
	public void excluirVenda(Venda ven) {
		vendas.remove(ven);
	} 
	
	public ArrayList<Venda> vendaPeloCod(Integer cod) throws SisVendasException {
		if (vendas.containsKey(cod)) {
			return (ArrayList<Venda>) vendas.values();
		} else {
			throw new SisVendasException("Não existe venda para o código");
		}
	}
	
	public ArrayList<Venda> vendasDoClienteOrderDataDesc(Cliente cli) throws SisVendasException {
		ArrayList<Venda> retorno = new ArrayList<>();
		for (Venda item : retorno) {
			if (item.getCliente().getCpf().equals(cli.getCpf()))
				retorno.add(item);
		}
		
		retorno.sort(null);
		
		if(retorno.equals(null))
			return retorno;
		else
			throw new SisVendasException("Não existe nenhuma venda para o cliente");
	}
	
	public ArrayList<Venda> vendasPorPeriodoOrderNomeDataDesc(GregorianCalendar inicio, GregorianCalendar termino)	{
		ArrayList<Venda> retorno = new ArrayList<>();
		for (Venda item : retorno) {
			if (item.getDataVenda().after(inicio) && item.getDataVenda().before(termino))
				retorno.add(item);
		}
			
		retorno.sort(null);
		
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
		
		return String.format("Cliente: {0}\nQuantidade que comprou: {1}\nTotal das compras: {2}", nome, cont, total);	
	}
}
