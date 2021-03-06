<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="modelo.beans.Usuario"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Inicio</title>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Inicio</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/inicio.css" rel="stylesheet" />
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/validar.js"></script>
	
</head>
	
<body>

	<header>
    	<div class="cabecera"> 
	    	<div class="imagen">
	        	<img src="img/logo.PNG">
	        </div> 
			<nav>
				<a href="#">Inicio</a>
				<a href= "Servlet?opcion=cargarProductosCategorias">Producto</a>
				<a href="about.jsp">Quienes somos</a>
				<a href="#">Contacto</a>
			</nav>
       </div>
    </header>
	
	<div class="container">
	
		<div class="row w-100">
		
			<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6">
				<img src="img/dehesa.jpg" class="w-100">
			</div>
			
			<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6">
			
				<div class="d-grid gap-2 col-6 d-md-block mb-3">
					<button type="button" id="login_button" class="btn btn-outline-secondary">Login</button>
					<button type="button" id="register_button" class="btn btn-outline-secondary">Registro</button>
				</div>
				
				<!--formulario de registro-->
				<form id="formRegister" class="topBefore" action="Servlet?opcion=altaUsuario" method="post">
				
					<div class="form-group">
					
						<label for="exampleInputEmail1">Introduce un Nombre</label>
						<input id="nombre"class="form-control" type="text" placeholder="Nombre" name ="nombre">
						
						<label for="exampleInputEmail1">Introduce un Apellido</label>
						<input id="apellido"class="form-control" type="text" placeholder="Apellido" name ="apellido">
						
						<label for="exampleInputEmail1">Correo electronico</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"name ="email">
						
						<label for="exampleInputEmail1">Introduce una Contrase?a </label>
						<input id="contrase?a"class="form-control" type="password" placeholder="Contrase?a" name ="contrase?a">
						
						<button type="submit" class="btn btn-primary">Registrese</button>
						
					</div>
				
				</form>
			
				<!--formulario de login-->
				<form id="formLogin" class="topBefore" action="Servlet?opcion=login" method="post">
	
					<div class="form-group" >
						<label for="exampleInputEmail1">Correo electronico</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name ="email">
						<label for="exampleInputPassword1">Contrase?a</label>
						<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name ="contrase?a">
						<button type="submit" class="btn btn-primary">Entrar</button>
					</div>
					<% // sacamos por pantalla el mensaje %>
		            <%String mensaje = (String)request.getAttribute("mensaje"); 
		                if (mensaje != null) {%>
		                    <h4><%=mensaje %></h4>
		            <%} %>
				</form>
				
			</div>
			
		</div>
	
	</div>
	
</body>
	
</html>