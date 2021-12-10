package modelo.dao;


import java.util.List;

import modelo.beans.Usuario;

public interface IntUsuarioDao {
	int altaUsuario (Usuario usuario); //función para dar de alta un usuario
	List<Usuario> findByUser( String email,String password ); //y otra función para buscar el usuario y la contraseña
	Usuario findById (int id_Usuario);
	List<Usuario> findByAll();
	Usuario findByEmail (String email);
	Boolean checkLogin (String email, String password);
}
