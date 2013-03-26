package modelo.funcionario;

import modelo.lojaVariedades.Pessoa;;

public class Funcionario extends Pessoa {
	
    private String idade;
	
    public Funcionario(String nome, String cpf, String telefone, String idade, String end){
       this.nome=nome;
       this.cpf=cpf;
       this.telefone=telefone;
       this.idade = idade;
       this.end = end;
    }

    public Funcionario() {
    	
    }
    
	public String getIdade() {
		return idade;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
     @Override
     public String toString() {
    	 return "Funcionario" +" "+ "nome="+ nome +" "+ "cpf="+cpf+" "+ "idade=" + idade +" "+ "Telefone=" + telefone;
     }
     
     @Override
     public int hashCode() {
		final int prime = 31;
		int result = 1;
		
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((idade==null) ? 0 : idade.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
     }
	
     @Override
     public boolean equals(Object obj) {
		
		if (this == obj)
					
			return true;
		
		if (obj == null)
			
			return false;
		
		if (getClass() != obj.getClass())
			
			return false;
		
		Funcionario other = (Funcionario) obj;
		
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} 
		
		else if (!cpf.equals(other.cpf))
			return false;
		
		if (end == null) {
			if (other.end != null)
				return false;
			
		} else if (!end.equals(other.end))
			return false;
		
		if (idade != other.idade)
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
			
		} else if (!nome.equals(other.nome))
			return false;
		
		if (telefone == null) {
			if (other.telefone != null)
				return false;
			
		} else if (!telefone.equals(other.telefone))
			return false;
		
		return true;
	}  
}
