/**
 * Classe de interação com o Usuário
 */
package usuario;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;
import utilitarios.Console;
import utilitarios.LtpUtil;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Usuario {
	private static Cadastro cad = new Cadastro();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			while(true) {
				switch (Menu()) {
				case 1:
					//Novo Cliente
					novoCliente();
					break;
				case 2:	
					//Alterar Cliente
					alterarCliente(Console.readLine("Informe o Cpf: ").trim().replace(".", "").replace("-", ""));
					break;
				case 3:
					//Excluir Cliente
					excluirCliente(Console.readLine("Informe o Cpf: ").trim().replace(".", "").replace("-", ""));
					break;
				case 4:
					//Novo Produto
					novoProduto();
					break;
				case 5:
					//Alterar Produto 
					alterarProduto(Console.readInt("Informe o Código: "));
					break;
				case 6:
					//Excluir Produto 
					excluirProduto(Console.readInt("Informe o Código: "));
					break;
				case 7:
					//Consultar Produtos Alfabeticamente
					ProdutosAlfabeticamente(Console.readLine("Informe o nome do Produto: "));
					break;
				case 8:
					//Incluir venda de Cliente
					IncluirVendaCliente(Console.readLine("Informe o Cpf do Cliente que esta realizando a venda:").trim().replace(".", "").replace("-", ""));
					break;
				case 9:
					//Excluir venda de cliente por código da venda
					ExcluirVenda(Console.readInt("Informe o código da venda: "));
					break;
				case 10:
					//Consultar vendas pelo período em ordem de cliente e data da venda decrescente
					ConsultaVenda(Console.readLine("Informe o Cpf do cliente: ").trim().replace(".", "").replace("-", ""));
					break;
				case 11:
					//Sair
					System.exit(0);
					break;
				default: 
					//Alguma coisa deu errado.
					System.exit(0);
					break;
				}
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}

	/**
	 * @return opção escolhida pelo usuário
	 */
	private static int Menu() {
		int op = -1;
		try {
			/*Clientes (incluir um novo cliente, alterar o cliente via cpf, excluir um cliente via cpf)
			 Produtos (incluir um novo produto, alterar o produto via código, excluir um produto via código)
			 Vendas (incluir uma venda para um cliente, excluir uma venda de um cliente via código da venda, consultar as vendas pelo período em ordem de cliente e data da venda decrescente)*/
			do {
				System.out.println("|*************************************************************|");
				System.out.println("|* Categoria: Cliente                                        *|");
				System.out.println("|* 1 - Incluir um novo cliente                               *|");
				System.out.println("|* 2 - Alterar o cliente via cpf                             *|");
				System.out.println("|* 3 - Excluir um cliente via cpf                            *|");
				System.out.println("|*************************************************************|");
				System.out.println("|* Categoria: Produto                                        *|");
				System.out.println("|* 4 - Incluir um novo produto                               *|");
				System.out.println("|* 5 - Alterar o produto via código                          *|");
				System.out.println("|* 6 - Excluir um produto via código                         *|");
				System.out.println("|* 7 - Consultar produtos alfabéticamente pelo nome          *|");
				System.out.println("|*************************************************************|");
				System.out.println("|* Categoria: Venda                                          *|");
				System.out.println("|* 8 - Incluir uma venda para um cliente                     *|");
				System.out.println("|* 9 - Excluir uma venda de um cliente via código da venda   *|");
				System.out.println("|* 10 - Consultar as vendas pelo período em ordem de cliente *|");
				System.out.println("|*                             e data da venda decrescente   *|");
				System.out.println("|*************************************************************|");
				System.out.println("|* 11 - Sair da aplicação                                    *|");
				System.out.println("|*************************************************************|");
				op = Console.readInt("Informe o código da opção desejada: ");
			} while (op < 1 || op > 11);
		} catch (Exception  e) {
			System.err.println(e.getMessage().toString());
		}
		return op;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	public static void lerListaCliente(){
		try{
			if(new File("Clientes.obj").exists()) {
				ArrayList<Cliente> clientes = (ArrayList<Cliente>) LtpUtil.lerArquivoObjetosArray("Clientes.obj");
				if(clientes.size() > 0){
					for(Cliente cli : clientes) {
						cad.incluirCliente(cli);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void lerListaProduto(){
		try {
			if (new File("Produtos.obj").exists()) {
				ArrayList<Produto> produtos = (ArrayList<Produto>) LtpUtil.lerArquivoObjetosArray("Produtos.obj");
				if(produtos.size() > 0){
					int cod = produtos.get(produtos.size() - 1).getCodigo();
					Produto.setSequentialId(cod);
					for (Produto prod : produtos) {
						cad.incluirProduto(prod);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void lerListaVenda(){
		try {
			if (new File("Vendas.obj").exists()) {
				ArrayList<Venda> vendas = (ArrayList<Venda>) LtpUtil.lerArquivoObjetosArray("Vendas.obj");
				if(vendas.size()>0){
					int cod = vendas.get(vendas.size() - 1).getNumVenda();
					Venda.setSequentialId(cod);
					for (Venda ven : vendas) {
						cad.incluirVenda(ven);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	@SuppressWarnings("static-access")
	public static void gravarCliente(){
		try {
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			for (Cliente cli : cad.clientes.values()) {
				clientes.add(cli);
			}
			LtpUtil.gravarArquivoObjetosArray("Clientes.obj", clientes);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	@SuppressWarnings("static-access")
	public static void gravarProduto(){
		try {
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			for (Produto prod : cad.produtos.values()) {
				produtos.add(prod);
			}
			LtpUtil.gravarArquivoObjetosArray("Produtos.obj", produtos);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	@SuppressWarnings("static-access")
	public static void gravarVenda(){
		try {
			ArrayList<Venda> vendas = new ArrayList<Venda>();
			for (Venda ven : cad.vendas.values()) {
				vendas.add(ven);
			}
			LtpUtil.gravarArquivoObjetosArray("Vendas.obj", vendas);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}

	/**
	 * @throws SisVendasException
	 */
	private static void novoCliente() throws SisVendasException {
		try {
			String cpf, nome, telefone, email;
			do {
				cpf = Console.readLine("Informe o CPF: ").trim().replace(".", "").replace("-", "");
			} while (!LtpUtil.validarCPF(cpf));
			do {
				nome = Console.readLine("Infome o Nome: ").trim();
			} while(LtpUtil.contarPalavras(nome) < 2);
			do {
				telefone = Console.readLine("Infome o Telefone: ").trim();
			} while (telefone.length() < 7);
			do {
				email = Console.readLine("Infome o E-mail: ").trim();
			} while (!LtpUtil.validarEmail(email));
			
			//if (cpf.equals(cad.clientePeloCPF(cpf).getCpf()))
			//if (cpf.equals(cad.clientePeloCPF(cpf).getCpf().equals(null) ? "12345678912" : cad.clientePeloCPF(cpf).getCpf()))
			if (cad.clientePeloCPF(cpf).getCpf().equals("Não existe cliente para o cpf"))
				throw new SisVendasException("Cliente já cadastrado !");
			else
				cad.incluirCliente( new Cliente(cpf, nome, telefone, email));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param cpf
	 * @throws SisVendasException
	 */
	private static void alterarCliente(String cpf) throws SisVendasException {
		try {
			Cliente cli = cad.clientePeloCPF(cpf);
			System.out.println(cli);
			String nome, telefone, email;
			do {
				nome = Console.readLine("Infome o novo nome: ");
			} while(LtpUtil.contarPalavras(nome) < 2);
			do {
				telefone = Console.readLine("Infome o novo telefone: ");
			} while (telefone.length() < 7);
			do {
				email = Console.readLine("Infome o novo e-mail: ");
			} while (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;"));
			
			if(LtpUtil.validarCPF(cpf) && cad.clientePeloCPF(cpf).equals(cpf) && !cad.clientePeloCPF(cpf).equals(null)) {
				cli.setDataUltAlteracao( new GregorianCalendar());
				cli.setEmail(email);
				cli.setNome(nome);
				cli.setTelefone(telefone);
				cad.excluirCliente(cli);
				cad.incluirCliente(cli);
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param cpf
	 * @throws SisVendasException
	 */
	private static void excluirCliente(String cpf) throws SisVendasException {
		try {
			System.out.println(cad.clientePeloCPF(cpf).toString());
			if((Console.readLine("Efetuar a exclusão? (s/n)").equalsIgnoreCase("S")) ? true : false)
				cad.excluirCliente(cad.clientePeloCPF(cpf));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	private static void novoProduto() {
		try {
			String nome;
			double preco;
			do {
				nome = Console.readLine("Informe o Nome: ");
			} while (nome.equals(null));
			do {
				preco = Console.readDouble("Informe o preço: ".replace(",", "."));
			} while (preco < 0);
			
			cad.incluirProduto( new Produto(nome, preco));
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param cod
	 * @throws SisVendasException
	 */
	private static void alterarProduto(Integer cod) throws SisVendasException {
		try {
			Produto pro = cad.produtoPeloCod(cod);
			System.out.println(pro);
			String nome;
			double preco;
			do {
				nome = Console.readLine("Informe o novo nome: ");
			} while (nome.equals(null));
			do {
				preco = Console.readDouble("Informe o novo preço: ");
			} while (preco < 0);
			
			if ((Console.readLine("Efetuar a alteração? (s/n)").equalsIgnoreCase("S")) ? true : false) {	
				pro.setNome(nome);
				pro.setDataUltAlteracao( new GregorianCalendar());
				pro.setPrecoUnitario(preco);
				cad.excluirProduto(pro);
				cad.incluirProduto(pro);
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param cod
	 * @throws SisVendasException
	 */
	private static void excluirProduto(Integer cod) throws SisVendasException {
		try {
			System.out.println(cad.produtoPeloCod(cod).toString());
			if((Console.readLine("Efetuar a exclusão ? (s/n)").equalsIgnoreCase("S")) ? true : false)
				cad.excluirProduto(cad.produtoPeloCod(cod));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param produto
	 * @throws SisVendasException
	 */
	private static void ProdutosAlfabeticamente(String produto) throws SisVendasException {
		try {
			ArrayList<Produto> prod = cad.produtosAlfabeticamente(produto);
			for (Produto p : prod) {
				System.out.println(p.toString());
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	/**
	 * @param cpf
	 * @throws SisVendasException
	 */
	private static void IncluirVendaCliente(String cpf) throws SisVendasException {
		try {
			int cod, qnt;
			do {
				cod = Console.readInt("Informe o código do produto: ");
				Produto prod = cad.produtoPeloCod(cod);
				do {
					qnt = Console.readInt("Informe a quantidade para compra: ");
				} while (qnt < 0);
				Cadastro.IncluirItemVenda( new ItemVenda(prod, prod.getPrecoUnitario(), qnt, prod.getPrecoUnitario()*qnt));
			} while (Console.readLine("Mais algum produto ? (S/N)").equalsIgnoreCase("S") ? true : false);
			cad.incluirVenda( new Venda(cad.clientePeloCPF(cpf), Cadastro.itensVenda));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	private static void ExcluirVenda(int cod) throws SisVendasException {
		try {
			System.out.println(cad.vendaPeloCod(cod).toString());
			if(Console.readLine("Confirmar exclusão ? (S/N)").equalsIgnoreCase("S") ? true : false)
				cad.excluirVenda(cad.vendaPeloCod(cod));
		} catch (SisVendasException e) {
			System.err.println(e.getMessage().toString());
		}	
	}
	
	private static void ConsultaVenda(String cpf) throws SisVendasException {
		try {
			System.out.println(cad.vendasDoClienteOrderDataDesc(cad.clientePeloCPF(cpf)).toString());
		} catch (SisVendasException e) {
			System.err.println(e.getMessage().toString());
		}
	}
}
