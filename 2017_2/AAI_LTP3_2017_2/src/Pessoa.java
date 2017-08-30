import java.util.GregorianCalendar;

import utilitarios.LtpLib;

public abstract class Pessoa implements Comparable<Pessoa>
{
	private static int gerador = 0;
	private int codigo;
	private String nome;
	private String telefones;
	private String email;
	private GregorianCalendar dataCad;
	
	protected static final int CLIENTE = 1;
	protected static final int VENDEDOR = 2;
	protected static final int FORNECEDOR = 3;
	
	public Pessoa()
	{
	}
	
	public Pessoa(String _nome, String _telefones, String _email)
	{
		this.codigo = ++gerador;
		this.nome = _nome;
		this.telefones = _telefones;
		this.email = _email;
		this.dataCad = new GregorianCalendar();
	}
	
	public abstract int getTipoPessoa();
	
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
	
	public String getTelefones()
	{
		return telefones;
	}
	
	public void setTelefones(String telefones)
	{
		this.telefones = telefones;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public GregorianCalendar getDataCad()
	{
		return dataCad;
	}
	
	public void setDataCad(GregorianCalendar dataCad)
	{
		this.dataCad = dataCad;
	}
	
	@Override
	public String toString()
	{
		return "DADOS DO(A) " + nome + ":\nCodigo: " + codigo + "\nTelefones: " + telefones + "\nEmail: "	+ email + "\nData Cadastro: " + LtpLib.formatarData(dataCad, "dd/MM/yyyy");	
	}
	
	@Override
	public int compareTo(Pessoa p)
	{
		return p.getNome().compareTo(nome);
	}
}
