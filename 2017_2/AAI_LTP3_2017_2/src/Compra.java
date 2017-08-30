import java.util.GregorianCalendar;
import java.util.Vector;

public class Compra
{
	private static int gerador = 0;
	private int numCompra;
	private Fornecedor fornecedor;
	private Vector<ItemCompra> compraItens;
	private GregorianCalendar dataCompra;
	
	public Compra(Fornecedor _fornecedor, ItemCompra _compraItens)
	{
		this.numCompra = ++gerador;
		this.fornecedor = _fornecedor;
		this.compraItens = _compraItens;
		this.dataCompra = new GregorianCalendar();
	}

	public static int getGerador()
	{
		return gerador;
	}

	public static void setGerador(int gerador)
	{
		Compra.gerador = gerador;
	}

	public int getNumCompra()
	{
		return numCompra;
	}

	public void setNumCompra(int numCompra)
	{
		this.numCompra = numCompra;
	}

	public Fornecedor getFornecedor()
	{
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
	}

	public Vector<ItemCompra> getCompraItens()
	{
		return compraItens;
	}

	public void setCompraItens(Vector<ItemCompra> compraItens)
	{
		this.compraItens = compraItens;
	}

	public GregorianCalendar getDataCompra()
	{
		return dataCompra;
	}

	public void setDataCompra(GregorianCalendar dataCompra)
	{
		this.dataCompra = dataCompra;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (ItemCompra ic : compraItens)
		{
			sb.append(ic.toString());
		} formartar data
		return "DADOS DA COMPRA:\nNumero da compra: " + numCompra + "\nFornecedor: " + fornecedor.toString() + "\n" + sb.toString() + "\nData da compra: " + dataCompra;
	}
}