package modelo.test;


import static org.junit.Assert.assertEquals;
import modelo.lojaVariedades.Fachada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.exception.FuncionarioInvalidoException;
import modelo.funcionario.Funcionario;

public class TesteGerenteFuncionario {
	private Fachada fac;
	
	@Before
	public void inicializaFachada(){
		this.fac = new Fachada();
	}
	private void addFuncionario(Funcionario f, String mensagem){
		try{
			fac.addFuncionario(f);
		}catch (FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), mensagem);
		}
	}
	
	@Test
	public void testaAddFuncionarioNull(){
		addFuncionario (null, "Funcionário Inválido" );
	}
    
	@Test		
	public void testaAddFuncionarioComCpfVazio(){
		Funcionario f = new Funcionario("Joao", " ", "32211233", "21", "Rua da Aurora");
		addFuncionario (f, "CPF Vazio");

	}
	
	@Test
	public void testaAddrFuncionarioComCpfInvalido(){
	
		Funcionario f = new Funcionario("Maria", "1a", "32211233", "21", "Rua da Aurora");
		addFuncionario (f, "CPF InvÃ¡lido" );
	}
    
	@Test		
	public void testaAddFuncionarioComNomeVazio(){
		Funcionario f = new Funcionario(" ", "123", "32211233", "21", "Rua da Aurora");
		addFuncionario (f, "Nome Vazio");
		
	}
	
	@Test		
	public void testaAddFuncionarioComTelefoneVazio(){
		Funcionario f = new Funcionario("Joao", "123", " ", "21", "Rua da Aurora");
		addFuncionario (f, "Telefone Vazio");

	}
	
	@Test		
	public void testaAddFuncionarioComTelefoneInvalido(){
		Funcionario f = new Funcionario("Joao", "123", "322123ai", "21", "Rua da Aurora");
		addFuncionario (f, "Telefone Invalido");

	}
	
	@Test		
	public void testaAddFuncionarioComEnderecoInvalido(){
		Funcionario f = new Funcionario("Joao", "123", "32212323", "21", " ");
		addFuncionario (f, "Endereço Invalido");

	}
	
	@Test		
	public void testaPesquisarFuncionarioComNomeVazio(){
        try{
			fac.pesquisarFuncionario("");
        }
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome Vazio");
		}
		}
    
        @Test		
    	public void testaPesquisarFuncionarioCpfVazio(){
            try{
    			fac.pesquisarFuncionarioPorCpf(" ");

    		}
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "CPF Vazio");
		}
	}
        
        @Test		
    	public void testaPesquisarFuncionarioCpfInvalido(){
            try{
    			fac.pesquisarFuncionarioPorCpf("12345asd");

    		}
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "CPF Invalido");
		}
	}

	@Test		
	public void testaRemoverFuncionarioComNomeVazio(){
        try{
			fac.pesquisarFuncionario(" ");

		}
    
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "Nome Vazio");
		}
	}
	
	@Test		
	public void testaRemoverFuncionarioComCpfVazio(){
        try{
			fac.pesquisarFuncionario(" ");

		}
    
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "CPF Vazio");
		}
	}

	@Test		
	public void testaRemoverFuncionarioComCpfInvalido(){
        try{
			fac.pesquisarFuncionario("123abcd");

		}
    
        catch(FuncionarioInvalidoException fie){
			assertEquals(fie.getMessage(), "CPF Invalido");
		}
	}
	
	@Test
	public void addFuncionarioTest() {

		Funcionario f = new Funcionario("Rodrigo", "12349202921","32212223", "29","Rua da Mangueira");
		Funcionario f2 = new Funcionario("Mariano", "91029384950","32221234", "90","Rua da Forum");
		Funcionario f3 = new Funcionario("Paulo", "34102930497","32212223", "01","Rua da Tambor");
		
		Assert.assertNull(fac.pesquisarFuncionario("Rodrigo"));
		fac.addFuncionario(f);
		fac.addFuncionario(f2);
		fac.addFuncionario(f3);

		Funcionario ft = fac.pesquisarFuncionario(f.getNome());
		Assert.assertEquals(f, ft);
		
		Assert.assertNotNull(fac.pesquisarFuncionario("Mariano"));
		Assert.assertFalse(fac.pesquisarFuncionario(f2.getNome()).equals
				          (fac.pesquisarFuncionario(f3.getNome())));
	}

	@Test
	public void PesquisarFuncionarioTest (){
		Funcionario f = new Funcionario("Maria", "12345", "123456", "21", "Rua da Mangueira");
		
		fac.addFuncionario(f);
		
		Assert.assertEquals(f, fac.pesquisarFuncionario("Maria"));	
	}
	
	@Test
	public void removerFuncionario() {

        Funcionario f = new Funcionario("Paulo", "1234","32212223", "28", "Rua da Aurora");
		this.fac.addFuncionario(f);

		Assert.assertTrue(this.fac.removerFuncionario(f.getNome()));
		Assert.assertNull (fac.pesquisarFuncionario(f.getNome()));
	}
	
	@Test
	public void removerFuncionarioPorCpf() {

        Funcionario f = new Funcionario("Ozonias", "1233434","34314623", "28", "Rua Projetada");
		this.fac.addFuncionario(f);
		
		Assert.assertFalse (f.getCpf().equals(fac.pesquisarFuncionario(f.getNome())));
	}

	@Test
	public void TelefoneFuncionario() {

        Funcionario f = new Funcionario("Flavio", "12345","32212223", "31","Rua da Aurora");
		this.fac.addFuncionario(f);
		Funcionario ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("32212223", ft.getTelefone());
	}

	@Test
	public void MudarTelefone() {

        Funcionario f = new Funcionario("Flavio", "12345","32212223", "31","Rua da Aurora");
        
		this.fac.addFuncionario(f);
		Funcionario ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("32212223", ft.getTelefone());
		ft.setTelefone("3333");

		ft = this.fac.pesquisarFuncionario(f.getNome());
		Assert.assertEquals("3333", ft.getTelefone());
	}

	@Test
	public void CpfFuncionario() {

        Funcionario f = new Funcionario("Flavio", "06402220485","32212223", "31","Rua da Aurora");

		this.fac.addFuncionario(f);
		Funcionario ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("06402220485", ft.getCpf());
	}

	@Test
	public void MudarCpf() {

        Funcionario f = new Funcionario("Flavio", "06402220485","32212223", "31","Rua da Aurora");

		this.fac.addFuncionario(f);
		Funcionario ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("06402220485", ft.getCpf());
		ft.setCpf("00623023408");

		ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("00623023408", ft.getCpf());
	}

	@Test
	public void IdadeFuncionario() {

        Funcionario f = new Funcionario("Flavio", "1234","32212223", "23","Rua da Aurora");

		this.fac.addFuncionario(f);
		Funcionario ft = this.fac.pesquisarFuncionario(f.getNome());

		Assert.assertEquals("23", ft.getIdade());
	}
	
}