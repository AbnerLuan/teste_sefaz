package br.com.sefaz.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioService {

	public static EntityManagerFactory factory = null;

	static {
		init();
	}

	private static void init() {

		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("teste_sefaz");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	// Retornar a chave primaria
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);

	}

}
