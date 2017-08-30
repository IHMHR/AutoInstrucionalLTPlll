import java.util.GregorianCalendar;

public class Produto implements Comparable<Produto>
{
	private static int gerador = 0;
	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueMinimo;
	private GregorianCalendar dataCad;
	
	public Produto(String _nome, double _precoUnitario, int _estoque, int _estoqueMinimo)
	{
		this.codigo = ++gerador;
		this.nome = _nome;
		this.precoUnitario = _precoUnitario;
		this.estoque = _estoque;
		this.estoqueMinimo = _estoqueMinimo;
		this.dataCad = new GregorianCalendar();
	}

	public static int getGerador()
	{
		return gerador;
	}

	public static void setGerador(int gerador)
	{
		Produto.gerador = gerador;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public double getPrecoUnitario()
	{
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario)
	{
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque()
	{
		return estoque;
	}

	public void setEstoque(int estoque)
	{
		this.estoque = estoque;
	}

	public int getEstoqueMinimo()
	{
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo)
	{
		this.estoqueMinimo = estoqueMinimo;
	}

	public GregorianCalendar getDataCad()
	{
		return dataCad;
	}

	public void setDataCad(GregorianCalendar dataCad)
	{
		this.dataCad = dataCad;
	}
	
	public int addEstoque(int quantidade)
	{
		return this.estoque += quantidade;
	}
	
	public int removeEstoque(int quantidade) throws SisComException
	{
		if(this.estoque < quantidade)
		{
			throw new SisComException("O produto " + nome + " somente tem disponível " + estoque + ".\nEstoque Insuficiente.");
		}
		else
		{
			return this.estoque -= quantidade;
		}
	}

	@Override
	public int compareTo(Produto p)
	{
		return p.getNome().compareTo(nome);
	}
	
	@Override
	public String toString()
	{
		return "DADOS DO PRODUTO\nCodigo: " + codigo + "\nNome: " + nome + "\nPreço Unitario";
	}
}