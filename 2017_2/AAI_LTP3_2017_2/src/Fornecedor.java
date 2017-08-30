public class Fornecedor extends Pessoa
{
	private String cnpj;
	private String nomeContato;
	
	public Fornecedor(String _cnpj, String _nomeContato)
	{
		this.cnpj = _cnpj;
		this.nomeContato = _nomeContato;
	}

	@Override
	public int getTipoPessoa()
	{
		return Pessoa.FORNECEDOR;
	}

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public String getNomeContato()
	{
		return nomeContato;
	}

	public void setNomeContato(String nomeContato)
	{
		this.nomeContato = nomeContato;
	}

	@Override
	public String toString()
	{
		formartar cnpj
		return super.toString() + "\nCnpj: " + cnpj + "\nNome do contato: " + nomeContato;
	}
}
