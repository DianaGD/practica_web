package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/ServletBorrarCliente")
public class ServletBorrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar cliente de id: " + id);
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		int jop = JOptionPane.showConfirmDialog(null, "El cliente se borrara", "Alerta!", JOptionPane.YES_NO_OPTION);
		System.out.println(jop);
		if(jop==0){
			clientesDAO.borrarCliente(id);
			request.setAttribute("clientes", clientesDAO.obtenerClientes());
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
		}else{
			request.setAttribute("clientes", clientesDAO.obtenerClientes());
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
		}
	}
}
