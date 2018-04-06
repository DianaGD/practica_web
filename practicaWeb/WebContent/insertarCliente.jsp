<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/validacionCliente.js"></script>
<title>Insertar cliente</title>
</head>
<body>
	<p><a href="ServletListadoClientes">volver a la gestion de clientes</a></p>
	<form action="ServletInsertarCliente" method="post" onsubmit="return validarFormularioCliente()">
		<fieldset>
			<legend>INTRODUCE LOS DATOS DEL CLIENTE:</legend>
				Nombre
				<div>
					<input type="text" name="campoNombre"/>
				</div>
				Calle
				<div>
					<input type="text" name="campoCalle" />
				</div>
				Numeracion
				<div>
					<input type="text" name="campoNumeracion" />
				</div> 
				Codigo postal
				<div>
					<input type="text" name="campoCodigoPostal" />
				</div>
				Poblacion
				<div>
					<input type="text" name="campoPoblacion" />
				</div>
				Telefono
				<div>
					<input type="text" name="campoTelefono" />
				</div>
				Email 
				<div>
					<input type="text" name="campoEmail" />
				</div>
				Particular/Empresa
				<div>
					<input type="checkbox" name="campoParticularEmpresa" id="cb" />Es Empresa
				</div>
			<br />
			<input type="submit" value="INSERTAR" />
		</fieldset>
	</form>
</body>
</html>