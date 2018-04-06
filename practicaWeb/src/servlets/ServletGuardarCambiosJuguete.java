package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.Juguete;
import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletGuardarCambiosJuguete")
@MultipartConfig
public class ServletGuardarCambiosJuguete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marca = request.getParameter("campoMarca");
		String nombre = request.getParameter("campoNombre");
		String descripcion= request.getParameter("campoDescripcion");
		String precio = request.getParameter("campoPrecio");
		String categoria = request.getParameter("campoCategoria");
		String edad = request.getParameter("campoEdad");
		String contenido= request.getParameter("campoContenido");
		Part imagen = request.getPart("campoImagen");
		String id = request.getParameter("campoId");
		//ahora deberiamos validar todos los datos
		//marca
		String expresionRegularMarca= "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,15}";
		Pattern patternMarca = Pattern.compile(expresionRegularMarca);
		Matcher matcherMarca = patternMarca.matcher(marca);
		if(matcherMarca.matches()){
			System.out.println("marca ok");
		}else{
			System.out.println("marca no valida");
			JOptionPane.showMessageDialog(null, "marca no valida. Debe tener entre 3 y 15 caracteres");
			request.setAttribute("mensaje", "marca no valida");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
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
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
		//descripcion
		String expresionRegularDescripcion= "[a-zA-Z0-9·ÈÌÛ˙¡…Õ”⁄Ò—.,:\\s]{10,150}";
		Pattern patternDescripcion= Pattern.compile(expresionRegularDescripcion);
		Matcher matcherDescripcion= patternDescripcion.matcher(descripcion);
		if(matcherDescripcion.matches()){
			System.out.println("descripcion ok");
		}else{
			System.out.println("descripcion no valida");
			JOptionPane.showMessageDialog(null, "descripcion no valida. Debe tener entre 10 y 150 caracteres");
			request.setAttribute("mensaje", "descripcion no valida");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
		//precio
		String expresionRegularPrecio= "[0-9.,]{1,8}";
		Pattern patternPrecio= Pattern.compile(expresionRegularPrecio);
		Matcher matcherPrecio= patternPrecio.matcher(precio);
		if(matcherPrecio.matches()){
			System.out.println("precio ok");
		}else{
			System.out.println("precio no valido");
			JOptionPane.showMessageDialog(null, "precio no valido");
			request.setAttribute("mensaje", "precio no valido");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
		//categoria
		String expresionRegularCategoria= "[a-zA-Z]{7,20}";
		Pattern patternCategoria= Pattern.compile(expresionRegularCategoria);
		Matcher matcherCategoria= patternCategoria.matcher(categoria);
		if(matcherCategoria.matches()){
			System.out.println("categoria ok");
		}else{
			System.out.println("categoria no valida");
			JOptionPane.showMessageDialog(null, "categoria no valida. Debe seleccionar una opcion");
			request.setAttribute("mensaje", "categoria no valida");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
		//edad
		if(edad!=null){
			System.out.println("edad ok"+edad);
		}else{
			System.out.println("edad no valida"+edad);
			request.setAttribute("mensaje", "edad no valida");
			JOptionPane.showMessageDialog(null, "edad no valida. Debe seleccionar un rango de edad");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}
		//contenido
		String expresionRegularContenido= "[a-zA-Z0-9·ÈÌÛ˙¡…Õ”⁄Ò—.,:\\s]{0,150}";
		Pattern patternContenido= Pattern.compile(expresionRegularContenido);
		Matcher matcherContenido= patternContenido.matcher(contenido);
		if(matcherContenido.matches()){
			System.out.println("contenido ok");
		}else{
			System.out.println("contenido no valido");
			JOptionPane.showMessageDialog(null, "contenido no valido. Debe tener menos de 150 caracteres");
			request.setAttribute("mensaje", "contenido no valido");
			request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
			return;
		}//end else
		//fin parte validacion
		Juguete juguete = new Juguete(marca, nombre, descripcion, precio, categoria, edad, contenido, imagen);
		juguete.setId(Integer.parseInt(id));
		
		JuguetesDAO juguetesDAO = new JuguetesDAOImpl();
		juguetesDAO.guardarCambiosJuguetes(juguete);
		request.getRequestDispatcher("ServletListadoJuguetes").forward(request, response);
	}
}
