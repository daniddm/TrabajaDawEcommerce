package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ventas_productos database table.
 * 
 */
@Embeddable
public class VentasProductoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_VENTA", insertable=false, updatable=false)
	private int idVenta;

	@Column(name="ID_PRODUCTO", insertable=false, updatable=false)
	private int idProducto;

	public VentasProductoPK() {
	}
	public int getIdVenta() {
		return this.idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VentasProductoPK)) {
			return false;
		}
		VentasProductoPK castOther = (VentasProductoPK)other;
		return 
			(this.idVenta == castOther.idVenta)
			&& (this.idProducto == castOther.idProducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idVenta;
		hash = hash * prime + this.idProducto;
		
		return hash;
	}
}