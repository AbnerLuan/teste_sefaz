package br.com.sefaz.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.sefaz.model.Usuario;

public class DaoUsuario<E> extends Dao<Usuario> {
	
	
	public void removerUsario(Usuario pessoa) throws Exception{
		getEntityManager().getTransaction().begin();

		getEntityManager().remove(pessoa);
		
		getEntityManager().getTransaction().commit();
		
	}

	public List<Usuario> pesquisar(String campoPesquisa) {
		
		Query query  = super.getEntityManager().createQuery("from Usuario where nome like '%"+campoPesquisa+"%' ");
		
		return query.getResultList();
	}

}