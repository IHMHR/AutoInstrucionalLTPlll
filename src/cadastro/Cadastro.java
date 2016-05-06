/**
 * Classe para implementação do Cadastro
 */
package cadastro;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public ArrayList<Cliente> clientePeloCPF(String cpf) {
		if (clientes.containsKey(cpf)) {
			return (ArrayList<Cliente>) clientes.values();
		} else {
			return new SisVendasException("Não existe cliente para o cpf");
		}
	}
	
	public ArrayList<Cliente> clientesAlfabeticamente(String nome) {
		if (clientes.containsValue(nome)) {
			return (ArrayList<Cliente>) clientes.values();
		} else {
			return new SisVendasException("Não existe nenhum cliente para o nome");
		}
	}
	
	public void incluirProduto(Produto pro) {
		produtos.put(pro.getCodigo(), pro);
	}
	
	public void excluirProduto(Produto pro) {
		produtos.remove(pro);
	} 
	
	public ArrayList<Produto> produtoPeloCod(Integer cod) {
		if (produtos.containsKey(cod)) {
			return (ArrayList<Produto>) produtos.values();
		} else {
			return new SisVendasException("Não existe produto para o código");
		}
	}
	
	public ArrayList<Produto> produtosAlfabeticamente(String nome) {
		if (produtos.containsValue(nome)) {
			return (ArrayList<Produto>) produtos.values();
		} else {
			return new SisVendasException("Não existe nenhum produto para o nome");
		}
	}
	
	public void incluirVenda(Venda ven) {
		vendas.put(ven.getNumVenda(), ven);
	}
	
	public void excluirVenda(Venda ven) {
		vendas.remove(ven);
	} 
	
	public ArrayList<Venda> vendaPeloCod(Integer cod) {
		if (vendas.containsKey(cod)) {
			return (ArrayList<Produto>) produtos.values();
		} else {
			 new SisVendasException("Não existe venda para o código");
		}
	}
	
	public ArrayList<Venda> vendasDoClienteOrderDataDesc(Cliente cli) {
		ArrayList<Venda> retorno = new ArrayList<>();
		for (Venda item : vendas) {
			if (item.getCliente().getCpf().equals(cli.getCpf()))
				retorno.add(item);
		}
		
		//java.util.Collections => sort the array Desc
		
		return retorno.equals(null) ? retorno.toString() : new SisVendasException("Não existe nenhuma venda para o cliente");
	}
	
	public ArrayList<Venda> vendasPorPeriodoOrderNomeDataDesc(GregorianCalendar inicio, GregorianCalendar termino)	{
		
	}
	
	public ArrayList<Venda> vendasPorClienteOrderClienteAsc(GregorianCalendar inicio, GregorianCalendar termino) {
		
	}
}
