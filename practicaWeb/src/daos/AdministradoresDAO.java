package daos;

//import modelo.Administrador;

public interface AdministradoresDAO {
//	void registrarAdministrador(Administrador administrador);

	boolean identificarAdministrador(String email, String pass);	
}
