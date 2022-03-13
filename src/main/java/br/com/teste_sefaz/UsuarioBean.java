package br.com.teste_sefaz;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.teste_sefaz.dao.Dao;
import br.com.teste_sefaz.model.Usuario;

@ViewScoped 
@Named("usuarioBean")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Dao<Usuario> dao = new Dao<Usuario>();

	public String salvar() {
		dao.salvar(usuario);

		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dao<Usuario> getDao() {
		return dao;
	}

	public void setDao(Dao<Usuario> dao) {
		this.dao = dao;
	}

}
