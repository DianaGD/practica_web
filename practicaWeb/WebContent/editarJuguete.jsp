<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/validacionJuguete.js"></script>
<title>Editar juguete</title>
</head>
<body>
	<p><a href="ServletListadoJuguetes">volver a la gestion de juguetes</a></p>
	<form action="ServletGuardarCambiosJuguete" method="post" enctype="multipart/form-data" onsubmit="return validarFormularioJuguete()">
		<fieldset>
		<legend>EDITA LOS DATOS DEL JUGUETE QUE QUIERAS:</legend>
		Marca
		<div>
			<input type="text" name="campoMarca" value="${jugueteAeditar.marca}" />
		</div>
		Nombre
		<div>
			<input type="text" name="campoNombre" value="${jugueteAeditar.nombre}" />
		</div>
		Descripcion
		<div>
			<textarea rows="5" cols="30" name='campoDescripcion' id='campoDescripcion'><c:out value="${jugueteAeditar.descripcion}" /></textarea>
		</div>
		Precio
		<div>
			<input type="text" name="campoPrecio" value="${jugueteAeditar.precio}" />
		</div>
		Categoria
		<div>
			<select name="campoCategoria">
				<c:forEach var="categoria" items="${requestScope.opcionesCategoria}">
					<c:if test="${categoria==jugueteAeditar.categoria}">
						<option value="${categoria}" selected>${categoria}</option>
					</c:if>
					<c:if test="${categoria!=jugueteAeditar.categoria}">
						<option value="${categoria}">${categoria}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		Edad
		<div>
			<c:forEach var="edad" items="${requestScope.opcionesEdad}">
				<c:if test="${edad==jugueteAeditar.edad}">
					<input type="radio" name="campoEdad" value="${edad}"
						checked="checked">${edad}<br />
				</c:if>
				<c:if test="${edad!=jugueteAeditar.edad}">
					<input type="radio" name="campoEdad" value="${edad}">${edad}<br />
				</c:if>
			</c:forEach>
		</div>
		Incluye
		<div>
			<textarea rows="5" cols="30" name='campoContenido' id='campoContenido'><c:out value="${jugueteAeditar.contenido}" /></textarea>
		</div>
		Foto actual:
		<br/><img src="${jugueteAeditar.rutaImagen}" height="50"/><br/>
		Cambiar foto: <input type="file" name="campoImagen"/><br/>
		<input type="hidden" name="campoId" value="${jugueteAeditar.id}" /><br /> 
		<input type="submit" value="GUARDAR CAMBIOS" />
		</fieldset>
	</form>
</body>
</html>