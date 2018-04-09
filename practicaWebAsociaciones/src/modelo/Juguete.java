package modelo;

import javax.servlet.http.Part;

public class Juguete {
	private String marca;
	private String nombre;
	private String descripcion;
	private String precio;
	//private String categoria;
	private String edad;
	private String contenido;
	private int id;
	private Part imagenSubida;
	private String rutaImagen;	
	//categorias
	private long idCategoria;
	private Categoria categoria;
	
	public Juguete() {
		// TODO Auto-generated constructor stub
	}	

	public Juguete(String marca, String nombre, String descripcion,
			String precio, String edad, String contenido, Part imagenSubida, long idCategoria) {
		super();
		this.marca = marca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.edad = edad;
		this.contenido = contenido;
		this.imagenSubida = imagenSubida;
		this.idCategoria = idCategoria;
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Juguete [marca=" + marca + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", precio=" + precio
				+ ", edad=" + edad + ", contenido=" + contenido + ", id=" + id
				+ ", imagenSubida=" + imagenSubida + "]";
	}
}//end class

