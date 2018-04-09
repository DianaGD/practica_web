package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AdministradoresDAO;
import daosImpl.AdministradorDAOImpl;

@WebServlet("/ServletIdentificacionAdmin")
public class ServletIdentificacionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		System.out.println("Voy a identificar a email: "+email+"contraseña: "+pass);
		AdministradoresDAO administradoresDAO = new AdministradorDAOImpl();
		if(administradoresDAO.identificarAdministrador(email,  pass)){
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("ok");
		}else{
			request.setAttribute("mensaje", "email y/o pass incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
