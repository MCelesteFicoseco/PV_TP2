package ar.edu.unju.fi.ejercicio6.model;

public class FelinoDomestico {
	
	private String nombre;
	private byte edad;
	private float peso;
	
	public FelinoDomestico(String string, byte b, float f) {
		// TODO Auto-generated constructor stub
	}

	public FelinoDomestico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoDomestico \nNombre=" + nombre + "\nEdad=" + edad + "\nPeso=" + peso;
	}
	
	
}
