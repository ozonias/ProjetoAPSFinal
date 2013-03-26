package modelo.cliente;

public class ClienteJuridico extends Cliente{
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}
    
    // equals criado
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteJuridico other = (ClienteJuridico) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	private String cnpj;

  public ClienteJuridico(String nome,String cnpj, String endereco, String telefone){
      this.nome=nome;
      this.cnpj=cnpj;
      this.end=endereco;
      this.telefone=telefone;
    
} 
  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return "ClienteJuridico: " + "nome=" + nome +" "+ "cnpj=" + cnpj +" "+ "Endereço="+ end+" " +"Telefone" + telefone;
  }
  
  
  
    }  
