package br.com.teste_sefaz;


import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.teste_sefaz.dao.Dao;
import br.com.teste_sefaz.model.Usuario;



@Named
@RequestScoped
public class UsuarioBean {
	@Inject
	private Usuario pessoa = new Usuario();
	@Inject
	private Dao<Usuario> dao = new Dao<Usuario>();

	public String salvar() {
		dao.salvar(pessoa);
		return "";
	}

	public Usuario getPessoa() {
		return pessoa;
	}

	public void setPessoa(Usuario pessoa) {
		this.pessoa = pessoa;
	}

	public Dao<Usuario> getDao() {
		return dao;
	}

	public void setDaoGeneric(Dao<Usuario> daoGeneric) {
		this.dao = daoGeneric;
	}

}
