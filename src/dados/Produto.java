/**
 * Classe contendo atributos e metodos de Produtos
 */
package dados;

import java.util.GregorianCalendar;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class Produto {
	
	private static int sequentialId = 0;
	
	private int codigo;
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltAlteracao;
	
	public Produto(String nome, double precoUnitario, GregorianCalendar dataInclusao, GregorianCalendar dataUltAlteracao) {
		super();
		this.codigo = ++sequentialId; 
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataInclusao = dataInclusao;
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
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

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Dados do Produto \ncodigo=" + codigo + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", dataInclusao="+ dataInclusao + ", dataUltAlteracao=" + dataUltAlteracao;
	}
}
