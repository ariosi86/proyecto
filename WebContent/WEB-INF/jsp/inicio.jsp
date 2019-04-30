<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio</title>
</head>
<body>

<label>${mensaje}</label>
<c:forEach items="${productos}" var="producto">
	<div>
		<span>${producto.idProducto}</span>
		<span>${producto.nombre}</span>
		<span><a href="DescripcionServlet?idProducto=${producto.idProducto}">Ver descripciòn</a></span>
		
		  
		<table >
			<tr>
				
			<span><a href="CarritoServlet?idProducto=${producto.idProducto}">agregar </a></span>
		   </tr>
	   </table>
	   
     
 
		
	</div>
</c:forEach>


</body>
</html>
