package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//esta clase solo vale para heredar de ella, no se puede usar directamente por ser abstract
//de ella van a heredar todas las implementaciones DAO
public abstract class GenericDAO {

	protected Connection miConexion = null; // tanto desde la clase como las que
											// hereden de ella

	// carga del driver de conexion con JDBC:
	static {
		// bloque especial que se ejecuta una única vez a lo largo de la
		// aplicacion la primera vez que esta clase es usada
		// los constructores se ejecutan cada vez que se creen objetos
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");
		}
	}// end static

	// metodo que se va a encargar de hacer la conexion con la bbdd
	protected void conectar() {
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_web", "root",
					"jeveris");
		} catch (SQLException e) {
			System.out.println("no pude conectarme a la bbdd");
			System.out.println("comprobar ruta de la bbdd");
			System.out.println("comprobar nombre usuario y contraseña");
		}
	}// end conectar

	// metodo para desconectarnos de la bbdd
	protected void desconectar() {
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion de la bbdd");
		}
	}// end desconectar

}// end class
