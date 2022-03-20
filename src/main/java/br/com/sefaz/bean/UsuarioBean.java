package br.com.sefaz.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sefaz.dao.Dao;
import br.com.sefaz.model.Usuario;
import br.com.sefaz.repository.IDaoUsuario;
import br.com.sefaz.repository.IDaoUsuarioImpl;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Dao<Usuario> dao = new Dao<Usuario>();
	private List<Usuario> list = new ArrayList<Usuario>();

	private IDaoUsuario iDaoUsuario = new IDaoUsuarioImpl();

	public String salvar() {
		dao.salvar(usuario);
		usuario = new Usuario();
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

	public List<Usuario> getList() {
		list = dao.listar(Usuario.class);
		return list;
	}

	public String remover() {
		dao.deletarPorId(usuario);
		usuario = new Usuario();
		return "";
	}

	public String logar() {

		Usuario usuarioUser = iDaoUsuario.consultarUsuario(usuario.getNome(), usuario.getSenha());
		if (usuarioUser != null) {// usuario existente

			return "cadastro.xhtml";
		}

		return "index.xhtml";
	}

}
