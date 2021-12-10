package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.beans.Producto;


public class ProductoDaoImpl extends AbstracDao implements IntProductoDao {

	@Override
	public int altaProducto(Producto producto) {
		int filas = 0; 
		try { 
			tx.begin(); 
			em.persist(producto); 
			tx.commit(); 
			filas = 1; 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return filas; 
	}

	@Override
	public int updateProducto(Producto producto) {
		int filas=0;
		try {
			tx.begin();//Comienzo la  transacción
			em.merge(producto);//Consulta a realizar.Actualizar---MERGE()
			tx.commit();//Confirmo transacción comenzada
			filas=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Producto findById(int idProducto) {
		return em.find(Producto.class,idProducto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByProducto(String nombre, String descripcion) {
		sql = "SELECT p FROM Producto p WHERE p.nombre =:cod1 AND p.descripcion =:cod2"; //consulta sql
		query = em.createQuery(sql); 
		query.setParameter("cod1", nombre); 
		query.setParameter("cod2", descripcion); 
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findByAll() {
		sql = "SELECT p FROM Producto p" ;//consulta sql
		query = em.createQuery(sql); 
		return query.getResultList();
	}



}
