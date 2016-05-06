/**
 * 
 */
package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.Cadastro;
import dados.Cliente;
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
		switch (Menu()) {
		case 1:
			//Novo Cliente
			novoCliente();
			break;
		case 2:	
			//Alterar Cliente via CPF
			alterarCliente(Console.readLine("Informe o Cpf: "));
			break;
		case 33:
			//Excluir Cliente
			excluirCliente(Console.readLine("Informe o Cpf: "));
			break;
		case 4:
			System.out.println("4");
			break;
		case 5:
			System.out.println("5");
			break;
		case 6:
			System.out.println("6");
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
			//Sair
			System.exit(0);
			break;
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
			System.out.println("|*************************************************************|");
			System.out.println("|* Categoria: Venda                                          *|");
			System.out.println("|* 7 - Incluir uma venda para um cliente                     *|");
			System.out.println("|* 8 - Excluir uma venda de um cliente via código da venda   *|");
			System.out.println("|* 9 - Consultar as vendas pelo período em ordem de cliente  *|");
			System.out.println("|*                             e data da venda decrescente   *|");
			System.out.println("|*************************************************************|");
			System.out.println("|* 10 - Sair da aplicação                                    *|");
			System.out.println("|*************************************************************|");
			op = Console.readInt("Informe o código da opção desejada: ");
		} while (op < 1 || op > 10);
		
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
	
	private static void novoCliente() {
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
		
		cad.incluirCliente( new Cliente(cpf, nome, telefone, email));
	}
	
	private static void alterarCliente(String cpf) {
		if(LtpUtil.validarCPF(cpf))
			//
	}
	
	private static void excluirCliente(String cpf) {
		if(LtpUtil.validarCPF(cpf))
			cad.excluirCliente(cli);
	}
}
