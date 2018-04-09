package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import daos.CategoriasDAO;
import daosImpl.CategoriasDAOImpl;

@WebServlet("/ServletBorrarCategoria")
public class ServletBorrarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println("borrar categoria de id: " + id);
		CategoriasDAO categoriasDAO = new CategoriasDAOImpl();
		int jop = JOptionPane.showConfirmDialog(null, "La categoria se borrara", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(jop==0){
			categoriasDAO.borrarCategoria(id);
			request.setAttribute("categorias", categoriasDAO.obtenerCategorias());
			request.getRequestDispatcher("ServletListadoCategorias").forward(request, response);
		}else{
			request.setAttribute("categorias", categoriasDAO.obtenerCategorias());
			request.getRequestDispatcher("ServletListadoCategorias").forward(request, response);
		}
	}

}
