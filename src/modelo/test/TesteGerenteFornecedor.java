package modelo.test;

import static org.junit.Assert.assertEquals;
import modelo.lojaVariedades.Fachada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.exception.Exceptions;
import modelo.exception.FornecedorInvalidoException;
import modelo.exception.ListaVaziaException;
import modelo.fornecedor.Fornecedor;

public class TesteGerenteFornecedor {
	private Fachada fac;
	//As linhas de código passando das 1000 foi porque não tirei os métodos das classes testes
	
	private void adicionarFornecedor(Fornecedor f, String mensagem){
		try{
			fac.cadastrarFornecedor(f);
		}catch (FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), mensagem);
		}
	}
	
	@Before
	public void inicializaFachada(){
		this.fac = new Fachada();
	}

	@Test		
	public void testaCadastrarFornecedorNull(){
		
		adicionarFornecedor (null, "Fornecedor InvÃ¡lido");
	}
	
	
	@Test
	public void testaAddFornecedorComNomeVazio(){
		Fornecedor f = new Fornecedor(" ", "78.425.986/0036-15", "perfumaria", "PB");
		adicionarFornecedor(f, "Nome Vazio");
	}
	
	@Test
	public void testaAddFornecedorComCnpjVazio(){
		Fornecedor f = new Fornecedor("Martins"," ","perfumaria","PB");
		adicionarFornecedor(f, "CNPJ Vazio");
	}
		
	@Test
	public void testaAddFornecedorComtipoVazio(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","","PB");
		adicionarFornecedor(f, "Tipo Vazio");
	}
		
	@Test
	public void testaAddFornecedorComEstadoVazio(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","");
		adicionarFornecedor(f, "Estado Vazio");
	}
	
	@Test
	public void testaAddFornecedorComNomeDuplicado(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","perfumaria","PB");
		fac.cadastrarFornecedor(f); 
		Assert.assertNotNull(fac.pesquisarFornecedorPorNome("Martins"));

		Fornecedor f2 = new Fornecedor("Martins","89.123.457/1278-90","Eletronicos","PE");
		try{
			fac.cadastrarFornecedor(f2);  
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome ja Existe");
		}
	}	

	@Test
	public void testaAddFornecedorComCnpjDuplicado(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","perfumaria","PB");
		fac.cadastrarFornecedor(f); 
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15"));

		Fornecedor f2 = new Fornecedor("Perfumes e Cia","78.425.986/0036-15","perfumaria","PB");
		try{
			fac.cadastrarFornecedor(f2);  
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ ja Existe");
		}
	}	

	@Test
	public void testaAddFornecedorComCnpjInvalido(){
		Fornecedor f = new Fornecedor("Martins","7B.T25.98b/00B6-1S","Perfumaria","PB");

		try{
			fac.cadastrarFornecedor(f); 
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Invalido");
		}
	}	

	@Test
	public void testaAddFornecedorComEstadoInvalido(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","23");

		try{
			fac.cadastrarFornecedor(f); 
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Estado Invalido");
		}
	}	
	
	@Test
	public void testaPesquisarFornecedorComCnpjInexitente(){
			Fornecedor f = new Fornecedor("Martins", "78.425.986/0036-15", "Perfumaria", "PB" );
		fac.cadastrarFornecedor(f);
		try{
			fac.pesquisarFornecedorPorCnpj("72.426.987/0036-14");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Fornecedor Inexistente");
		}	
	}
	
	@Test
	public void testaPesquisarFornecedorComCnpjVazio(){
		try{
			fac.pesquisarFornecedorPorCnpj("");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Vazio");
		}
	}	
	
	@Test
	public void testaPesquisarFornecedorComCnpjInvalido(){
		try{
			fac.pesquisarFornecedorPorCnpj("000212jpc");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Invalido");
		}
	}

	@Test
	public void testaPesquisarFornecedorComNomeVazio(){
		try{
			fac.pesquisarFornecedorPorNome("");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome Vazio");
		}
	}	

	@Test
	public void testaremoverFornecedorComCnpjVazio(){
		try{
			fac.removerFornecedorPorCnpj(""); 
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Vazio");
		}
	}
	
	@Test
	public void testaRemoverFornecedorComCnpjInvalido(){
		try{
			fac.pesquisarFornecedorPorCnpj("000212jpc");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Invalido");
		}
	}
	
	@Test
	public void testaremoverFornecedorComNomeVazio(){
		try{
			fac.removerFornecedorPorNome(""); 
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome Vazio");
		}
	}

	@Test
	public void testaRemoverFornecedorComCnpjInexistente(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");

		fac.cadastrarFornecedor(f);
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15"));
		try{
			fac.removerFornecedorPorCnpj("79.427.321/0036-15");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "CNPJ Inexistente");
		}
	}

	@Test
	public void testaRemoverFornecedorComNomeInexistente(){
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");

		fac.cadastrarFornecedor(f);
		Assert.assertNotNull(fac.pesquisarFornecedorPorNome("Martins"));

		try{
			fac.removerFornecedorPorNome("Nordesa");
		}catch(FornecedorInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome Inexistente");
		}
	}	

	@Test	
	public void testaCadastrarFornecedor() throws Exceptions{
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");
		Fornecedor f2 = new Fornecedor("Totos","73.325.453/0001-09","Plástico","CE");
		Fornecedor f3 = new Fornecedor ("Reciclatec","70.123.300/0001-99","Suprimentos","RR");
		
		fac.cadastrarFornecedor(f);
		fac.cadastrarFornecedor(f2);
		fac.cadastrarFornecedor(f3);
		
		Assert.assertFalse (fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15").equals
						   (fac.pesquisarFornecedorPorNome("73.325.453/0001-09")));
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15"));
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj("73.325.453/0001-09"));
		Assert.assertEquals(f3, fac.pesquisarFornecedorPorCnpj("70.123.300/0001-99"));
		Assert.assertEquals(f2, fac.pesquisarFornecedorPorNome("Totos"));
		
	}

	@Test	
	public void testaPesquisarFornecedorPorCnpj() throws Exceptions{
		Fornecedor f = new Fornecedor("Marinex","78.425.986/0036-15","Perfumaria","PB");
		Fornecedor f2 = new Fornecedor ("TintasCO","70.123.300/0001-99","Suprimentos","RR");
		Fornecedor f3 = new Fornecedor("PlasticosECia","73.325.453/0001-09","Plástico","CE");

		Assert.assertNull (fac.pesquisarFornecedorPorCnpj(f.getCnpj()));
		
		fac.cadastrarFornecedor(f);
		fac.cadastrarFornecedor(f2);
		fac.cadastrarFornecedor(f3);
		
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj(f2.getCnpj()));
		Assert.assertEquals(f, fac.pesquisarFornecedorPorCnpj(f.getCnpj()));
		Assert.assertFalse(fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15").equals
						  (fac.pesquisarFornecedorPorCnpj("70.123.300/0001-99")));
		Assert.assertEquals(f3, fac.pesquisarFornecedorPorCnpj("73.325.453/0001-09"));
	}

	@Test	
	public void testaPesquisarFornecedorPorNome() throws Exceptions{
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");
	
		Assert.assertNull (fac.pesquisarFornecedorPorNome(f.getNome()));
		fac.cadastrarFornecedor(f);
		Assert.assertEquals(f, fac.pesquisarFornecedorPorNome(f.getNome()));
	}

	@Test
	public void testaRemoverFornecedorPorCnpj() throws Exceptions{
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");
		Fornecedor f2 = new Fornecedor ("TintasCO","70.123.300/0001-99","Suprimentos","RR");

		fac.cadastrarFornecedor(f);
		fac.cadastrarFornecedor(f2);
		
		Assert.assertNotNull(fac.pesquisarFornecedorPorCnpj("78.425.986/0036-15"));
		Assert.assertNotNull (fac.pesquisarFornecedorPorCnpj("70.123.300/0001-99"));
		
		fac.removerFornecedorPorCnpj("78.425.986/0036-15");
		fac.removerFornecedorPorCnpj("70.123.300/0001-99");
		
		Assert.assertEquals(null, fac.pesquisarFornecedorPorCnpj(f.getCnpj()));
		Assert.assertNull (fac.pesquisarFornecedorPorCnpj("70.123.300/0001-99"));
	} 

	 @Test
     public void testaListaDeFornecedoresVazia(){
		 	try{
		 		fac.listaDeFornecedores(); 
			}catch(ListaVaziaException lve){
				assertEquals(lve.getMessage(), "Lista Vazia");
			}
		}	
    
	@Test
	public void testaRemoverFornecedorPorNome() throws Exceptions{
		Fornecedor f = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");
		
		fac.cadastrarFornecedor(f);
		Assert.assertNotNull(fac.pesquisarFornecedorPorNome("Martins"));
		fac.removerFornecedorPorNome("Martins");
		Assert.assertEquals(null, fac.pesquisarFornecedorPorNome("Martins"));
	} 

	 @Test
     public void testaListaDeFornecedores() throws Exceptions{
       
		 try{
			 fac.listaDeFornecedores(); 
		 }
		 catch(ListaVaziaException lve){
			 assertEquals(lve.getMessage(), "Lista Vazia");
		 } 
		 		 
		 Fornecedor f = new Fornecedor("Nordesa","78.426.989/0035-15","Laticineos","PB");
		 fac.cadastrarFornecedor(f);

		 Fornecedor f2 = new Fornecedor("Martins","78.425.986/0036-15","Perfumaria","PB");
		 fac.cadastrarFornecedor(f2);

		 Fornecedor f3 = new Fornecedor("Cia da Terra","78.423.980/0026-05","Naturais","PB");
		 fac.cadastrarFornecedor(f3);

		 Assert.assertEquals(f, fac.pesquisarFornecedorPorNome(f.getNome()));
		 Assert.assertEquals(f2, fac.pesquisarFornecedorPorNome(f2.getNome()));
		 Assert.assertEquals(f3, fac.pesquisarFornecedorPorNome(f3.getNome()));
		 Assert.assertNotNull(fac.listaDeFornecedores());

	 }
}