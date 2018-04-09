<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de categorias</title>
</head>
<body>
<a href="menu.jsp">volver a menu principal</a>&nbsp;
<a href="ServletLogOutAdmin">Salir</a><br/><br/>
<a href="insertarCategoria.jsp">INSERTAR NUEVA CATEGORIA</a><br/>

<c:forEach items="${categorias}" var="categoria">
	<div style="margin: 8px">		
		nombre: ${categoria.nombre}<br/>
		descripcion: ${categoria.descripcion}<br/>
		<a href="ServletBorrarCategoria?id=${categoria.id}">BORRAR</a>
		<a href="ServletEditarCategoria?id=${categoria.id}">EDITAR</a>
	</div>
</c:forEach>
</body>
</html>