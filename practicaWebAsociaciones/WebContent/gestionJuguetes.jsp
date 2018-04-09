<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de juguetes</title>
</head>
<body>
<a href="menu.jsp">volver a menu principal</a>&nbsp;
<a href="ServletLogOutAdmin">Salir</a><br/><br/>
<div>
<form action="ServletListadoJuguetes">
	BUSCAR: 
	<input type="text" name="campoBusqueda"/>
	<input type="submit" value="BUSCAR"/>
</form>
</div>

<div>
	<c:if test="${desdeAnterior >= 0}">
		<a href="ServletListadoJuguetes?desde=${desdeAnterior}&cuantos=5">
			anterior
		</a> 
	</c:if>
	<c:if test="${desdeSiguiente < juguetesTotales}">
		<a href="ServletListadoJuguetes?desde=${desdeSiguiente}&cuantos=5">
			siguiente
		</a>
	</c:if>

</div>

<div>
	Total juguetes: ${juguetesTotales}
</div>


<a href="ServletPreparaRegistroJuguete">INSERTAR NUEVO JUGUETE</a><br/>

<c:forEach items="${juguetes}" var="juguete">
	<div style="margin: 8px">		
		marca: ${juguete.marca}<br/>
		nombre: ${juguete.nombre}<br/>
		descripcion: ${juguete.descripcion}<br/>
		precio: ${juguete.precio}<br/>
		categoria: ${juguete.categoria.nombre}<br/>
		edad: ${juguete.edad}<br/>
		incluye: ${juguete.contenido}<br/>
		<img src="${juguete.rutaImagen}" height="200"/>
		<a href="ServletBorrarJuguete?id=${juguete.id}">BORRAR</a>
		<a href="ServletEditarJuguete?id=${juguete.id}">EDITAR</a>
<%-- 		<a href="ServletPreparaEdicionJuguete?id=${juguete.id}">EDITAR</a> --%>
	</div>
</c:forEach>

</body>
</html>