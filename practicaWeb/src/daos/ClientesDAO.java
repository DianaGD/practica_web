package daos;

import java.util.List;
import modelo.Cliente;

public interface ClientesDAO {
	void registrarCliente(Cliente cliente);

	List<Cliente> obtenerClientes();

	void borrarCliente(int id);

	Cliente obtenerClientesPorId(int id);

	void guardarCambiosClientes(Cliente cliente);
}
