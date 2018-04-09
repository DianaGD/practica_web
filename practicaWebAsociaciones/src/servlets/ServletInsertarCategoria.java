package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import daos.CategoriasDAO;
import daosImpl.CategoriasDAOImpl;

@WebServlet("/ServletInsertarCategoria")
public class ServletInsertarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String descripcion = request.getParameter("campoDescripcion");
		Categoria nuevaCategoria = new Categoria(nombre, descripcion);
		System.out.println("vamos a registrar: " + nuevaCategoria.toString());
		CategoriasDAO categoriasDAO = new CategoriasDAOImpl();
		categoriasDAO.registrarCategoria(nuevaCategoria);
		request.getRequestDispatcher("registroCategoriaOK.jsp").forward(request,
				response);
	}

}
