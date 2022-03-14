package br.com.teste_sefaz;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.teste_sefaz.dao.Dao;
import br.com.teste_sefaz.model.Usuario;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		Dao<Usuario> dao = new Dao<Usuario>();

		Usuario usuario = new Usuario();

		usuario.setNome("Jecircleide");
		usuario.setEmail("jecircleide@email.com");
		usuario.setSenha("jecircleide123");

		dao.salvar(usuario);
	}

	@Test
	public void testeBuscar() {
		Dao<Usuario> dao = new Dao<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setId(2L);
		usuario = dao.pesquisar1(usuario);
		
		System.out.println(usuario);

	}
	
	@Test
	public void testeBuscar2() {
		Dao<Usuario> dao = new Dao<Usuario>();
		
		Usuario usuario = dao.pesquisar(2L, Usuario.class);
		
		System.out.println(usuario);

	}
	
	@Test
	public void testeUpdate() {
		Dao<Usuario> dao = new Dao<Usuario>();
		
		Usuario usuario = dao.pesquisar(2L, Usuario.class);
		
		usuario.setSenha("admin");
		
		usuario = dao.updateMerge(usuario);
		
		System.out.println(usuario);

	}
	
	
	@Test
	public void testeDelete() {
		Dao<Usuario> dao = new Dao<Usuario>();
		
		Usuario usuario = dao.pesquisar(1L, Usuario.class);
		
		dao.deletarPorId(usuario);

	}
	
	@Test
	public void testeConsultar() {
		Dao<Usuario> dao = new Dao<Usuario>();
		
		List<Usuario> list = dao.listar(Usuario.class);
				
		for (Usuario usuario : list) {
			System.out.println(usuario);
			System.out.println("-------------------------");
		}
	

	}
	
	
	
}