package br.com.sefaz.repository;

import br.com.sefaz.model.Usuario;

public interface IDaoUsuario {
	
	Usuario consultarUsuario(String nome, String senha);
	

}
