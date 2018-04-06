package pruebas;

import daos.JuguetesDAO;
import daosImpl.JuguetesDAOImpl;
import modelo.Juguete;

public class Inserta20Juguetes {
	public static void main(String[] args) {
		Juguete j = new Juguete();
		JuguetesDAO dao = new JuguetesDAOImpl();
		for(int i=0; i<20; i++){
			j.setMarca("marca"+i);
			j.setNombre("juguete"+i);
			j.setDescripcion("descripcion"+i);
			j.setPrecio(i+"");
			j.setCategoria("educativo");
			dao.registrarJuguete(j);
		}//end for
	}//end main
}//end class