public class Cliente extends Pessoa
{
	private String cpf;
	private double limiteCredito;
	
	public Cliente(String _cpf, double _limiteCredito)
	{
		this.cpf = _cpf;
		this.limiteCredito = _limiteCredito;
	}

	@Override
	public int getTipoPessoa()
	{
		return Pessoa.CLIENTE;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public double getLimiteCredito()
	{
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito)
	{
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public String toString()
	{
		formatar cpf
		return super.toString() + "\nCpf: " + cpf + "\nLimite de credito: " + limiteCredito;
	}
}