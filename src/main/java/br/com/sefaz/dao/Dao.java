package br.com.sefaz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.com.sefaz.model.Usuario;
import br.com.sefaz.service.UsuarioService;

public class Dao<E> {

	private EntityManager entityManager = UsuarioService.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}

	// Salvar ou atualizar
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();

		return entidadeSalva;
	}

	public E pesquisar1(E entidade) {
		Object id = UsuarioService.getPrimaryKey(entidade);

		E e = (E) entityManager.find(entidade.getClass(), id);

		return e;
	}

	public E pesquisar(Long id, Class<E> entidade) {

		E e = (E) entityManager.find(entidade, id);

		return e;
	}

	public void deletarPorId(E entidade) {
		Object id = UsuarioService.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id)
				.executeUpdate();
		transaction.commit();
	}

	public List<E> listar(Class<E> entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();

		return lista;
	}

}
