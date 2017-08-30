public class Vendedor extends Pessoa
{
	private String cpf;
	private double metaMensal;
	
	public Vendedor(String _cpf, double _metaMensal)
	{
		this.cpf = _cpf;
		this.metaMensal = _metaMensal;
	}

	@Override
	public int getTipoPessoa()
	{
		return Pessoa.VENDEDOR;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public double getMetaMensal()
	{
		return metaMensal;
	}

	public void setMetaMensal(double metaMensal)
	{
		this.metaMensal = metaMensal;
	}
	
	@Override
	public String toString()
	{
		formatar cpf
		return super.toString() + "\nCpf: " + cpf + "\nMeta mensal: " + metaMensal;
	}
}