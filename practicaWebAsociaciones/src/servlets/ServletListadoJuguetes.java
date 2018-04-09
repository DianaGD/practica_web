package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Juguete;
import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;

@WebServlet("/ServletListadoJuguetes")
public class ServletListadoJuguetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//buscador:
		String busqueda = request.getParameter("campoBusqueda"); //recoge lo que pongamos en el campo de busqueda
		//si no se pone nada valdrá null
		if(busqueda==null){
			busqueda="";
		}
		
		//paginacion:
		String desde = request.getParameter("desde");
		String cuantos = request.getParameter("cuantos");
		int desdeInt = 0;
		int cuantosInt = 5;
		if(desde!=null && cuantos!=null){
			desdeInt = Integer.parseInt(desde);
			cuantosInt = Integer.parseInt(cuantos);
		}
		
		System.out.println("obteniendo juguetes para gestionarlos");
		
		JuguetesDAO juguetesDAO = new JuguetesDAOImpl();
		List<Juguete> juguetes = juguetesDAO.obtenerJuguetesBusqueda(desdeInt,cuantosInt,busqueda);
		
		//preparar las variables para la jsp
		request.setAttribute("juguetes", juguetes);
		request.setAttribute("juguetesTotales", juguetesDAO.obtenerTotalJuguetes(busqueda));
		request.setAttribute("desdeSiguiente", desdeInt + 5);
		request.setAttribute("desdeAnterior", desdeInt - 5);
		request.getRequestDispatcher("gestionJuguetes.jsp").forward(request, response);
	}
}
