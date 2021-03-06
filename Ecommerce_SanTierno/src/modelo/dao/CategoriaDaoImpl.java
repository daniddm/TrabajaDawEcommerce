package modelo.dao;

import java.util.List;

import modelo.beans.Categoria;

public class CategoriaDaoImpl extends AbstracDao implements IntCategoriaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAll() {
		sql = "SELECT c FROM Categoria c" ;//consulta sql
		query = em.createQuery(sql); 
		return query.getResultList();
	}

}
