<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar categoria</title>
</head>
<body>
<p><a href="ServletListadoCategorias">volver a la gestion de categorias</a></p>
	<form action="ServletInsertarCategoria" method="post">
		<fieldset>
		<legend>INTRODUCE LOS DATOS DE LA CATEGORIA:</legend>
		Nombre 
		<div>
			<input type="text" name="campoNombre"/> 
		</div>
		Descripcion
		<div>
			<textarea rows="5" cols="30" name="campoDescripcion"></textarea>
		</div>
		<br><input type="submit" value="INSERTAR" />
		</fieldset>
	</form>
</body>
</html>