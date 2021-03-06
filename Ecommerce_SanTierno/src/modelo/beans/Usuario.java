package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	private String password;

	private String surname;

	private String username;

	//bi-directional many-to-one association to Carrito
	@OneToMany(mappedBy="usuario")
	private List<Carrito> carritos;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;

	//bi-directional many-to-many association to Producto
	@ManyToMany
	@JoinTable(
		name="carrito"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PRODUCTO")
			}
		)
	private List<Producto> productos;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario", cascade={CascadeType.PERSIST})
	private List<Venta> ventas;

	public Usuario() {
	}
	


	public Usuario(int idUsuario, String username, String surname, String email, String password, Perfil perfil,
			Date fechaRegistro) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.perfil = perfil;
		this.fechaRegistro = fechaRegistro;
	}



	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public Carrito addCarrito(Carrito carrito) {
		getCarritos().add(carrito);
		carrito.setUsuario(this);

		return carrito;
	}

	public Carrito removeCarrito(Carrito carrito) {
		getCarritos().remove(carrito);
		carrito.setUsuario(null);

		return carrito;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setUsuario(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuario(null);

		return venta;
	}

}