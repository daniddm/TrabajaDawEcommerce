package modelo.dao;


import java.util.List;


import modelo.beans.VentasProducto;

public interface IntVentaProductoDao {
	int altaVentasProducto(VentasProducto ventasProducto);
	List<VentasProducto> findAll();
}
