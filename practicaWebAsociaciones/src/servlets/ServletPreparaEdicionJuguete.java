package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletPreparaEdicionJuguete")
public class ServletPreparaEdicionJuguete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		JuguetesDAO dao = new JuguetesDAOImpl();
		List<Categoria> categorias = dao.obtenerCategorias();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("ServletEditarJuguete?id="+id).forward(request, response);
	}

}
