package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Juguete;
import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletEditarJuguete")
public class ServletEditarJuguete extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String[] opcionesEdad={"1-3 años","3-6 años", "6-9 años", "9-12 años", "Mayores de 12 años"};
		request.setAttribute("opcionesEdad", opcionesEdad);
		JuguetesDAO juguetesDAO = new JuguetesDAOImpl();
		Juguete jugueteAeditar = juguetesDAO.obtenerJuguetesPorId(id);
		request.setAttribute("jugueteAeditar", jugueteAeditar);
		List<Categoria> categorias = juguetesDAO.obtenerCategorias();
		request.setAttribute("categorias", categorias);
		System.out.println("jugueteAeditar.categoria.nombre"+jugueteAeditar.getCategoria());
		request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
	}
}
