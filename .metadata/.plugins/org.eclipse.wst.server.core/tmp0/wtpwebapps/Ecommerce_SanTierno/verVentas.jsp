<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Ver ventas</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/productos.css" rel="stylesheet" /> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
</head>

<body class="h-100 w-100">
	
	<div class="container">
		<span class="display-6">Ventas totales</span>
		<table class="table">	
			<tr>
				<th>Usuario</th>
				<th>Gasto Total</th>
			</tr>
			<c:forEach var="ven" items="${sessionScope.listaVentas}">
				<tr>
				  	<td>${ven.usuario.username}</td>
					<td>${ven.precioTotal}</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
	
	<div class="container">
		<span class="display-6">Productos vendidos</span>
		<table class="table">	
			<tr>
				<th>Cliente</th>
				<th>Producto</th>
				<th>Precio Producto</th>
				<th>Cantidad</th>
			</tr>
			<c:forEach var="pven" items="${sessionScope.listaVentaProducto}">
				<tr>
					<td>${pven.venta.usuario.username}</td>
				  	<td>${pven.producto.nombre}</td>
					<td>${pven.precio}</td>
					<td>${pven.cantidad}</td>
				</tr>
			</c:forEach>
	</table>
	</div>
	
</body>

</html>