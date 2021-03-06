package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.beans.Carrito;
import modelo.beans.CarritoPK;
import modelo.beans.Producto;


public interface IntCarritoDao {

	Carrito findById(int idUsuario, int idProducto);
	int bajaCarrito (Carrito carrito);
	List<Carrito> findByAll();
	int altaCarrito (Carrito carrito);
	int updateCarrito (Carrito carrito);
	List<Carrito> findByUsuario(int idUsuario);
	Carrito findById(int idUsuario);
	void borrarProductoCarrito(int idUsuario, int idProducto);
}
