import utilitarios.LtpLib;

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
		return super.toString() + "\nCpf: " + LtpLib.formatarCPF(cpf) + "\nMeta mensal: " + metaMensal;
	}
}