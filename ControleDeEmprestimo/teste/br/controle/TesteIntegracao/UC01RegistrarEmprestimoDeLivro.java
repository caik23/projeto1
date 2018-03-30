package br.controle.TesteIntegracao;

import static org.junit.Assert.*;

import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import br.controle.modelo.Livro;
import br.controle.modelo.Usuario;
import br.controle.modelo.Emprestimo;
import Servico.ServicoEmprestimo;

public class UC01RegistrarEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	 * Verifica o comportamento da classe servico metodo empresta
	 */
	@Test
	public void CT01UC01FB_registra_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		assertNotNull(servico.empresta(null, usuario));
	}

	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos() {
		try {
			servico.empresta(null, usuario);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}
	
	@Test
	public void CTO5Verificar_o_metodo_getIsbn(){
		assertEquals("121212", livro.getIsbn());
	}
	
	@Test
	public void CTO6Verificar_o_metodo_getTitulo(){
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CTO7Verificar_o_metodo_getAutor(){
		assertEquals("Pressman", livro.getAutor());
	}
	
	@Test(expected = RuntimeException.class)
	public void CTO8Verificar_nome_getNome(){
		livro.setIsbn(null);
	}
	
	@Test
	public void CTO9Verificar_ra_getRa(){
		assertEquals("11111", usuario.getRa());
	}
	
	@Test
	public void CT10Verificar_nome_getNome(){
		assertEquals("Jose da Silva", usuario.getNome());
	}
	
	@Test(expected = RuntimeException.class)
	public void CT11Verificar_metodo_equals(){
		assertFalse(usuario.equals(null));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT12Verificar_metodo_equals(){
		Usuario usuario2 = new Usuario(); 
		usuario2.setNome("Alan");
		usuario2.setRa("12345");
		assertFalse(usuario.equals(usuario2));
	}

	@Test(expected = RuntimeException.class)
	public void CT13Verificar_metodo_equals(){
		assertFalse(usuario.equals(usuario));
	}
	

	@Test(expected = RuntimeException.class)
	public void CT14Verificar_metodo_equals(){
		
		Usuario usuario2 = new Usuario(); 
		usuario2.setNome(null);
		usuario2.setRa(null);
		
		Usuario usuario3 = new Usuario(); 
		usuario3.setNome(null);
		usuario3.setRa(null);
		
		assertFalse(usuario2.equals(usuario3));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT15Verificar_metodo_equals(){
		
		Usuario usuario2 = new Usuario(); 
		usuario2.setNome(null);
		usuario2.setRa(null);
		
		Usuario usuario3 = new Usuario(); 
		usuario3.setNome(null);
		usuario3.setNome("alan");
		
		assertFalse(usuario2.equals(usuario3));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT16Verificar_metodo_equals(){

		assertFalse(usuario.equals(livro));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT17Verificar_metodo_equals(){

		assertFalse(usuario.getNome().equals(usuario.getNome()));
	}

	@Test
	public void CT18UC01FB_getLivro() {
		assertNotNull(emprestimo.getLivro().equals(emprestimo.getLivro()));
	}


}
