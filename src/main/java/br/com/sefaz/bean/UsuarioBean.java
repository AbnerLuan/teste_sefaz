package br.com.sefaz.bean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.google.gson.Gson;

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

	public void pesquisaCep(AjaxBehaviorEvent event) {
		try {

			URL url = new URL("https://viacep.com.br/ws/" + usuario.getCep() + "/json/");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			String cep = "";
			StringBuilder jsonCep = new StringBuilder();

			while ((cep = br.readLine()) != null) {
				jsonCep.append(cep);
			}
			Usuario userCep = new Gson().fromJson(jsonCep.toString(), Usuario.class);

			usuario.setCep(userCep.getCep());
			usuario.setLogradouro(userCep.getLogradouro());
			usuario.setLocalidade(userCep.getLocalidade());
			usuario.setBairro(userCep.getBairro());
			usuario.setUf(userCep.getUf());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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

		usuario = new Usuario();
	      FacesContext.getCurrentInstance().addMessage(
	         null,
	         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
	           "Erro no Login!"));
	      return null;
	}

}
