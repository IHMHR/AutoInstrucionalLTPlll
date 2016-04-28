/**
 * Classe contendo atributos e metodos de Cliente
 */
package dados;

import java.util.GregorianCalendar;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Cliente {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	public Cliente(String cpf, String nome, String telefone, String email, GregorianCalendar dataInclusao, GregorianCalendar dataUltAlteracao) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
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
		return "Dados do Cliente \ncpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataInclusao=" + dataInclusao + ", dataUltAlteracao=" + dataUltAlteracao;
	}
}
