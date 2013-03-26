package modelo.lojaVariedades;

import modelo.estoque.Produto;
import modelo.cliente.ClienteJuridico;
import modelo.cliente.Cliente;
import modelo.cliente.ClienteFisico;
import modelo.fornecedor.Fornecedor;
import modelo.funcionario.Funcionario;
import modelo.gerentes.GerenteEstoque;
import modelo.gerentes.GerenteCliente;
import modelo.gerentes.GerenteFornecedor;
import modelo.gerentes.GerenteFuncionario;
import java.util.List;

public class Fachada {
	
	GerenteEstoque gerenteEstoque = new GerenteEstoque();
	GerenteFuncionario gerenteFuncionario = new GerenteFuncionario();
    GerenteCliente gerenteCliente = new GerenteCliente();
    GerenteFornecedor gerenteFornecedor = new GerenteFornecedor();
    public void addFuncionario (Funcionario f){
		gerenteFuncionario.addFuncionario(f);
	}
	
	public Funcionario pesquisarFuncionario(String nome){
		return gerenteFuncionario.pesquisarFuncionario(nome);	
	}
	
	public Funcionario pesquisarFuncionarioPorCpf(String cpf){
		return gerenteFuncionario.pesquisarFuncionarioPorCpf(cpf);
		
	}
	public boolean removerFuncionario (String nome){
		return gerenteFuncionario.removerFuncionario(nome);		
	}
	
	public boolean removerFuncionarioPorCpf(String cpf){
		return gerenteFuncionario.removerFuncionarioPorCpf(cpf);
	}
	public void addProdutoEstoque(Produto p){
		gerenteEstoque.addproduto(p);

	}
	public Produto pesquisarProduto (String id){
      return gerenteEstoque.pesquisarProdutos(id);
    }
    
    public void removerProduto(String nome){
		gerenteEstoque.removerProduto(nome);
	}
    
    
	public List <Produto> listaDeProdutos() {
		return gerenteEstoque.mostrarListaDeProdutos();
	}

  public void cadastrarClienteFisico(ClienteFisico c){
    gerenteCliente.cadastrarClienteFisico(c);
  }

  public void cadastrarClienteJuridico(ClienteJuridico c){
    gerenteCliente.cadastrarClienteJuridico(c);
  }

  public void cancelarCadastroClienteFisico(String cpf) {
    gerenteCliente.cancelarCadastroClienteFisico(cpf);
  }

  public void cancelarCadastroClienteJuridico(String cnpj) {
    gerenteCliente.cancelarCadastroClienteJuridico(cnpj);
  }

  public Cliente pesquisarClienteFisico(String cpf) {
    return gerenteCliente.pesquisarClienteFisico(cpf);
  }

  public Cliente pesquisarClienteJuridico(String cnpj) {
    return gerenteCliente.pesquisarClienteJuridico(cnpj);
  }

  public List<ClienteFisico> ListaDeClientesFisicos() {
    return gerenteCliente.ListaDeClientesFisicos();
  }

  public List<ClienteJuridico> ListaDeClientesJuridicos() {
    return gerenteCliente.ListaDeClientesJuridicos();
  }

  public void cadastrarFornecedor(Fornecedor f) {
	gerenteFornecedor.cadastrarFornecedor(f);
}
 
  public Fornecedor pesquisarFornecedorPorCnpj(String cnpj) {
	    return gerenteFornecedor.pesquisarFornecedorPorCnpj(cnpj);
	  }	

  public Fornecedor pesquisarFornecedorPorNome(String nome) {
	    return gerenteFornecedor.pesquisarFornecedorPorNome(nome);
	  }	
 
  public void removerFornecedorPorCnpj(String cnpj){
		gerenteFornecedor.removerFornecedorPorCnpj(cnpj);
	}

  public void removerFornecedorPorNome(String nome){
		gerenteFornecedor.removerFornecedorPorNome(nome);
	}
 
  public List<Fornecedor> listaDeFornecedores(){
	  return gerenteFornecedor.listaDeFornecedores();
  }
  
}
  
   
