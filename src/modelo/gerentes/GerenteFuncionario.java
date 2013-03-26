package modelo.gerentes;


import java.util.LinkedList;
import java.util.List;

import modelo.exception.FornecedorInvalidoException;
import modelo.exception.FuncionarioInvalidoException;
import modelo.fornecedor.Fornecedor;
import modelo.funcionario.Funcionario;

public class GerenteFuncionario {
Funcionario f = new Funcionario();
	List<Funcionario> listfunc = new LinkedList<Funcionario>();
	
	public void addFuncionario (Funcionario f){
	    if(f==null){
			throw new FuncionarioInvalidoException ("Funcion·rio Inv·lido");
		}
		if(f.getCpf().contains ("^[a-Z]")){
			throw new FuncionarioInvalidoException("CPF Inv·lido");
		}
		if(f.getCpf().length()==0){
			throw new FuncionarioInvalidoException ("CPF Vazio");
		}
		if(f.getNome().length()==0){
			throw new FuncionarioInvalidoException ("Nome Vazio");
		}
		if (f.getTelefone().length()==0){
			throw new FuncionarioInvalidoException ("Telefone Vazio");
		}
		if(f.getTelefone().contains ("^[a-Z]")){
			throw new FuncionarioInvalidoException("Telefone Inv·lido");
		}
		if (f.getEndereco().length()==0){
			throw new FuncionarioInvalidoException("Endereco Vazio");
		}
		
		listfunc.add(f);
	}
	
	public Funcionario pesquisarFuncionario(String nome){
		
		if(nome.length()==0){
			throw new FuncionarioInvalidoException ("Nome Vazio");
		}
		for(Funcionario f : this.listfunc) {
			if(f.getNome().equals(nome))
				return f;
		}
		return null;
	}
	
	public Funcionario pesquisarFuncionarioPorCpf(String cpf){
		 if(cpf.length()==0){
			throw new FornecedorInvalidoException("CPF Vazio");
		}
		 if(cpf.contains ("^[a-Z]")){
				throw new  FornecedorInvalidoException("CNPJ Inv√°lido");
			}
		 for(Funcionario f: this.listfunc){
            if(f.getCpf().equals(cpf))
                return f;
    }
		 return null; 
			 }
	
	public boolean removerFuncionario (String nome){
		return listfunc.remove(this.pesquisarFuncionario(nome));
		
	}
	
	public boolean removerFuncionarioPorCpf (String cpf){
		return listfunc.remove(this.pesquisarFuncionario(cpf));
		
	}
	
	public void atualizarDados(Funcionario f){
		
	}  
}
