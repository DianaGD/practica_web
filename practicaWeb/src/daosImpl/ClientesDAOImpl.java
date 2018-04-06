package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO{

	@Override
	public void registrarCliente(Cliente cliente) {
		// siempre llamar a conectar() y desconectar()
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticular_empresa());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de cliente esta mal");
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Email debe ser unico. Ya existe un cliente con este email");
		}
		desconectar();
	}

	@Override
	public List<Cliente> obtenerClientes() {
		conectar();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCION_CLIENTES);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Cliente cliente = new Cliente();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setNumeracion(resultado.getString("numeracion"));
				cliente.setCodigo_postal(resultado.getString("codigo_postal"));
				cliente.setPoblacion(resultado.getString("poblacion"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setParticular_empresa(resultado.getString("particular_empresa"));
				cliente.setId(resultado.getInt("id"));
				
				clientes.add(cliente);
			}//end while
		} catch (SQLException e) {
			System.out.println("sql select usuarios esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		return clientes;
	}

	@Override
	public void borrarCliente(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrar cliente esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		
	}

	@Override
	public Cliente obtenerClientesPorId(int id) {
		conectar();
		Cliente cliente = new Cliente();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumeracion(rs.getString("numeracion"));
				cliente.setCodigo_postal(rs.getString("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticular_empresa(rs.getString("particular_empresa"));
				cliente.setId(id);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de obtener cliente por id esta mal");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return cliente;
	}

	@Override
	public void guardarCambiosClientes(Cliente cliente) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticular_empresa());
			ps.setInt(9, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql guardar cambios cliente esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();	
		
	}
	
}
