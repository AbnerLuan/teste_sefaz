package br.com.sefaz.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sefaz.dao.DaoTelefones;
import br.com.sefaz.dao.DaoUsuario;
import br.com.sefaz.model.TelefoneUser;
import br.com.sefaz.model.Usuario;

@Named
@ViewScoped
public class TelefoneBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario user = new Usuario();
	private DaoUsuario<Usuario> daoUser = new DaoUsuario<Usuario>();
	private DaoTelefones<TelefoneUser> daoTelefone = new DaoTelefones<TelefoneUser>();

	private TelefoneUser telefone = new TelefoneUser();

	@PostConstruct
	public void init() {

		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("codigouser");
		user = daoUser.pesquisar(Long.parseLong(coduser), Usuario.class);

	}

	public String salvar() {
		telefone.setUsuario(user);
		daoTelefone.updateMerge(telefone);
		telefone = new TelefoneUser();
		user = daoUser.pesquisar2(user.getId(), Usuario.class);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Salvo com sucesso!"));

		return "";
	}

	public String removeTelefone() throws Exception {

		daoTelefone.deletarPorId(telefone);
		user = daoUser.pesquisar2(user.getId(), Usuario.class);
		telefone = new TelefoneUser();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Telefone Removido!"));
		return "";
	}

	public void setTelefone(TelefoneUser telefone) {
		this.telefone = telefone;
	}

	public TelefoneUser getTelefone() {
		return telefone;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Usuario getUser() {
		return user;
	}

	public void setDaoTelefone(DaoTelefones<TelefoneUser> daoTelefone) {
		this.daoTelefone = daoTelefone;
	}

	public DaoTelefones<TelefoneUser> getDaoTelefone() {
		return daoTelefone;
	}
}