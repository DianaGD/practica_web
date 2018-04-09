package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import daos.CategoriasDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class CategoriasDAOImpl extends GenericDAO implements CategoriasDAO{

	@Override
	public List<Categoria> obtenerCategorias() {
		conectar();
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.SQL_SELECCION_CATEGORIAS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Categoria c = new Categoria();
				c.setNombre(rs.getString("nombre"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setId(rs.getLong("id"));
				categorias.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la sql seleccion categorias este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return categorias;
	}

	@Override
	public void registrarCategoria(Categoria categoria) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_CATEGORIA);
			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getDescripcion());		
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de categorias esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public void borrarCategoria(long id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CATEGORIA);
			ps.setLong(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrar categoria esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();		
	}

	@Override
	public Categoria obtenerCategoriasPorId(int id) {
		conectar();
		Categoria categoria = new Categoria();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_CATEGORIA_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				categoria.setNombre(rs.getString("nombre"));
				categoria.setDescripcion(rs.getString("descripcion"));
				categoria.setId(id);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de obtener cliente por id esta mal");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return categoria;
	}

	@Override
	public void guardarCambiosCategorias(Categoria categoria) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CATEGORIA);
			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getDescripcion());
			ps.setLong(3, categoria.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql guardar cambios categoria esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();	
	}


}
