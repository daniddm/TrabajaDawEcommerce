package modelo.dao;



import java.math.BigDecimal;
import java.util.List;


import modelo.beans.Venta;

public interface IntVentaDao {
	int altaVenta (Venta venta);
	
	int bajaVenta(Venta venta);
	List<Venta> findByUsuario(int idUsuario);
	BigDecimal calcularPrecioVenta (int idUsuario);
	List<Venta> findAll();
	
}
