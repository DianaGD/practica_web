package daos;

import java.util.List;

import modelo.Categoria;

public interface CategoriasDAO {
	List<Categoria> obtenerCategorias();

	void registrarCategoria(Categoria nuevaCategoria);

	void borrarCategoria(long id);

	Categoria obtenerCategoriasPorId(int id);

	void guardarCambiosCategorias(Categoria categoria);
}
