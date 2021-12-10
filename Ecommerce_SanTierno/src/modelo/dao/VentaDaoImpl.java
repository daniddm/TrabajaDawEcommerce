package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.beans.Venta;

public class VentaDaoImpl extends AbstracDao implements IntVentaDao {

	@Override
	public int altaVenta(Venta venta) {
		int filas = 0; 
		try { 
			tx.begin(); 
			em.persist(venta); 
			tx.commit(); 
			filas = 1; 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return filas; 
	}

	

	@Override
	public int bajaVenta(Venta venta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findByUsuario(int idUsuario) {
		sql = "select v from Venta WHERE v.usuario.idUsuario  =:cod1";
		query = em.createQuery(sql);
		query.setParameter("cod1", idUsuario);
		return query.getResultList();
	}

	@Override
	public BigDecimal calcularPrecioVenta (int idUsuario) {
		sql = "SELECT sum(c.cantidad * c.producto.precio) FROM Carrito c WHERE c.usuario.idUsuario =:cod1";
		query = em.createQuery(sql);
		query.setParameter("cod1", idUsuario);
		return (BigDecimal) query.getSingleResult();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> findAll() {
		sql = "select v from Venta v";
		query = em.createQuery(sql);
		return query.getResultList();
	}


}
