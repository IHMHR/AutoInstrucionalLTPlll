import java.util.List;
import java.util.Vector;

public class Comercial
{
    private static Comercial comercialClass = null;
    private static List<Pessoa> pessoas = new Vector<Pessoa>();
    private static List<Produto> produtos = new Vector<Produto>();
    private static List<Compra> compras = new Vector<Compra>();
    private static List<Venda> vendas = new Vector<Venda>();
    
    // Singleton Pattern
    private Comercial()
    {
    }
    
    public Comercial getInstancia()
    {
        if (comercialClass == null)
        {
            comercialClass = new Comercial();
        }
        return comercialClass;
    }
    
    public static void inserirPessoa(Pessoa p) throws SisComException
    {
        if (p.getTipoPessoa() == Pessoa.CLIENTE)
        {
            // validar se o cliente já possui cadastro
            for (Pessoa _pessoa : pessoas)
            {
            	Cliente cli = (Cliente) _pessoa;
                if (cli.getCpf().equals(((Cliente)p).getCpf()))
                {
                    throw new SisComException("Cliente já possui cadastro");
                }
            }
        }
        else if (p.getTipoPessoa() == Pessoa.VENDEDOR)
        {
            // validar a meta de vendas
            if (((Vendedor)p).getMetaMensal() <= 0)
            {
                throw new SisComException("Meta de venda do vendedor inválida");
            }
            
            // validar se o vendedor já possui cadastro
            for (Pessoa v : pessoas)
            {
                if (((Vendedor)v).getCpf().equals(((Cliente)p).getCpf()))
                {
                    throw new SisComException("Vendedor já possui cadastro");
                }
            }
        }
        else if(p.getTipoPessoa() == Pessoa.FORNECEDOR)
        {
            // validar se o fornecedor já possui cadastro
            for (Pessoa f : pessoas)
            {
                if (((Fornecedor)f).getCnpj().equals(((Fornecedor)p).getCnpj()))
                {
                    throw new SisComException("Fornecedor já possui cadastro");
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Tipo de pessoa inválido");
        }
        pessoas.add(p);
    }
    
    public static void excluirPessoa(Pessoa p) throws SisComException
    {
        if (p.getTipoPessoa() == Pessoa.CLIENTE)
        {
            // verificar se o cliente tem venda realizada
            for (Venda v : vendas)
            {
                if (v.getCliente().getCpf().equals(((Cliente)p).getCpf()))
                {
                    throw new SisComException("Cliente não pode ser excluido");
                }
            }
        }
        else if (p.getTipoPessoa() == Pessoa.VENDEDOR)
        {
            // verificar se o vendedor tem venda registrada
            for (Venda v : vendas)
            {
                if (v.getVendedor().getCpf().equals(((Cliente)p).getCpf()))
                {
                    throw new SisComException("Vendedor não pode ser excluido");
                }
            }
        }
        else if(p.getTipoPessoa() == Pessoa.FORNECEDOR)
        {
            // verificar se o fornecedor tem compra realizada
            for (Compra c : compras)
            {
                if(c.getFornecedor().getCnpj().equals(((Fornecedor)p).getCnpj()))
                {
                    throw new SisComException("Fornecedor não pode ser excluido");
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Tipo de pessoa inválido");
        }
        pessoas.remove(p);
    }
    
    public static void comprar(Fornecedor f, Vector<ItemCompra> itens)
    {
    	compras.add(new Compra(f, itens));
    	for (ItemCompra ic : itens)
    	{
    		produtos.get(produtos.indexOf(ic.getProduto())).addEstoque(ic.getProduto().getCodigo());
		}
    }
}
