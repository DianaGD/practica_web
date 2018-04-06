package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletBorrarJuguete")
public class ServletBorrarJuguete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar juguete de id: " + id);
		JuguetesDAO juguetesDAO = new JuguetesDAOImpl();
		int jop = JOptionPane.showConfirmDialog(null, "El juguete se borrara", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(jop==0){
			juguetesDAO.borrarJuguete(id);
			request.setAttribute("juguetes", juguetesDAO.obtenerJuguetes());
			request.getRequestDispatcher("ServletListadoJuguetes").forward(request, response);
		}else{
			request.setAttribute("juguetes", juguetesDAO.obtenerJuguetes());
			request.getRequestDispatcher("ServletListadoJuguetes").forward(request, response);
		}
	}

}
