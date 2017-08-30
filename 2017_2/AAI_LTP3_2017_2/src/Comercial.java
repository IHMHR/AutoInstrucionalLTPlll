public class Comercial
{
    private static Comercial comercialClass = null;
    private Vector<Pessoa> pessoas = new Vector<Pessoa>();
    private Vector<Produto> produtos = new Vector<Produto>();
    private Vector<Compra> compras = new Vector<Compra>();
    private Vector<Venda> vendas = new Vector<Venda>();
    
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
    
    public static void inserirPessoa(Pessoa p)
    {
        if (p.getTipo() == Pessoa.CLIENTE)
        {
            // validar se o cliente já possui cadastro
            for (Cliente c : pessoas)
            {
                if (c.getCpf().equals(p.getCpf()))
                {
                    throw new SisComException("Cliente já possui cadastro");
                }
            }
        }
        else if (p.getTipo() == Pessoa.VENDEDOR)
        {
            // validar a meta de vendas
            if (p.getMetaVenda() <= 0)
            {
                throw new SisComException("Meta de venda do vendedor inválida");
            }
            
            // validar se o vendedor já possui cadastro
            for (Vendedor v : pessoas)
            {
                if (v.getCpf().equals(p.getCpf()))
                {
                    throw new SisComException("Vendedor já possui cadastro");
                }
            }
        }
        else if(p.getTipo() == Pessoa.FORNECEDOR)
        {
            // validar se o fornecedor já possui cadastro
            for (Fornecedor f : pessoas)
            {
                if (f.getCnpj().equals(p.getCnpj()))
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
    
    public static void excluirPessoa(Pessoa p)
    {
        if (p.getTipo() == Pessoa.CLIENTE)
        {
            // verificar se o cliente tem venda realizada
            for (Venda v : vendas)
            {
                if (v.getCliente().getCpf().equal(p.getCpf()))
                {
                    throw new SisComException("Cliente não pode ser excluido");
                }
            }
        }
        else if (p.getTipo() == Pessoa.VENDEDOR)
        {
            // verificar se o vendedor tem venda registrada
            for (Venda v : vendas)
            {
                if (v.getVendedor().getCpf().equals(p.getCpf()))
                {
                    throw new SisComException("Vendedor não pode ser excluido");
                }
            }
        }
        else if(p.getTipo() == Pessoa.FORNECEDOR)
        {
            // verificar se o fornecedor tem compra realizada
            for (Compra c : compras)
            {
                if(c.getFornecedor().getCnpf().equals(p.getCnpj()))
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
}
