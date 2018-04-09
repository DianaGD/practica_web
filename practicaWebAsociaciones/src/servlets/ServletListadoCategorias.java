package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.CategoriasDAO;
import daosImpl.CategoriasDAOImpl;

@WebServlet("/ServletListadoCategorias")
public class ServletListadoCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("obteniendo categorias para listarlas");
		CategoriasDAO categoriasDAO = new CategoriasDAOImpl();
		request.setAttribute("categorias", categoriasDAO.obtenerCategorias());
		request.getRequestDispatcher("gestionCategorias.jsp").forward(request, response);
	}
}
