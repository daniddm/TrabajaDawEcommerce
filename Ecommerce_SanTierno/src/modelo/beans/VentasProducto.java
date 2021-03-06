package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ventas_productos database table.
 * 
 */
@Entity
@Table(name="ventas_productos")
@NamedQuery(name="VentasProducto.findAll", query="SELECT v FROM VentasProducto v")
public class VentasProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VentasProductoPK id;

	private int cantidad;

	private BigDecimal precio;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	//uni-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="ID_VENTA")
	private Venta venta;

	public VentasProducto() {
	}
	
	public VentasProducto(Venta venta,Producto producto,BigDecimal precio, int cantidad) {
		super();
		
		this.venta = venta;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public VentasProductoPK getId() {
		return this.id;
	}

	public void setId(VentasProductoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}