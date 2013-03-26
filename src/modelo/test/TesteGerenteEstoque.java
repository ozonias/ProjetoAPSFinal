package modelo.test;


import static org.junit.Assert.assertEquals;
import modelo.lojaVariedades.Fachada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.estoque.Produto;
import modelo.exception.Exceptions;
import modelo.exception.ProdutoInvalidoException;

public class TesteGerenteEstoque {
private Fachada fac;

	@Before
	public void inicializaFachada(){
		this.fac = new Fachada();
	}
    
	@Test
	public void testaAddProdutoNullAoEstoque(){
		
		adicionarProdutoEstoque(null, "Produto Inválido");
	}
	
	private void adicionarProdutoEstoque(Produto p, String mensagem){
		try{
			fac.addProdutoEstoque(p);
		}catch (ProdutoInvalidoException pie){
			assertEquals(pie.getMessage(), mensagem);
		}
	}

	@Test
	public void testaAddProdutoComNomeVazio(){

		Produto p = new Produto(" ", "8.85", "Variedades", "001");
		adicionarProdutoEstoque (p, "Nome Vazio");
	}
	
	@Test
	public void testaAddProdutoComPrecoVazio(){
		
		Produto p = new Produto("Fone de Ouvido", " ", "Variedades", "001");
		adicionarProdutoEstoque (p,"Preço Vazio");
	}
    
	@Test
	public void testaAddProdutoComIdVazio(){
		
		Produto p = new Produto("Fone de Ouvido", "8.85", "Variedades", " ");	
		adicionarProdutoEstoque (p,"Id Vazio");
	}
    
	@Test
	public void testaAddProdutoComIdInvalido(){
		
		Produto p = new Produto("Fone de Ouvido", "8.85", "Variedades", "001fd");	
		adicionarProdutoEstoque (p,"Id Invalido");
	}
	
	@Test
	public void testaAddProdutoComPrecoInvalido(){

		Produto p = new Produto("Fone de Ouvido", "2a.3b", "Variedades", "001");
        adicionarProdutoEstoque (p, "Preço Inválido");
	}   

	@Test 
	public void testaPesquisarProdutoComIdVazio(){
		
		try{
			fac.pesquisarProduto(""); 
		}
        catch(ProdutoInvalidoException pie){
			assertEquals(pie.getMessage(), "Id Vazio");
		}
	}

	@Test
	public void testaPesquisarProdutoComIdInvalido(){
		
		try{
			fac.pesquisarProduto("001abc"); 
		}
        catch(ProdutoInvalidoException pie){
			assertEquals(pie.getMessage(), "Id Invalido");
		}
	}

	@Test
	public void testaRemoverProdutoComIdVazio(){
		try{
			fac.removerProduto(""); 
		}
        catch(ProdutoInvalidoException pie){
			assertEquals(pie.getMessage(), "Id Vazio");
		}
	}
	
	@Test
	public void testaRemoverProdutoComIdInvalido(){
		try{
			fac.removerProduto("001fda"); 
		}
        catch(ProdutoInvalidoException pie){
			assertEquals(pie.getMessage(), "Id Invalido");
		}
	}

	@Test
	public void nomeProduto() throws Exceptions {
		
		Produto p = new Produto("Carro", "2.99", "Brinquedos", "001");

		this.fac.addProdutoEstoque(p);
		this.fac.listaDeProdutos();

		Assert.assertNotNull(fac.listaDeProdutos());
	}
    
    @Test
	public void adicionarVariosProdutos() throws Exceptions {
		
		Produto p = new Produto("Fone de Ouvido", "8.85", "Variedades", "001");
		Produto p1 = new Produto("Carro", "3.35", "Brinquedos", "002");
		Produto p2 = new Produto("Deposito", "1.99", "Variedades", "003");
        
		fac.addProdutoEstoque(p);
		fac.addProdutoEstoque(p1);
		fac.addProdutoEstoque(p2);
		
        Assert.assertNotNull(fac.pesquisarProduto("001"));
        Assert.assertNotNull(fac.pesquisarProduto("002"));
        Assert.assertFalse(fac.pesquisarProduto("001").equals(fac.pesquisarProduto("002")));
        Assert.assertFalse (fac.pesquisarProduto("001").equals(fac.pesquisarProduto("002")));
        Assert.assertEquals(p, fac.pesquisarProduto("001"));
        Assert.assertNull(fac.pesquisarProduto(" "));
    }

	@Test
	public void removerProduto() throws Exceptions {
		
		Produto p = new Produto("Fone de Ouvido", "8.85", "Variedades", "000");
		Produto p1 = new Produto("Carro", "3.35", "Brinquedos", "001");
		Produto p2 = new Produto("Deposito", "1.99", "Variedades", "002");
		
		this.fac.addProdutoEstoque(p);
        this.fac.addProdutoEstoque(p1);
		this.fac.addProdutoEstoque(p2);
        
		Assert.assertEquals(p,fac.pesquisarProduto(p.getId()));
        Assert.assertEquals(p1,fac.pesquisarProduto(p1.getId()));
        Assert.assertEquals(p2,fac.pesquisarProduto(p2.getId()));
        Assert.assertFalse(p2.equals(fac.pesquisarProduto("000")));
        Assert.assertFalse (fac.pesquisarProduto("001").equals(fac.pesquisarProduto("002")));
        
        this.fac.removerProduto("000");
        this.fac.removerProduto("001");
        this.fac.removerProduto("002");
        
		Assert.assertNull(fac.pesquisarFuncionario("000"));
		Assert.assertNull(fac.pesquisarFuncionario("001"));
        Assert.assertNull(fac.pesquisarFuncionario("002"));
        Assert.assertNull("O produto deveria não existir porque já foi removido",fac.pesquisarProduto("001"));
        Assert.assertNull(fac.listaDeProdutos()); 
	}
	}