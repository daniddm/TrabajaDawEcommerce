package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.jpa.jpql.parser.SumFunction;

import modelo.beans.Carrito;
import modelo.beans.CarritoPK;
import modelo.beans.Categoria;
import modelo.beans.Perfil;
import modelo.beans.Producto;
import modelo.beans.Usuario;
import modelo.beans.Venta;
import modelo.beans.VentasProducto;
import modelo.dao.CarritoDaoImpl;
import modelo.dao.CategoriaDaoImpl;
import modelo.dao.PerfilDaoImpl;
import modelo.dao.ProductoDaoImpl;
import modelo.dao.UsuarioDaoImpl;
import modelo.dao.VentaDaoImpl;
import modelo.dao.VentaProductoDaoImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		
		case "altaUsuario":
			procesarAlta(request, response);
			break;
			
		case "login":
			login(request, response);
			break;
			
			
		case "cargarProductosCategorias":
			cargarProductosCategorias(request, response);
			break;
		
		case "comprar":
			comprar(request, response);
			break;
		
		case "verCarrito":
			verCarrito(request, response);
			break;
		
		case "confirmarCompra":
			confirmarCompra(request, response);
			break;
			
		case "verVentas":
			verVentas(request, response);
			
			break;
		case "borrarProducto":
			borrarProducto(request, response);
			break;
		}
	}
	protected void procesarAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDaoImpl udao = new UsuarioDaoImpl(); //creamos un nuevo usuario
		HttpSession miSesion = request.getSession();
		String nombreUsuario = request.getParameter("nombre"); //cogemos el par?metro nombre usuario del formulario de registo.
		String email = request.getParameter("email"); //recogemos el par?metro del email. 
		String password = request.getParameter("contrase?a"); //recogemos la contrase?a que escoja el usuario
		String apellidos = request.getParameter("apellido"); //y apellidos
	
		Date dateregistro = new Date();//hacemos nueva fecha de registro
		
		PerfilDaoImpl perfilDao = new PerfilDaoImpl();
		Perfil perfil = perfilDao.findById(2);
	
		Usuario user1 = new Usuario(0,nombreUsuario,apellidos,email,password,perfil,dateregistro);
		udao.altaUsuario(user1);
		 //a?adimos todos atributos en la clase alta de usuario para que las incluya en la BBDD
		System.out.println("dado de alta ");
		miSesion.setAttribute("user1", user1);
		request.getRequestDispatcher("index.jsp").forward(request, response);	//si el usuario y la contrase?a es v?lida, acceder? a la web
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession miSesion = request.getSession(); //creamos una nueva sesi?n de usuario
		String mensaje = null; //creamos una variable mensaje que estar? a nulo
		String email = request.getParameter("email"); //recogemos el usuario
		String password = request.getParameter("contrase?a"); //y la contrase?a
		UsuarioDaoImpl udao = new UsuarioDaoImpl(); //hacemos un nuevo usuario para la b?squeda
		Usuario usuarioLogin = udao.findByEmail(email);
		
		if (usuarioLogin != null) {
			boolean loginCorrecto = udao.checkLogin(email, password);
			if(loginCorrecto) {
				miSesion.setAttribute("usuario", usuarioLogin);
				cargarProductosCategorias(request,response);
			} else {  
				mensaje = "Contrase?a incorrecta"; 
				request.setAttribute("mensaje", mensaje); 
				request.getRequestDispatcher("index.jsp").forward(request, response); 
			}
		} else { 
			mensaje = "El usuario no existe"; 
			request.setAttribute("mensaje", mensaje); 
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
	

	protected void cargarProductosCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDaoImpl pdao = new ProductoDaoImpl();
		List <Producto> productos = pdao.findByAll();
		request.setAttribute("productos", productos);
		CategoriaDaoImpl cdao = new CategoriaDaoImpl();
		List <Categoria> categorias = cdao.findAll();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	
		
	}

	protected void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misesion = request.getSession();
		Usuario usuario = (Usuario) misesion.getAttribute("usuario");
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		ProductoDaoImpl pDao = new ProductoDaoImpl();
		Producto producto = pDao.findById(idProducto);
		CarritoDaoImpl cadao = new CarritoDaoImpl();
		Carrito carrito = cadao.findById(usuario.getIdUsuario(),idProducto);
		if(carrito == null) {
			Carrito newCarrito = new Carrito(usuario, producto , 1);
			cadao.altaCarrito(newCarrito);
		}else {
			cadao.updateCarrito(carrito);
		}
		cargarProductosCategorias(request,response);
	}

	protected void verCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misesion = request.getSession();
		Usuario usuario = (Usuario) misesion.getAttribute("usuario");
		
		CarritoDaoImpl cadao = new CarritoDaoImpl();
		List<Carrito> carrito = cadao.findByUsuario(usuario.getIdUsuario());
		request.setAttribute("carrito", carrito);
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
	}
	
	protected void confirmarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion = request.getSession();
		Usuario usuario = (Usuario) misesion.getAttribute("usuario");
		
		VentaDaoImpl vdao = new VentaDaoImpl();
		CarritoDaoImpl cdao = new CarritoDaoImpl();
		List<Carrito> lista = cdao.findByUsuario(usuario.getIdUsuario());
		
		BigDecimal suma = vdao.calcularPrecioVenta(usuario.getIdUsuario());
		
		Venta venta = new Venta (0, usuario, suma);
		vdao.altaVenta(venta);
		
		VentaProductoDaoImpl vpdao = new VentaProductoDaoImpl();
		
		for (Carrito car : lista) {
			
			VentasProducto ventaProducto = new VentasProducto(venta, car.getProducto(),car.getProducto().getPrecio(),car.getCantidad() );
			vpdao.altaVentasProducto(ventaProducto);
			int carrito = cdao.bajaCarrito(car);
			request.setAttribute("carrito", carrito);
		}
		
		request.getRequestDispatcher("compraConfirmada.jsp").forward(request, response);
	
	}
	
	protected void verVentas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misesion = request.getSession();
		VentaDaoImpl vdao = new VentaDaoImpl();
		List<Venta> listaVentas = vdao.findAll();
		misesion.setAttribute("listaVentas", listaVentas);
		
		VentaProductoDaoImpl vpdao = new VentaProductoDaoImpl();
		List<VentasProducto> listaVentaProducto = vpdao.findAll();
		misesion.setAttribute("listaVentaProducto", listaVentaProducto);
		request.getRequestDispatcher("verVentas.jsp").forward(request, response);
		
	}

	protected void borrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misesion = request.getSession();
		Usuario usuario = (Usuario) misesion.getAttribute("usuario");
		
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		
		CarritoDaoImpl cadao = new CarritoDaoImpl();
		cadao.borrarProductoCarrito(usuario.getIdUsuario(), idProducto);
		
		verCarrito(request, response);
	}
}
