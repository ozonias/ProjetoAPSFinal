package modelo.fornecedor;

public class Fornecedor {
	
	@Override
	public int hashCode(){ //o que é isso aqui???
		final int prime = 31; //por que 31 não entendi isso
		int result = 1;
		result = prime * result + ((nome == null)? 0 : nome.hashCode());
		result = prime * result + ((cnpj == null)? 0 : cnpj.hashCode());
		result = prime * result + ((tipo == null)? 0 : tipo.hashCode());
		result = prime * result + ((estado == null)? 0 : estado.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
		return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
	
		return true;
	}
		
	
	
	private String nome;
	private String cnpj;
	private String tipo;
	private String estado;
	
	public Fornecedor(String nome, String cnpj, String tipo, String estado) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	  public String toString() {
	    return "Fornecedor{" + "nome" + nome + "cnpj=" + cnpj + ", tipo=" + tipo + ", estado=" + estado + '}';
	  }


}
