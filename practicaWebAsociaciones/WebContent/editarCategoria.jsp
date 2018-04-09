<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar categoria</title>
</head>
<body>
<p><a href="ServletListadoCategorias">volver a la gestion de categorias</a></p>
	<form action="ServletGuardarCambiosCategoria" method="post">
		<fieldset>
		<legend>EDITA LOS DATOS DE LA CATEGORIA QUE QUIERAS:</legend>
		Nombre
		<div>
			<input type="text" name="campoNombre" value="${categoriaAeditar.nombre}" />
		</div>
		Descripcion
		<div>
			<textarea rows="5" cols="30" name='campoDescripcion' id='campoDescripcion'><c:out value="${categoriaAeditar.descripcion}" /></textarea>
		</div>
		<input type="hidden" name="campoId" value="${categoriaAeditar.id}" /><br /> 
		<input type="submit" value="GUARDAR CAMBIOS" />
		</fieldset>
	</form>
</body>
</html>