<%@page import="java.util.List"%>
<%@page import="modelo.dao.UsuarioDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="modelo.beans.Usuario"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/productos.css" rel="stylesheet" /> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<input id = "perfilUsuario" type="hidden" value="${sessionScope.usuario.perfil.idPerfil }">

    <div class="contenedor">
    
		<header>
        	<div class="cabecera"> 
				<div class="imagen">
					<img src="img/logo.PNG">
				</div> 
				<nav>
					<a href="index.jsp">Inicio</a>
					<a href= "Servlet?opcion=cargarProductosCategorias">Producto</a>
					<a href="about.jsp">Quienes somos</a>
					<a href="#">Contacto</a>
					<a id="menuCarrito" href="Servlet?opcion=verCarrito">Carrito</a>
					<a id="menuAdmin" href="admin.jsp">Admin</a>
				</nav>
			</div>
            <div class="logo" >
            	<h1>San Tierno</h1>
                <p>Lo mas rico de Espa?a </p>
            </div>
			<div class="form">
            	<input type="text" class="barra-buscar" id="barra-buscar" placeholder="Busca el Producto">
            </div>
            
                <div class="categorias" id="categorias">
                
					<a href="#" class= "activo">Todos</a>
				<c:forEach var="categoria" items="${requestScope.categorias}">
                    <a href="#" >${categoria.nombre}</a>
                </c:forEach>
                </div>
                
            </header>
			<!-- metemos en un section las imagenes de los productos -->
			<!-- seguimos la estrucyura de la libreria muuri -->
            <section class="grid" id="grid" >
				<!-- en cada div le metemos una categoria y una etiqueta para buscar luego -->
				
				<c:forEach var="producto" items="${requestScope.productos}">
				<div class="item" 
					data-categoria="${producto.categoria.nombre}" 
					data-etiquetas="${producto.etiquetas}">
					<div class="item-contenido">
						<img alt="" src="${producto.imagen}" class="border border-secondary">
						<a href="Servlet?opcion=comprar&idProducto=${producto.idProducto}" class="btn btn-secondary w-100 mt-1" >Comprar</a>
					</div>
				</div>
				</c:forEach>
				
			</section>
			<!-- un div con la parte de abajo de la web  de bootstrap-->
			<div class="container steps">
				<div class="container py-5" id="featured-3">
				  <h2 class="pb-2">Beneficios de elegirnos frente al resto</h2>
				  <div class="row g-5 py-0">
					<div class="feature col-md-3">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-heart-eyes" viewBox="0 0 16 16">
							<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
							<path d="M11.315 10.014a.5.5 0 0 1 .548.736A4.498 4.498 0 0 1 7.965 13a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .548-.736h.005l.017.005.067.015.252.055c.215.046.515.108.857.169.693.124 1.522.242 2.152.242.63 0 1.46-.118 2.152-.242a26.58 26.58 0 0 0 1.109-.224l.067-.015.017-.004.005-.002zM4.756 4.566c.763-1.424 4.02-.12.952 3.434-4.496-1.596-2.35-4.298-.952-3.434zm6.488 0c1.398-.864 3.544 1.838-.952 3.434-3.067-3.554.19-4.858.952-3.434z"/>
						  </svg>
					  <hr>
					  <h3>1. Disfrute</h3>
					  <p>Disfrute de una experiencia unica.</p>
					</div>
					<div class="feature col-md-3">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
							<path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>
						  </svg>
					  <hr>
					  <h3>2. Comparta</h3>
					  <p>Comparta nuestros productos con sus familiares.</p>
					</div>
					<div class="feature col-md-3">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone-forward-fill" viewBox="0 0 16 16">
							<path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511zm10.761.135a.5.5 0 0 1 .708 0l2.5 2.5a.5.5 0 0 1 0 .708l-2.5 2.5a.5.5 0 0 1-.708-.708L14.293 4H9.5a.5.5 0 0 1 0-1h4.793l-1.647-1.646a.5.5 0 0 1 0-.708z"/>
						  </svg>
					  <hr>
					  <h3>3. Llamenos</h3>
					  <p>Estamos disponibles 24/7 para cualquier pedido o cualquier inconvenencia.</p>
					</div>
					<div class="feature col-md-3">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope-open" viewBox="0 0 16 16">
							<path fill-rule="evenodd" d="M8.47 1.318a1 1 0 0 0-.94 0l-6 3.2A1 1 0 0 0 1 5.4v.817l5.75 3.45L8 8.917l1.25.75L15 6.217V5.4a1 1 0 0 0-.53-.882l-6-3.2ZM15 7.383l-4.778 2.867L15 13.117V7.383Zm-.035 6.88L8 10.082l-6.965 4.18A1 1 0 0 0 2 15h12a1 1 0 0 0 .965-.738ZM1 13.116l4.778-2.867L1 7.383v5.734ZM7.059.435a2 2 0 0 1 1.882 0l6 3.2A2 2 0 0 1 16 5.4V14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V5.4a2 2 0 0 1 1.059-1.765l6-3.2Z"/>
						  </svg>
					  <hr>
					  <h3>4. Contacte</h3>
					  <p>Envienos un correo en cualquier momento.</p>
					</div>
				  </div>
				</div>
			  </div>
			
			  <!-- FOOTER -->
			  <hr class="featurette-divider">
			  <footer class="container">
				<p class="float-end"><a href="#">Inicio de pagina <i class="fas fa-chevron-up"></i></a></p>
				<p>&copy; 2021 SanTierno SL. </p>
			  </footer>
	</div>		  
	<!-- link de js libreria muuri -->
	<script src="https://cdn.jsdelivr.net/npm/web-animations-js@2.3.2/web-animations.min.js"></script>		
	<script src="https://cdn.jsdelivr.net/npm/muuri@0.9.5/dist/muuri.min.js"></script>
	<script type="text/javascript" src="js/productos.js"></script>
</body>
</html>