/**
 * Classe contendo atributos e metodos de Cliente
 */
package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Cliente implements Serializable, Comparable<Cliente> {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	public Cliente(String cpf, String nome, String telefone, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInclusao = new GregorianCalendar();
		this.dataUltAlteracao = null;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	@Override
	public String toString() {
		return String.format("Dados do cliente: Nome = %1$s, Cpf = %2$s, Telefone = %3$s, Email = %4$s, Data de Inclusão = %5$s, Data de Alteração = %6$s",
				nome, cpf, telefone, email, LtpUtil.formatarData(dataInclusao, "dd/MM/yyyy"), LtpUtil.formatarData(dataUltAlteracao, "dd/MM/yyyy"));
	}

	@Override
	public int compareTo(Cliente cli) {
		return nome.compareTo(cli.nome);
	}
}
