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

@WebServlet("/ServletGuardarCambiosCategoria")
public class ServletGuardarCambiosCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String descripcion= request.getParameter("campoDescripcion");
		String id = request.getParameter("campoId");
		Categoria categoria = new Categoria(nombre, descripcion);
		categoria.setId(Long.parseLong(id));
		CategoriasDAO categoriasDAO = new CategoriasDAOImpl();
		categoriasDAO.guardarCambiosCategorias(categoria);
		request.getRequestDispatcher("ServletListadoCategorias").forward(request, response);
	}

}
