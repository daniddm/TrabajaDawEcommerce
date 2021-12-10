package modelo.dao;

import modelo.beans.Perfil;


public interface IntPerfilDao {
	 int altaPerfil (Perfil perfil);
	 Perfil findById(int idPerfil);
	 int bajaPerfil (Perfil perfil);

}
