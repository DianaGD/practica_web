package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import modelo.Administrador;
import daos.AdministradoresDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class AdministradorDAOImpl extends GenericDAO implements AdministradoresDAO{

//	@Override
//	public void registrarAdministrador(Administrador administrador) {
//		conectar();
//		try {
//			PreparedStatement ps = miConexion
//					.prepareStatement(ConstantesSQL.INSERCION_ADMINISTRADOR);
//			ps.setString(1, administrador.getLogin());
//			ps.setString(2, administrador.getPass());
//			ps.execute();
//			ps.close();
//		} catch (SQLException e) {
//			System.out.println("la sql de insercion de administrador esta mal");
//			System.out.println(e.getMessage());
//		}
//		desconectar();		
//	}

	@Override
	public boolean identificarAdministrador(String email, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_ADMIN);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado de base de datos
				identificado = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion tiene problemas");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return identificado;
	}

}
