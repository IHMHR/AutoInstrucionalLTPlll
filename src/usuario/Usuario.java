/**
 * 
 */
package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Cliente;
import dados.Produto;
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
					alterarCliente(Console.readLine("Informe o Cpf: "));
					break;
				case 3:
					//Excluir Cliente
					excluirCliente(Console.readLine("Informe o Cpf: "));
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
					System.out.println("7");
					break;
				case 8:
					System.out.println("8");
					break;
				case 9:
					System.out.println("9");
					break;
				case 10:
					break;
				case 11:
					//Sair
					System.exit(0);
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static int Menu() {
		int op = -1;
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
		
		return op;
	}
	
	private static boolean lerListas() {
		boolean resul = true;
		//LtpUtil.lerArquivoObjetosArray(nomeArquivo);
		
		return resul;
	}
	
	private static boolean gravarListas() {
		boolean resul = true;
		//LtpUtil.gravarArquivoObjetosArray(nomeArquivo, listaObjetos);
		
		return resul;
	}
	
	private static void novoCliente() throws SisVendasException {
		String cpf,nome,telefone,email;
		do {
			cpf = Console.readLine("Informe o CPF: ");
		} while (LtpUtil.validarCPF(cpf));
		do {
			nome = Console.readLine("Infome o Nome: ");
		} while(LtpUtil.contarPalavras(nome) > 2);
		do {
			telefone = Console.readLine("Infome o Telefone: ");
		} while (!telefone.equals(null));
		do {
			email = Console.readLine("Infome o E-mail: ");
		} while (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;"));
		
		if (cpf.equals(cad.clientePeloCPF(cpf)))
			throw new SisVendasException("Cliente já cadastrado !");
		else
			cad.incluirCliente( new Cliente(cpf, nome, telefone, email));
	}
	
	private static void alterarCliente(String cpf) throws SisVendasException {
		System.out.println(cad.clientePeloCPF(cpf));
		String nome, telefone, email, ret;
		do {
			nome = Console.readLine("Infome o novo nome: ");
		} while(LtpUtil.contarPalavras(nome) > 2);
		do {
			telefone = Console.readLine("Infome o novo telefone: ");
		} while (!telefone.equals(null));
		do {
			email = Console.readLine("Infome o novo e-mail: ");
		} while (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;"));
		
		
		if(LtpUtil.validarCPF(cpf) && cad.clientePeloCPF(cpf).equals(cpf) && )
			cad.incluirCliente( new Cliente(cpf, nome, telefone, email));
	}
	
	private static void excluirCliente(String cpf) throws SisVendasException {
		System.out.println(cad.clientePeloCPF(cpf));
		if((Console.readLine("Efetuar a alteração? (s/n)").equalsIgnoreCase("S")) ? true : false)
			cad.excluirCliente(Cliente);
	}
	
	private static void novoProduto() {
		String nome;
		double preco;
		do {
			nome = Console.readLine("Informe o Nome: ");
		} while (nome.equals(null));
		do {
			preco = Console.readDouble("Informe o preço: ");
		} while (preco < 0);
		
		cad.incluirProduto( new Produto(nome, preco));
	}
	
	private static void alterarProduto(Integer cod) throws SisVendasException {
		System.out.println(cad.produtoPeloCod(cod));
		String nome;		
		double preco;
		do {
			nome = Console.readLine("Informe o novo nome: ");
		} while (nome.equals(null));
		do {
			preco = Console.readDouble("Informe o novo preço: ");
		} while (preco < 0);
		
		if ((Console.readLine("Efetuar a alteração? (s/n)").equalsIgnoreCase("S")) ? true : false)	
			cad.incluirProduto( new Produto(nome, preco));
	}
	
	private static void excluirProduto(Integer cod) {
		cad.excluirProduto(pro);
	}
}
