package modelo.gerentes;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import modelo.cliente.Cliente;
import modelo.cliente.ClienteFisico;
import modelo.exception.ClienteInvalidoException;
import modelo.exception.FornecedorInvalidoException;
import modelo.exception.ListaVaziaException;
import modelo.exception.ProdutoInvalidoException;
import modelo.fornecedor.Fornecedor;

public class GerenteFornecedor {
	
	List<Fornecedor> fornecedores;
	
	public GerenteFornecedor(){
		 fornecedores = new LinkedList<Fornecedor>();
	}
	
	public void cadastrarFornecedor(Fornecedor f){
		if(f==null){
			throw new FornecedorInvalidoException("Fornecedor Inválido");
		}
		if(f.getCnpj().contains ("^[a-Z]")){
			throw new  FornecedorInvalidoException("CNPJ Inválido");
		}
		if(f.getCnpj().length()==0){
			throw new FornecedorInvalidoException ("CNPJ Vazio");
		}
		if(f.getNome().length()==0){
			throw new FornecedorInvalidoException ("Nome Vazio");
		}
		if(f.getTipo().length()==0){
			throw new FornecedorInvalidoException ("Tipo Vazio");
		}
		if(f.getEstado().length()==0){
			throw new FornecedorInvalidoException ("Estado Vazio");
		}
		if(f.getEstado().contains ("^[0-9]")){
			throw new  FornecedorInvalidoException("Estado Inválido");
		}
		if(f.equals(pesquisarFornecedorPorCnpj(f.getCnpj()))){
			throw new  FornecedorInvalidoException("CNPJ Já Existe");
		}	
		if(f.equals(pesquisarFornecedorPorNome(f.getNome()))){
			throw new  FornecedorInvalidoException("Nome Já Existe");
		}
		if (f.getNome()==null){
			throw new FornecedorInvalidoException ("Nome Vazio");
		}
		if (f.getCnpj()==null){
			throw new FornecedorInvalidoException ("CNPJ Vazio");
		}
		if (f.getEstado()==null){
			throw new FornecedorInvalidoException ("Estado Vazio");
		}
		if (f.getTipo()==null){
			throw new FornecedorInvalidoException ("Tipo Vazio");
		}
		fornecedores.add(f);
	}

	public void removerFornecedorPorCnpj(String cnpj){
		
	if (this.pesquisarFornecedorPorCnpj(cnpj)==null){
		throw new FornecedorInvalidoException("CNPJ Inexistente");
	}
	fornecedores.remove(this.pesquisarFornecedorPorCnpj(cnpj));
	}
	public void removerFornecedorPorNome(String nome){
		if(this.pesquisarFornecedorPorNome(nome)==null){
			throw new FornecedorInvalidoException("Nome Inexistente");
		}
		
		fornecedores.remove(this.pesquisarFornecedorPorNome(nome));
		
	}
	
	public Fornecedor pesquisarFornecedorPorCnpj(String cnpj){
		 if(cnpj.length()==0){
 			throw new FornecedorInvalidoException("CNPJ Vazio");
		}
		 if(cnpj.contains ("^[a-Z]")){
				throw new  FornecedorInvalidoException("CNPJ Inválido");
			}
		 for(Fornecedor f: fornecedores){
             if(f.getCnpj().equals(cnpj))
                 return f;
     }
		 return null; 
			 }
	
	public Fornecedor pesquisarFornecedorPorNome(String nome){
		 if(nome.length()==0){
			throw new FornecedorInvalidoException("Nome Vazio");
		}
		 
		 for(Fornecedor f: fornecedores){
            if(f.getNome().equals(nome))
                return f;
    }
		 return null;
		 
		 }
	

	  public List <Fornecedor> listaDeFornecedores(){
	    for (int i = 0; i < fornecedores.size(); i++) {
			return fornecedores;
		}
	    
	    throw new ListaVaziaException("Lista Vazia"); 
	     }


}