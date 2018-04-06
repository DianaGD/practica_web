package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Juguete;
import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletEditarJuguete")
public class ServletEditarJuguete extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String[] opcionesCategoria={"Seleccione una...", "Construccion", "Educativo", "Electronico", "Manualidades", "Mu�ecas", "Peluches", "Puzzles"};
		request.setAttribute("opcionesCategoria", opcionesCategoria);
		String[] opcionesEdad={"1-3 a�os","3-6 a�os", "6-9 a�os", "9-12 a�os", "Mayores de 12 a�os"};
		request.setAttribute("opcionesEdad", opcionesEdad);
		JuguetesDAO juguetesDAO = new JuguetesDAOImpl();
		Juguete jugueteAeditar = juguetesDAO.obtenerJuguetesPorId(id);
		request.setAttribute("jugueteAeditar", jugueteAeditar);
		request.getRequestDispatcher("editarJuguete.jsp").forward(request, response);
	}
}
