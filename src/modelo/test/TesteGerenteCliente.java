package modelo.test;

import static org.junit.Assert.assertEquals;
import modelo.lojaVariedades.Fachada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.cliente.ClienteFisico;
import modelo.cliente.ClienteJuridico;
import modelo.exception.ClienteInvalidoException;
import modelo.exception.Exceptions;

public class TesteGerenteCliente {

	private Fachada fac;

	@Before
	public void inicializaFachada() {
		this.fac = new Fachada();
	}

	@Test
	public void testaCadastrarClienteFisicoNull() {
		validarCadastroClienteFisico(null, "Cliente Físico Inválido");
	}
	
	private void validarCadastroClienteFisico(ClienteFisico cf, String mensagem) {
		try {
			fac.cadastrarClienteFisico(cf);
		} catch (ClienteInvalidoException cie) {
			assertEquals(cie.getMessage(), mensagem);
		}
	}

	@Test
	public void testaCadastrarClienteJuridicoNull() {
		validarCadastroClienteJuridico(null, "Cliente Jurídico Inválido");
	}

	private void validarCadastroClienteJuridico(ClienteJuridico cj,
			String mensagem) {
		try {
			fac.cadastrarClienteJuridico(cj);
		} catch (ClienteInvalidoException cie) {
			assertEquals(cie.getMessage(), mensagem);
		}
	}

	@Test
	public void testaCadastrarClienteJuridicoComCnpjInvalido() {
		ClienteJuridico cj = new ClienteJuridico("Julieta", "12A34B567C89",
				"Rua da Areia", "32211123");
		validarCadastroClienteJuridico(cj, "CNPJ Inválido");
	}

	@Test
	public void testaCadastrarClienteFisicoComCpfInvalido() {
		ClienteFisico cf = new ClienteFisico("Maria", "12A34B5C", "32211123");
		validarCadastroClienteFisico(cf, "CPF Inválido");
	}

	@Test
	public void testaCadastrarClienteFisicoComCpfVazio() {

		ClienteFisico cf = new ClienteFisico("Maria", "", "32211123");
		validarCadastroClienteFisico(cf, "CPF Vazio");
	}

	@Test
	public void testaCadastrarClienteJuridicoComCnpjVazio() {

		ClienteJuridico cj = new ClienteJuridico("Julieta", "", "Rua da Areia",
				"32211123");
		validarCadastroClienteJuridico(cj, "CNPJ Vazio");
	}

	@Test
	public void testaCadastrarClienteFisicoComNomeVazio() {

		ClienteFisico cf = new ClienteFisico("", "12345", "32211123");
		validarCadastroClienteFisico(cf, "Nome Vazio");
	}

	@Test
	public void testaCadastrarClienteJuridicoComNomeVazio() {

		ClienteJuridico cj = new ClienteJuridico("", "12A34B567C89",
				"Rua da Areia", "32211123");
		validarCadastroClienteJuridico(cj, "Nome Vazio");
	}

	// não precisa criar os metodos, porque os testes são poucos
	@Test
	public void TestaCancelarCadastroClienteFisicoComCpfInvalido() {
		try {
			fac.cancelarCadastroClienteFisico("1a");
		} catch (ClienteInvalidoException cie) {
			assertEquals(cie.getMessage(), "CPF Inválido");
		}
	}

	@Test
	public void testaCancelarCadastroClienteJuridicoComCnpjInvalido() {
		try {
			fac.cancelarCadastroClienteJuridico("1a");
		} catch (ClienteInvalidoException cie) {
			assertEquals(cie.getMessage(), "CNPJ Inválido");
		}
	}

	@Test
	public void testPesquisarClienteFisicoComCpfVazio() {
		try {
			fac.pesquisarClienteFisico(" ");
		} catch (ClienteInvalidoException pie) {
			assertEquals(pie.getMessage(), "CPF Vazio");
		}
	}

	@Test
	public void testPesquisarClienteFisicoComCpfInvalido() {
		try {
			fac.pesquisarClienteFisico("1234adf");
		} catch (ClienteInvalidoException pie) {
			assertEquals(pie.getMessage(), "CPF Invalido");
		}
	}

	@Test
	public void testPesquisarClienteJuridicoComCNPJVazio() {
		try {
			fac.pesquisarClienteJuridico(" ");
		} catch (ClienteInvalidoException pie) {
			assertEquals(pie.getMessage(), "CNPJ Vazio");
		}
	}

	@Test
	public void testPesquisarClienteFisicoComCNPJInvalido() {
		try {
			fac.pesquisarClienteFisico("58223xcV");
		} catch (ClienteInvalidoException pie) {
			assertEquals(pie.getMessage(), "CNPJ Invalido");
		}
	}

	@Test
	public void cadastrarClienteFisicoTest() throws Exceptions {

		ClienteFisico maria = new ClienteFisico("Maria", "12345", "32211123");
		ClienteFisico joao = new ClienteFisico("Joao", "54321", "32211123");
		ClienteFisico antonia = new ClienteFisico("Antonia", "98765","32211123");
		
		fac.cadastrarClienteFisico(maria);
		fac.cadastrarClienteFisico(joao);
		fac.cadastrarClienteFisico(antonia);

		Assert.assertNotNull(fac.pesquisarClienteFisico("12345"));
		Assert.assertEquals(maria, fac.pesquisarClienteFisico("12345"));
		Assert.assertNotNull(fac.pesquisarClienteFisico("54321"));
		Assert.assertNotNull(fac.pesquisarClienteFisico("98765"));

		Assert.assertFalse(fac.pesquisarClienteFisico(maria.getCpf()).equals(
				fac.pesquisarClienteFisico(antonia.getCpf())));
		Assert.assertFalse(fac.pesquisarClienteFisico(joao.getCpf()).equals(
				fac.pesquisarClienteFisico(antonia.getCpf())));
		Assert.assertNotSame(fac.pesquisarClienteFisico(maria.getCpf()),
				(fac.pesquisarClienteFisico(joao.getCpf())));
		Assert.assertNotSame(null, joao.getCpf());
	}

	@Test
	public void cadastrarClienteJuridicoTest() throws Exceptions {

		ClienteJuridico julieta = new ClienteJuridico("Julieta", "123456789",
				"Rua da Areia", "32211123");
		ClienteJuridico joana = new ClienteJuridico("Joana", "987654321",
				"Rua da Areia", "32211123");
		ClienteJuridico toinha = new ClienteJuridico("Toinha", "192837465",
				"Rua da Areia", "32211123");

		Assert.assertNull(fac.pesquisarClienteJuridico("123456789"));
		Assert.assertNull(fac.pesquisarClienteJuridico("987654321"));
		Assert.assertNull(fac.pesquisarClienteJuridico("192837465"));

		fac.cadastrarClienteJuridico(julieta);
		fac.cadastrarClienteJuridico(joana);
		fac.cadastrarClienteJuridico(toinha);

		Assert.assertNotNull(fac.pesquisarClienteJuridico("123456789"));
		Assert.assertEquals(julieta, fac.pesquisarClienteJuridico("123456789")); 
		Assert.assertNotNull(fac.pesquisarClienteJuridico("987654321"));
		Assert.assertNotNull(fac.pesquisarClienteJuridico("192837465"));

		Assert.assertFalse(fac.pesquisarClienteJuridico(julieta.getCnpj())
				.equals(toinha.getCnpj()));
		Assert.assertFalse(fac.pesquisarClienteJuridico(joana.getCnpj())
				.equals(toinha.getCnpj()));
		Assert.assertNotSame(fac.pesquisarClienteJuridico(julieta.getCnpj()),
				fac.pesquisarClienteFisico(joana.getCnpj()));
	}

	@Test
	public void pesquisarClienteFisico() {
		ClienteFisico maria = new ClienteFisico("Maria", "12345", "32211123");
		fac.cadastrarClienteFisico(maria);

		Assert.assertEquals(maria, fac.pesquisarClienteFisico("12345"));
	}

	@Test
	public void pesquisarClienteJuridico() {
		ClienteJuridico joana = new ClienteJuridico("Joana", "987654321",
				"Rua da Areia", "32211123");
		fac.cadastrarClienteJuridico(joana);

		Assert.assertEquals(joana, fac.pesquisarClienteJuridico("987654321"));
	}

	@Test
	public void cancelarCadastroClienteFisicoTest() throws Exceptions {

		Assert.assertNull(fac.ListaDeClientesFisicos());

		ClienteFisico juliana = new ClienteFisico("Juliana", "12345",
				"32211123");
		ClienteFisico damiana = new ClienteFisico("Damiana", "54321",
				"32211123");

		fac.cadastrarClienteFisico(juliana);
		fac.cadastrarClienteFisico(damiana);
		Assert.assertEquals(juliana, fac.pesquisarClienteFisico("12345"));
		Assert.assertNotNull(null, fac.pesquisarClienteFisico("54321"));

		fac.cancelarCadastroClienteFisico("12345");
		fac.cancelarCadastroClienteFisico("54321");

		Assert.assertNull(fac.ListaDeClientesFisicos());
		Assert.assertEquals(null, fac.pesquisarClienteFisico("12345"));
		Assert.assertEquals(null, fac.pesquisarClienteFisico("54321"));
	}

	@Test
	public void removerClienteJuridicoTest() throws Exceptions {

		Assert.assertNull(fac.ListaDeClientesJuridicos());

		ClienteJuridico julieta = new ClienteJuridico("Julieta", "123456789",
				"Rua Padre Zé", "32211123");
		ClienteJuridico joana = new ClienteJuridico("Joana", "987654321",
				"Rua Padre Zé", "32211123");

		fac.cadastrarClienteJuridico(joana);
		fac.cadastrarClienteJuridico(julieta);

		Assert.assertEquals(julieta, fac.pesquisarClienteJuridico("123456789"));
		Assert.assertNotNull(null, fac.pesquisarClienteJuridico("987654321"));

		fac.cancelarCadastroClienteJuridico("123456789");
		fac.cancelarCadastroClienteJuridico("987654321");

		Assert.assertNull(fac.ListaDeClientesJuridicos());
		Assert.assertNull(fac.pesquisarClienteJuridico(joana.getCnpj()));
		Assert.assertEquals(null,
				fac.pesquisarClienteJuridico(julieta.getCnpj()));

	}

	@Test
	public void listaDeClientesFisicosTest() throws Exceptions {

		Assert.assertNull(fac.ListaDeClientesFisicos());

		ClienteFisico juliana = new ClienteFisico("Juliana", "12345",
				"32211123");
		ClienteFisico damiana = new ClienteFisico("damiana", "54321",
				"32211123");

		fac.cadastrarClienteFisico(juliana);
		fac.cadastrarClienteFisico(damiana);

		Assert.assertNotNull(fac.ListaDeClientesFisicos());
		Assert.assertNotNull(fac.ListaDeClientesFisicos());
		Assert.assertNotNull(fac.pesquisarClienteFisico("12345"));
		Assert.assertFalse(fac.pesquisarClienteFisico("12345").equals(
				fac.pesquisarClienteFisico("54321")));
	}

	@Test
	public void listaDeClientesJuridicos() throws Exceptions {

		Assert.assertNull(fac.ListaDeClientesJuridicos());

		ClienteJuridico julieta = new ClienteJuridico("Julieta", "123456789",
				"Rua da Aurora", "32211123");
		ClienteJuridico joana = new ClienteJuridico("Joana", "987654321",
				"Rua da Aurora", "32211123");

		fac.cadastrarClienteJuridico(joana);
		fac.cadastrarClienteJuridico(julieta);

		Assert.assertNotNull(fac.ListaDeClientesJuridicos());
		Assert.assertNotNull(fac.pesquisarClienteJuridico("123456789"));
		Assert.assertFalse(fac.pesquisarClienteJuridico("123456789").equals(
				fac.pesquisarClienteJuridico("987654321")));

	}
}