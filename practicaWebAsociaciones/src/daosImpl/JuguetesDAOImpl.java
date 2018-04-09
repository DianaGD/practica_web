package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import utilidades.GestorArchivos;
import modelo.Categoria;
import modelo.Juguete;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.JuguetesDAO;

public class JuguetesDAOImpl extends GenericDAO implements JuguetesDAO{

	@Override
	public void registrarJuguete(Juguete juguete) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_JUGUETE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, juguete.getMarca());
			ps.setString(2, juguete.getNombre());
			ps.setString(3, juguete.getDescripcion());
			ps.setString(4, juguete.getPrecio());
//			ps.setString(5, juguete.getCategoria());
			ps.setString(5, juguete.getEdad());
			ps.setString(6, juguete.getContenido());
			ps.setLong(7, juguete.getIdCategoria());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();//getGeneratedKeys da el id autogenerado
			if(rs.next()){
				int idGenerado = rs.getInt(1); //dame el primer elemento que devuelve getGeneratedKeys
				System.out.println("id generado en bd: " + idGenerado);
				//guardar la imagen del producto en una carpeta 
				//nombrada con el mismo id generado
				GestorArchivos.guardarArchivo(juguete.getImagenSubida(), idGenerado+".jpg");
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de juguete esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public List<Juguete> obtenerJuguetesBusqueda(int desde, int cuantos, String busqueda) {
		conectar();
		List<Juguete> juguetes = new ArrayList<Juguete>();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCION_JUGUETES_BUSQUEDA);
			ps.setString(1, "%"+busqueda+"%");
			ps.setInt(2, desde);
			ps.setInt(3, cuantos);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Juguete juguete = new Juguete();
				juguete.setMarca(resultado.getString("marca"));
				juguete.setNombre(resultado.getString("nombre"));
				juguete.setDescripcion(resultado.getString("descripcion"));
				juguete.setPrecio(resultado.getString("precio"));
				//juguete.setIdCategoria(resultado.getLong("categoria"));
				juguete.setEdad(resultado.getString("edad"));
				juguete.setContenido(resultado.getString("incluye"));
				juguete.setId(resultado.getInt("id"));
				juguete.setRutaImagen(GestorArchivos.rutaArchivo(resultado.getInt("id")));
				Categoria c = new Categoria();
				c.setNombre(resultado.getString("nombre_categoria"));
				juguete.setCategoria(c);
				juguetes.add(juguete);
			}//end while
			resultado.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql select juguetes esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		return juguetes;
	}

	@Override
	public void borrarJuguete(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_JUGUETE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			GestorArchivos.borrarArchivo(id);
		} catch (SQLException e) {
			System.out.println("la sql de borrar juguete esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public Juguete obtenerJuguetesPorId(int id) {
		conectar();		
		Juguete juguete = new Juguete();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_JUGUETE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				juguete.setMarca(rs.getString("marca"));
				juguete.setNombre(rs.getString("nombre"));
				juguete.setDescripcion(rs.getString("descripcion"));
				juguete.setPrecio(rs.getString("precio"));
				juguete.setEdad(rs.getString("edad"));
				juguete.setContenido(rs.getString("incluye"));
				juguete.setRutaImagen(GestorArchivos.rutaArchivo(rs.getInt("id")));
				juguete.setIdCategoria(rs.getLong("id_categoria"));
				juguete.setId(id);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de obtener juguete por id esta mal");
			System.out.println(e.getMessage());
		}		
		desconectar();
		System.out.println("juguete desde DAOImpl: "+juguete);
		return juguete;
	}

	@Override
	public void guardarCambiosJuguetes(Juguete juguete) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_JUGUETE);
			ps.setString(1, juguete.getMarca());
			ps.setString(2, juguete.getNombre());
			ps.setString(3, juguete.getDescripcion());
			ps.setString(4, juguete.getPrecio());
			ps.setString(5, juguete.getEdad());
			ps.setString(6, juguete.getContenido());
			ps.setLong(7, juguete.getIdCategoria());
			ps.setInt(8, juguete.getId());
			ps.execute();						
			ps.close();
			GestorArchivos.guardarArchivo(juguete.getImagenSubida(), juguete.getId()+".jpg");
		} catch (SQLException e) {
			System.out.println("la sql guardar cambios juguete esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();	
	}

	@Override
	public int obtenerTotalJuguetes(String busqueda) {
		conectar();
		int total = 0;
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.CANTIDAD_TOTAL_JUGUETES);
			ps.setString(1, "%"+busqueda+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql cantidad total juguetes puede estar mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return total;
	}

	@Override
	public List<Juguete> obtenerJuguetes() {
		conectar();
		List<Juguete> juguetes = new ArrayList<Juguete>();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCION_JUGUETES);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Juguete juguete = new Juguete();
				juguete.setMarca(resultado.getString("marca"));
				juguete.setNombre(resultado.getString("nombre"));
				juguete.setDescripcion(resultado.getString("descripcion"));
				juguete.setPrecio(resultado.getString("precio"));
				Categoria c = new Categoria();
				c.setNombre(resultado.getString("nombre"));
				juguete.setCategoria(c);
//				juguete.setIdCategoria(resultado.getLong("categoria"));
				juguete.setEdad(resultado.getString("edad"));
				juguete.setContenido(resultado.getString("incluye"));
				juguete.setId(resultado.getInt("id"));
				juguete.setRutaImagen(GestorArchivos.rutaArchivo(resultado.getInt("id")));
				juguetes.add(juguete);
			}//end while
			resultado.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql select juguetes esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		return juguetes;
	}

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
			System.out.println("seguramente la sql este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return categorias;
	}

}
