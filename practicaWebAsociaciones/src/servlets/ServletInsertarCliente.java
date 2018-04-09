package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Cliente;
import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/ServletInsertarCliente")
public class ServletInsertarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("se ejecuta el post del ServletInsertarCliente");
		//vamos a recoger lo que ha introducido el usuario en el formulario
		
		//campoTitulo es el name del input del que quiero coger la informacion
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigo_postal = request.getParameter("campoCodigoPostal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String estadoCB = request.getParameter("campoParticularEmpresa");		
		//parte de validacion de datos
		
		//nombre
		String expresionRegularNombre= "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,30}";
		Pattern patternNombre = Pattern.compile(expresionRegularNombre);
		Matcher matcherNombre = patternNombre.matcher(nombre);
		if(matcherNombre.matches()){
			System.out.println("nombre ok");
		}else{
			System.out.println("nombre no valido");
			JOptionPane.showMessageDialog(null, "nombre no valido. Debe tener entre 3 y 30 caracteres");
			request.setAttribute("mensaje", "nombre no valido");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else
		
		//calle
		String expresionRegularCalle= "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s\\/]{3,30}";
		Pattern patternCalle= Pattern.compile(expresionRegularCalle);
		Matcher matcherCalle= patternCalle.matcher(calle);
		if(matcherCalle.matches()){
			System.out.println("calle ok");
		}else{
			System.out.println("calle no valida");
			JOptionPane.showMessageDialog(null, "calle no valida. Debe tener entre 3 y 30 caracteres");
			request.setAttribute("mensaje", "calle no valida");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else		
		
		//numeracion
		String expresionRegularNumeracion= "[a-zA-Z0-9,\\s\\∫\\/]{3,30}";
		Pattern patternNumeracion= Pattern.compile(expresionRegularNumeracion);
		Matcher matcherNumeracion= patternNumeracion.matcher(numeracion);
		if(matcherNumeracion.matches()){
			System.out.println("numeracion ok");
		}else{
			System.out.println("numeracion no valida");
			JOptionPane.showMessageDialog(null, "Numeracion no valida.");
			request.setAttribute("mensaje", "Numeracion no valida");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else		
		
		//codigo postal
		String expresionRegularCodigoPostal= "[0-9]{5}";
		Pattern patternCodigoPostal= Pattern.compile(expresionRegularCodigoPostal);
		Matcher matcherCodigoPostal= patternCodigoPostal.matcher(codigo_postal);
		if(matcherCodigoPostal.matches()){
			System.out.println("codigo postal ok");
		}else{
			System.out.println("codigo postal no valido");
			JOptionPane.showMessageDialog(null, "codigo postal no valido. Debe tener 5 cifras");
			request.setAttribute("mensaje", "codigo postal no valido");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else		
		//poblacion
		String expresionRegularPoblacion= "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,30}";
		Pattern patternPoblacion= Pattern.compile(expresionRegularPoblacion);
		Matcher matcherPoblacion= patternPoblacion.matcher(poblacion);
		if(matcherPoblacion.matches()){
			System.out.println("poblacion ok");
		}else{
			System.out.println("Poblacion no valida");
			JOptionPane.showMessageDialog(null, "Poblacion no valida. Debe tener entre 3 y 30 caracteres");
			request.setAttribute("mensaje", "Poblacion no valida");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else	
		//telefono
		String expresionRegularTelefono= "^[69]\\d{8}$";
		Pattern patternTelefono= Pattern.compile(expresionRegularTelefono);
		Matcher matcherTelefono= patternTelefono.matcher(telefono);
		if(matcherTelefono.matches()){
			System.out.println("Telefono ok");
		}else{
			System.out.println("Telefono no valido");
			JOptionPane.showMessageDialog(null, "Telefono no valido. Debe tener 9 cifras y empezar por 6 o 9");
			request.setAttribute("mensaje", "Telefono no valido");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else	
		//email
		String expresionRegularEmail= "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
		Pattern patternEmail= Pattern.compile(expresionRegularEmail);
		Matcher matcherEmail= patternEmail.matcher(email);
		if(matcherEmail.matches()){
			System.out.println("Email ok");
		}else{
			System.out.println("Email no valido");
			JOptionPane.showMessageDialog(null, "Email no valido");
			request.setAttribute("mensaje", "Email no valido");
			request.getRequestDispatcher("insertarCliente.jsp").forward(request, response);
			return;
		}//end else	
		//particular/empresa
		String particular_empresa;
		if(estadoCB == null){
			particular_empresa = "particular";
		}else{
			particular_empresa = "empresa";
		}//end else
		//fin parte de validacion de datos
		Cliente nuevoCliente = new Cliente(nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particular_empresa);
		//ahora le damos el nuevo usuario a un DAO para que lo registre
		System.out.println("vamos a registrar: "+nuevoCliente.toString());
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(nuevoCliente);
		//desde un servlet no deberia mostrarle nada al usuario
		//para eso tenemos las jsp, que son las encargadas de
		//realizar la vista de la aplicacion
		
		//asi digo al server que siga la ejecucion en la siguiente jsp
		//java ya he terminado, ejecuta la jsp y dale la repuesta que corresponda
		request.getRequestDispatcher("registroClienteOK.jsp").forward(request, response);
	}
	

}
