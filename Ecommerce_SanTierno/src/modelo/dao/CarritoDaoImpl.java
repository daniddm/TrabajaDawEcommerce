package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.beans.Carrito;
import modelo.beans.CarritoPK;
import modelo.beans.Usuario;


public class CarritoDaoImpl extends AbstracDao implements IntCarritoDao {

	@Override
	public int altaCarrito(Carrito carrito) {
		
		int filas = 0; //Si el usuario no existe
		try { //intentar
			tx.begin(); //hacer la transacci?n 
			em.persist(carrito); //Definimos la transacci?n con em + m?todo()
			tx.commit(); //Confirmamos la transacci?n comenzada
			filas = 1; //y decimos que ahora la fila ya tiene un valor
		} catch (Exception e) { //hacemos la excepci?n
			e.printStackTrace();
		} 
		return filas; //y retornamos las filas
	}

	@SuppressWarnings("unchecked")
	@Override
	public Carrito findById(int idUsuario, int idProducto) {
		sql = "SELECT c FROM Carrito c WHERE c.usuario.idUsuario =:cod1 AND c.producto.idProducto =:cod2"; //consulta sql
		query = em.createQuery(sql); 
		query.setParameter("cod1", idUsuario); 
		query.setParameter("cod2", idProducto); 
		List<Object> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}else {
			return (Carrito) results.get(0);
		}
	
	}

	
	@SuppressWarnings("unchecked")
	public List<Carrito> findByAll() {
		sql = "select c from Carrito c";
		query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public int updateCarrito(Carrito carrito) {
		carrito.setCantidad(carrito.getCantidad()+ 1);
		int filas = 0; //Si el usuario no existe
		try { //intentar
			tx.begin(); //hacer la transacci?n 
			em.merge(carrito); //Definimos la transacci?n con em + m?todo()
			tx.commit(); //Confirmamos la transacci?n comenzada
			filas = 1; //y decimos que ahora la fila ya tiene un valor
		} catch (Exception e) { //hacemos la excepci?n
			e.printStackTrace();
		} 
		return filas; //y retornamos las filas
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrito> findByUsuario(int idUsuario) {
		sql = "select c from Carrito c WHERE c.usuario.idUsuario  =:cod1";
		query = em.createQuery(sql);
		query.setParameter("cod1", idUsuario);
		return query.getResultList();
	}

	@Override
	public Carrito findById(int idUsuario) {
		return em.find(Carrito.class, idUsuario);
	}

	@Override
	public int bajaCarrito(Carrito carrito) {
		int filas=0;
		if (findByUsuario(carrito.getUsuario().getIdUsuario()) != null){
		try {
			tx.begin();
			em.remove(carrito);
			tx.commit();
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
		return filas;
	}
	
	public void borrarProductoCarrito(int idUsuario, int idProducto) {
		
		// Creamos la query con los par?metros necesarios.
		sql = "DELETE FROM Carrito c WHERE c.usuario.idUsuario=:cod1 AND c.producto.idProducto=:cod2";
		query = em.createQuery(sql);
		query.setParameter("cod1", idUsuario);
		query.setParameter("cod2", idProducto);
		
		// Iniciamos la transacci?n.
		tx.begin();
		// Ejecutamos la consulta.
		int result = query.executeUpdate();
		// Hacemos commit (confirmamos la consulta).
		tx.commit();
				
	}

}
