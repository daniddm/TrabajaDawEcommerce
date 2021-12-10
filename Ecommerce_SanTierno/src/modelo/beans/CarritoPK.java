package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the carrito database table.
 * 
 */
@Embeddable
public class CarritoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="ID_PRODUCTO", insertable=false, updatable=false)
	private int idProducto;

	public CarritoPK() {
	}
	
	
	public CarritoPK(int idUsuario, int idProducto) {
		super();
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
	}


	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
		if (!(other instanceof CarritoPK)) {
			return false;
		}
		CarritoPK castOther = (CarritoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idProducto == castOther.idProducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idProducto;
		
		return hash;
	}
}