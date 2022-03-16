package br.com.sefaz.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.sefaz.dao.Dao;
import br.com.sefaz.model.Usuario;

@Named
public class LoginBean {

	private Dao dao = new Dao();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = dao.getUsuario(usuario.getNome(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário e/ou senha não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/cadastro";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
