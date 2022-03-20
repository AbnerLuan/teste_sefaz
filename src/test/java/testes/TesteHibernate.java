package testes;

import java.util.List;

import org.junit.Test;

import br.com.sefaz.dao.Dao;
import br.com.sefaz.model.TelefoneUser;
import br.com.sefaz.model.Usuario;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		Dao<Usuario> dao = new Dao<Usuario>();

		Usuario usuario = new Usuario();

		usuario.setNome("maria");
		usuario.setEmail("maria@email.com");
		usuario.setSenha("maria");

		dao.salvar(usuario);
	}

	@Test
	public void testeBuscar() {
		Dao<Usuario> dao = new Dao<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setId(2L);
		usuario = dao.pesquisar(usuario);

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

	@Test
	public void testeGravaTelefone() {
		Dao dao = new Dao();

		Usuario pessoa = (Usuario) dao.pesquisar(40L, Usuario.class);

		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("residencial");
		telefoneUser.setDdd("11");
		telefoneUser.setNumero("45954595");
		telefoneUser.setUsuario(pessoa);

		dao.salvar(telefoneUser);

	}

	@Test
	public void testeConsultarTelefones() {
		Dao dao = new Dao();

		Usuario pessoa = (Usuario) dao.pesquisar(40L, Usuario.class);

		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getDdd());
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuario().getNome());
			System.out.println("---------------------------------------------------");
		}

	}

}