/**
 * Classe contendo atributos e metodos de Produtos
 */
package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

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
	
	public Produto(String nome, double precoUnitario) {
		super();
		this.codigo = ++sequentialId; 
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataInclusao = new GregorianCalendar();
		this.dataUltAlteracao = null;
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

	public static int getSequentialId() {
		return sequentialId;
	}

	public static void setSequentialId(int sequentialId) {
		Produto.sequentialId = sequentialId;
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
		return String.format("Dados do Produto: Código = %1$s, Nome = %2$s, Preço Unitário = %3$s, Data de Inclusão = %4$s, Data de Alteração = %4$s", codigo, nome, precoUnitario, LtpUtil.formatarData(dataInclusao, "dd/MM/yyyy"), LtpUtil.formatarData(dataUltAlteracao, "dd/MM/yyyy"));
	}
}
