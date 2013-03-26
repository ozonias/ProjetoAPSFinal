package modelo.estoque;

public class Produto {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		return result;
	}
	
	//equals criado
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}
	private String nome;
	private String preco;
	private String setor;
    private String id;

  public Produto(String nome, String preco, String setor, String id) {
    this.nome = nome;
    this.preco = preco;
    this.setor = setor;
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPreco() {
    return preco;
  }

  public void setPreco(String preco) {
    this.preco = preco;
  }

  public String getSetor() {
    return setor;
  }

  public void setSetor(String setor) {
    this.setor = setor;
  }
  
  public String getId(){
    return id;
  }
  
  public void setId (String id){
    this.id = id;
  }

  public Produto (){
    
  }
  @Override
  public String toString() {
    return "Produto{" + "id" + id + "nome=" + nome + ", preco=" + preco + ", setor=" + setor + '}';
  }

}
