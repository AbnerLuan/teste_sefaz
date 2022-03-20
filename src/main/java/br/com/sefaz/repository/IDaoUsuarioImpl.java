package br.com.sefaz.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sefaz.model.Usuario;
import br.com.sefaz.service.UsuarioService;

public class IDaoUsuarioImpl implements IDaoUsuario {

	@Override
	public Usuario consultarUsuario(String nome, String senha) {

		Usuario usuario = null;

		EntityManager entityManager = UsuarioService.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		usuario = (Usuario) entityManager
				.createQuery("SELECT u from Usuario u where u.nome = :nome and u.senha = :senha")
				.setParameter("nome", nome).setParameter("senha", senha).getSingleResult();

		transaction.commit();
		entityManager.close();

		return usuario;
	}

}
