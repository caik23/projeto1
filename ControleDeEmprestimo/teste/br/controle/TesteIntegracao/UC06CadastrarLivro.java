package br.controle.TesteIntegracao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.controle.modelo.Livro;
import br.controle.modelo.Usuario;

public class UC06CadastrarLivro {
	static private Livro livro;
	static private Usuario usuario;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		livro = new Livro();
		livro.setIsbn("121121");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@BeforeClass
	public static void setUpBeforeClass2() throws Exception{
		usuario = new Usuario();
		usuario.setRa("156156");
		usuario.setNome("João do Caminhão");
	}
	
	
	@Test(expected=RuntimeException.class)
	public void CT01UC06CadastrarLivro_titulo_invalido() {
		livro.setTitulo("");
	}
	
	
	@Test(expected=RuntimeException.class)
	public void CT02UC06CadastrarLivro_titulo_invalido() {
		livro.setTitulo(null);
	}
	
	@Test(expected=RuntimeException.class)
	public void CT03UC06Cadastrar_Usuario_invalido() {
		if(usuario.getNome().equals(null)|usuario.getNome().equals("")){
			
		}
		
	}
	

}
