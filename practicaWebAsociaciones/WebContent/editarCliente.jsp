<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/validacionCliente.js"></script>
<title>Editar cliente</title>
</head>
<body>
<p><a href="ServletListadoClientes">volver a la gestion de clientes</a></p>
<form action="ServletGuardarCambiosCliente" method="post" onsubmit="return validarFormularioCliente()">
	<fieldset>
		<legend>EDITA LOS DATOS DEL CLIENTE QUE QUIERAS</legend>
		Nombre 
		<div>
			<input type="text" name="campoNombre" value="${clienteAeditar.nombre}"/>
		</div>
		Calle
		<div>
			<input type="text" name="campoCalle" value="${clienteAeditar.calle}"/>
		</div>
		Numeracion
		<div>
			<input type="text" name="campoNumeracion" value="${clienteAeditar.numeracion}"/>
		</div>
		Codigo postal
		<div>
			<input type="text" name="campoCodigoPostal" value="${clienteAeditar.codigo_postal}"/>
		</div>
		Poblacion
		<div>
			<input type="text" name="campoPoblacion" value="${clienteAeditar.poblacion}"/>
		</div>
		Telefono
		<div>
			<input type="text" name="campoTelefono" value="${clienteAeditar.telefono}"/>
		</div>
		Email
		<div>
			<input type="text" name="campoEmail" value="${clienteAeditar.email}"/>
		</div>
		Particular/Empresa
		<div>
			<c:if test="${clienteAeditar.particular_empresa == 'particular'}">
				<input type="checkbox" name="campoParticularEmpresa"/>Es Empresa<br/>
			</c:if>
			<c:if test="${clienteAeditar.particular_empresa == 'empresa'}">
				<input type="checkbox" name="campoParticularEmpresa" checked="checked"/>Es Empresa<br/>
			</c:if>
		</div>
		<input type="hidden" name="campoId" value="${clienteAeditar.id}"/>
		<br/>
		<input type="submit" value="GUARDAR CAMBIOS"/>
	</fieldset>
</form>
</body>
</html>