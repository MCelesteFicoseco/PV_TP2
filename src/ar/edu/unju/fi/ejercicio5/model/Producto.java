package ar.edu.unju.fi.ejercicio5.model;


import ar.edu.unju.fi.ejercicio1.util.Categoria;
import ar.edu.unju.fi.ejercicio1.util.OrigenFabricacion;

public class Producto {
	private String codigo;
	private String descripcion;
	private float precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	private boolean estado;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion, float precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "\nProducto \nCodigo: " + codigo + "\nDescripcion: " + descripcion + "\nPrecio unitario:" + precioUnitario
				+ "\nOrigen de fabricacion: " + origenFabricacion + "\nCategoria:" + categoria + "\nEstado:" + estado;
	}
	
	
}

