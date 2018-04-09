function validarFormularioCliente(){
//		alert("validacion en javascript");
		var enviarForm = true;
		//obtener lo escrito por el usuario		
		var campoNombre= document.getElementsByName("campoNombre")[0];
		var nombre = campoNombre.value;
		
		var campoCalle= document.getElementsByName("campoCalle")[0];
		var calle = campoCalle.value;
		
		var campoNumeracion= document.getElementsByName("campoNumeracion")[0];
		var numeracion = campoNumeracion.value;	
		
		var campoCodigoPostal= document.getElementsByName("campoCodigoPostal")[0];
		var codigoPostal = campoCodigoPostal.value;
		
		var campoPoblacion= document.getElementsByName("campoPoblacion")[0];
		var poblacion= campoPoblacion.value;
		
		var campoTelefono= document.getElementsByName("campoTelefono")[0];
		var telefono = campoTelefono.value;
		
		var campoEmail= document.getElementsByName("campoEmail")[0];
		var email = campoEmail.value;
		
		//comprobar que sea correcto		
		var expresionCampoNombre= /^[a-zαινσϊρ\s]{3,30}$/i;
		if(expresionCampoNombre.test(nombre)){
			alert("nombre ok");
		}else{
			alert("nombre incorrecto");
			enviarForm=false;
		}		
		
		var expresionCampoCalle= /^[a-zαινσϊρ\s\/]{3,30}$/i;
		if(expresionCampoCalle.test(calle)){
			alert("calle ok");
		}else{
			alert("calle incorrecta");
			enviarForm=false;
		}
		
		var expresionCampoNumeracion= /^[a-z0-9,\s\Ί\/]{3,30}$/i;
		if(expresionCampoNumeracion.test(numeracion)){
			alert("numeracion ok");
		}else{
			alert("numeracion incorrecta");
			enviarForm=false;
		}
		
		var expresionCampoCodigoPostal= /^\d{5}$/;
		if(expresionCampoCodigoPostal.test(codigoPostal)){
			alert("codigo postal ok");
		}else{
			alert("codigo postal incorrecto");
			enviarForm=false;
		}
		
		var expresionCampoPoblacion= /^[a-zαινσϊρ\s]{3,30}$/i;
		if(expresionCampoPoblacion.test(poblacion)){
			alert("poblacion ok");
		}else{
			alert("poblacion incorrecta");
			enviarForm=false;
		}
		
		var expresionCampoTelefono= /^[69]\d{8}$/;
		if(expresionCampoTelefono.test(telefono)){
			alert("telefono ok");
		}else{
			alert("telefono incorrecto");
			enviarForm=false;
		}
		
		var expresionCampoEmail= /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;
		if(expresionCampoEmail.test(email)){
			alert("email ok");
		}else{
			alert("email incorrecto");
			enviarForm=false;
		}
		//devolver true si todo esta bien
		//devolver false si hay algo mal
		return enviarForm; //si es true se envia el formulario
		
}//end function	