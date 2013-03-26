package modelo.gerentes;

import modelo.exception.ProdutoInvalidoException;
import java.util.LinkedList;
import java.util.List;
import modelo.estoque.Produto;

public class GerenteEstoque {

	LinkedList <Produto> produtos = new LinkedList<Produto>();

	public void addproduto(Produto p){
		
		if(p==null){
			throw new ProdutoInvalidoException("Produto Inválido");
		}
		if(p.getNome().length()==0){
			throw new ProdutoInvalidoException("Nome Vazio");
		}//
		if(p.getPreco().length()==0){
			throw new ProdutoInvalidoException("Preço Vazio");
		}//
		if(p.getId().length()==0){
			throw new ProdutoInvalidoException("Id Vazio");
		}//
		if (p.getId().contains("^[a-Z]")){
			throw new ProdutoInvalidoException("Id Invalido");
		}
		if(p.getPreco().contains("^[a-Z]")){
			throw new ProdutoInvalidoException("Preço Inválido");
		}//
		produtos.add(p);
	}

    public Produto pesquisarProdutos (String Id){
    	if(Id.length()==0){
    			throw new ProdutoInvalidoException("Id Vazio");
		}
    	if (Id.contains("^[a-Z]")){
			throw new ProdutoInvalidoException("Id Invalido");
		}
    	
        for(Produto p : this.produtos) {
			if(p.getId().equals(Id))
				return p;
    }
    return null;
    }
   
	public boolean removerProduto(String id) {
      return produtos.remove(this.pesquisarProdutos(id));
	}

	public List <Produto> mostrarListaDeProdutos() {
        for (Produto p : produtos){
          return produtos;
        }
		return null;
	}
}
