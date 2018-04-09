package daos;

import java.util.List;

import modelo.Categoria;
import modelo.Juguete;

public interface JuguetesDAO {
	void registrarJuguete(Juguete juguete);

	void borrarJuguete(int id);

	Juguete obtenerJuguetesPorId(int id);

	void guardarCambiosJuguetes(Juguete juguete);

	int obtenerTotalJuguetes(String busqueda);

	List<Juguete> obtenerJuguetes();

	List<Juguete> obtenerJuguetesBusqueda(int desdeInt, int cuantosInt,	String busqueda);

	List<Categoria> obtenerCategorias();
}
