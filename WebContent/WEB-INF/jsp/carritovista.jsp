<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Al carrito</title>

</head>
<body>
<label>${mensaje}</label>
<c:forEach items="${shop}" var="carrito" >
	<div>
		Nombre: <span>${carrito.nombre}</span><br />
		Cantidad seleccionada: <span>${carrito.cantidad}</span><br />
		Precio total: <span>${carrito.precio}</span>
		
	</div>

</c:forEach>
	<a href="InicioServlet">Volver al Inicio</a>
</body>
</html>
