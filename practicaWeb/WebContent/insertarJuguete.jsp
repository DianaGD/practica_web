<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/validacionJuguete.js"></script>
<title>Insertar juguete</title>
</head>
<body>
	<p><a href="ServletListadoJuguetes">volver a la gestion de juguetes</a></p>
	<form action="ServletInsertarJuguete" method="post" enctype="multipart/form-data" onsubmit="return validarFormularioJuguete()">
		<fieldset>
		<legend>INTRODUCE LOS DATOS DEL JUGUETE:</legend>
		Marca 
		<div>
			<input type="text" name="campoMarca" placeholder="marca"/> 
		</div>
		Nombre 
		<div>
			<input type="text" name="campoNombre" placeholder="nombre"/> 
		</div>
		Descripcion
		<div>
			<textarea rows="5" cols="30" name="campoDescripcion" placeholder="descripcion del juguete"></textarea>
		</div>
		Precio 
		<div>
			<input type="text" name="campoPrecio" placeholder="precio"/>
		</div>
		<label for="categoria">Categoria</label> 
		<div>
			<select name="campoCategoria" id= "campoCategoria">
				<option value="">Seleccione una...</option>
				<option value="Construccion">Construccion</option>
				<option value="Educativo">Educativo</option>
				<option value="Electronico">Electronico</option>
				<option value="Manualidades">Manualidades</option>
				<option value="Muñecas">Muñecas</option>
				<option value="Peluches">Peluches</option>			
				<option value="Puzzles">Puzzles</option>
			</select>
		</div>
		Edad
		<div>
			<input type="radio" name="campoEdad" value="1-3 años">1-3 años<br/>
			<input type="radio" name="campoEdad" value="3-6 años">3-6 años<br/>
			<input type="radio" name="campoEdad" value="6-9 años">6-9 años<br/>
			<input type="radio" name="campoEdad" value="9-12 años">9-12 años<br/>
			<input type="radio" name="campoEdad" value="Mayores de 12 años">Mayores de 12 años<br/>
		</div>
		Incluye
		<div>
			<textarea rows="5" cols="30" name="campoContenido" placeholder="contenido del juguete"></textarea>
		</div>
		Imagen: <input type="file" name="campoImagen"/><br/>
		
		<br><input type="submit" value="INSERTAR" />
		</fieldset>
	</form>
</body>
</html>