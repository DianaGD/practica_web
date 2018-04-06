<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de clientes</title>
</head>
<body>
<a href="menu.jsp">volver a menu principal</a>&nbsp;
<a href="ServletLogOutAdmin">Salir</a><br/><br/>
<a href="insertarCliente.jsp">INSERTAR NUEVO CLIENTE</a><br/>

<c:forEach items="${clientes}" var="cliente">
	<div style="margin: 8px">		
		nombre: ${cliente.nombre}<br/>
		calle: ${cliente.calle}<br/>
		numeracion: ${cliente.numeracion}<br/>
		codigo postal: ${cliente.codigo_postal}<br/>
		poblacion: ${cliente.poblacion}<br/>
		telefono: ${cliente.telefono}<br/>
		email: ${cliente.email}<br/>
		particular o empresa: ${cliente.particular_empresa}<br/>
		<a href="ServletBorrarCliente?id=${cliente.id}">BORRAR</a>
		<a href="ServletEditarCliente?id=${cliente.id}">EDITAR</a>
	</div>
</c:forEach>

</body>
</html>