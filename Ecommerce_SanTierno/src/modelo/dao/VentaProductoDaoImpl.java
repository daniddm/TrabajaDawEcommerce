package modelo.dao;


import java.util.List;



import modelo.beans.VentasProducto;

public class VentaProductoDaoImpl extends AbstracDao implements IntVentaProductoDao {

	
	@Override
	public int altaVentasProducto(VentasProducto ventasProducto) {
		int filas = 0; 
		try { 
			tx.begin(); 
			em.persist(ventasProducto); 
			tx.commit(); 
			filas = 1; 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return filas; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VentasProducto> findAll() {
		sql = "select v from VentasProducto v";
		query = em.createQuery(sql);
		return query.getResultList();
	}
}
