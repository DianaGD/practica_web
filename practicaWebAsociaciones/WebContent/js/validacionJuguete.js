function validarFormularioJuguete() {
//	alert("validacion en javascript");
	var enviarForm = true;
	// obtener lo escrito por el usuario
	var campoMarca = document.getElementsByName("campoMarca")[0];
	var marca = campoMarca.value;

	var campoNombre = document.getElementsByName("campoNombre")[0];
	var nombre = campoNombre.value;

	var campoDescripcion = document.getElementsByName("campoDescripcion")[0];
	var descripcion = campoDescripcion.value;

	var campoPrecio = document.getElementsByName("campoPrecio")[0];
	var precio = campoPrecio.value;

	var campoCategoria = document.getElementsByName("campoCategoria")[0];
	var categoria = campoCategoria.value;

	var opcionesEdad = document.getElementsByName("campoEdad");

	var campoContenido = document.getElementsByName("campoContenido")[0];
	var contenido = campoContenido.value;

	// comprobar que sea correcto
	var expresionCampoMarca = /^[a-zαινσϊρ\s]{3,15}$/i;
	if (expresionCampoMarca.test(marca)) {
//		alert("marca ok");
	} else {
		alert("marca incorrecta");
		enviarForm = false;
	}

	var expresionCampoNombre = /^[a-zαινσϊρ\s]{3,30}$/i;
	if (expresionCampoNombre.test(nombre)) {
//		alert("nombre ok");
	} else {
		alert("nombre incorrecto");
		enviarForm = false;
	}

	var expresionCampoDescripcion = /^[a-zαινσϊρ0-9.,:\s]{10,150}$/i;
	if (expresionCampoDescripcion.test(descripcion)) {
//		alert("descripcion ok");
	} else {
		alert("descripcion incorrecta");
		enviarForm = false;
	}

	var expresionCampoPrecio = /^[0-9]{1,8}[.,]?[0-9]{0,2}$/;
	if (expresionCampoPrecio.test(precio)) {
//		alert("precio ok");
	} else {
		alert("precio incorrecto");
		enviarForm = false;
	}

	if (categoria != "") {
//		alert("categoria ok");
	} else {
		alert("categoria incorrecta");
		enviarForm = false;
	}

	var seleccionado = false;
	for (var i = 0; i < opcionesEdad.length; i++) {
		if (opcionesEdad[i].checked) {
			seleccionado = true;
//			alert("edad ok");
			break;
		}
	}
	if (!seleccionado) {
		alert("edad incorrecta");
		enviarForm = false;
	}

	var expresionCampoContenido = /^[a-zαινσϊρ0-9.,:\s]{0,150}$/i;
	if (expresionCampoContenido.test(contenido)) {
//		alert("contenido ok");
	} else {
		alert("contenido incorrecto");
		enviarForm = false;
	}
	return enviarForm; // si es true se envia el formulario
}// end function
