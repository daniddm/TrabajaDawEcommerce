package modelo.dao;

import modelo.beans.Perfil;

public class PerfilDaoImpl extends AbstracDao implements IntPerfilDao{

	@Override
	public int altaPerfil(Perfil perfil) {
		int filas = 0; 
		try { 
			tx.begin(); 
			em.persist(perfil); 
			tx.commit(); 
			filas = 1; 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return filas; 
	}
	

	@Override
	public Perfil findById(int idPerfil) {
		return em.find(Perfil.class,idPerfil);
	}


	@Override
	public int bajaPerfil(Perfil perfil) {
		int filas=0;
		if (findById(perfil.getIdPerfil()) != null){
		try {
			tx.begin();
			em.remove(perfil);
			tx.commit();
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
		return filas;
	}

}
