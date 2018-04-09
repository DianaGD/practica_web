package daos;

public class ConstantesSQL {
	public static final String INSERCION_ADMINISTRADOR= "insert into tabla_administradores (login, pass) values (?,?)";
	public static final String IDENTIFICACION_ADMIN = "select id from tabla_administradores where login = ? and pass = ?";
	public static final String SELECCION_CLIENTES = "select * from tabla_clientes";
	public static final String INSERCION_CLIENTE = "insert into tabla_clientes (nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particular_empresa) values (?,?,?,?,?,?,?,?)";
	public static final String BORRAR_CLIENTE = "delete from tabla_clientes where id = ?";
	public static final String OBTENER_CLIENTE_POR_ID = "select * from tabla_clientes where id = ?";
	public static final String GUARDAR_CAMBIOS_CLIENTE = "update tabla_clientes set nombre=?, calle=?, numeracion=?, codigo_postal=?, poblacion=?, telefono=?, email=?, particular_empresa=? where id=?";
	
	public static final String SELECCION_JUGUETES = "select * from tabla_juguetes";
	public static final String INSERCION_JUGUETE = "insert into tabla_juguetes (marca, nombre, descripcion, precio, edad, incluye, id_categoria) values (?,?,?,?,?,?,?)";
	public static final String BORRAR_JUGUETE = "delete from tabla_juguetes where id=?";
	public static final String OBTENER_JUGUETE_POR_ID = "select tabla_juguetes.id, tabla_juguetes.marca, tabla_juguetes.nombre, tabla_juguetes.descripcion, tabla_juguetes.precio, tabla_juguetes.edad, tabla_juguetes.incluye, tabla_juguetes.id_categoria from tabla_juguetes where tabla_juguetes.id=?";
	public static final String GUARDAR_CAMBIOS_JUGUETE = "update tabla_juguetes set marca=?, nombre=?, descripcion=?, precio=?, edad=?, incluye=?, id_categoria=? where id=?";
	public static final String CANTIDAD_TOTAL_JUGUETES = "SELECT COUNT(id) as total FROM tabla_juguetes where tabla_juguetes.nombre like ?";
	public static final String SELECCION_JUGUETES_BUSQUEDA = "select tabla_juguetes.id, tabla_juguetes.marca, tabla_juguetes.nombre, tabla_juguetes.descripcion, tabla_juguetes.precio, tabla_juguetes.edad, tabla_juguetes.incluye, tabla_categorias.nombre as nombre_categoria from tabla_juguetes, tabla_categorias where tabla_juguetes.id_categoria=tabla_categorias.id AND tabla_juguetes.nombre like ? order by tabla_juguetes.id desc limit ?,?";
	
	
	public static final String SQL_SELECCION_CATEGORIAS = "select * from tabla_categorias";
	public static final String INSERCION_CATEGORIA = "insert into tabla_categorias (nombre, descripcion) values (?,?)";
	public static final String BORRAR_CATEGORIA = "delete from tabla_categorias where id = ?";
	public static final String OBTENER_CATEGORIA_POR_ID = "select * from tabla_categorias where id=?";
	public static final String GUARDAR_CAMBIOS_CATEGORIA = "update tabla_categorias set nombre=?, descripcion=? where id=?";
}
