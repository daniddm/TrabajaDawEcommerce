package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.beans.Producto;


public interface IntProductoDao {
	int altaProducto (Producto producto);
	int updateProducto (Producto producto);
	Producto findById(int idProducto);
	List<Producto> findByAll();
	List<Producto> findByProducto( String nombre,String descripcion);
	
}
