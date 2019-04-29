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

	<div>
		<span>${carrito.nombre}</span><br />
		<span>${carrito.descripcion}</span><br />
		<span>${carrito.precio}</span>
		
	</div>



</body>
</html>