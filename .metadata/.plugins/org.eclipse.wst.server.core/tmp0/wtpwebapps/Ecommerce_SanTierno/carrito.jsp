<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Carrito</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
		
	<div class="container">
	
		<span class="display-6">Carrito</span>
		<table class="table">	
			<tr>
				<th>Eliminar</th>
				<th>Producto</th>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Cantidad</th>
			</tr>
			<c:forEach var="car" items="${requestScope.carrito}" varStatus="in">
				<tr>
				  	<td><a href="Servlet?opcion=borrarProducto&idProducto=${car.producto.idProducto}">Eliminar</a></td>
				  	<td>${car.producto.nombre}</td>
					<td>${car.producto.descripcion}</td>
					<td>${car.producto.precio}</td>
					<td>${car.cantidad}</td>
			 	</tr>
			</c:forEach>
		</table>
		<a href="Servlet?opcion=confirmarCompra" class="btn btn-secondary">Finalizar compra</a>
		<a href="Servlet?opcion=cargarProductosCategorias" class="btn btn-secondary">Volver a productos</a>
	
	</div>
	
</body>
</html>