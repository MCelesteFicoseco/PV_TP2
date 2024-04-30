package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fecha_nac;
	private String nacionalidad;
	private float altura;
	private float peso;
	private Posicion posicion;
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nombre, String apellido, LocalDate fecha_nac, String nacionalidad, float altura, float peso,
			Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nac = fecha_nac;
		this.nacionalidad = nacionalidad;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int calcularEdad() {
		Period periodo = Period.between(this.fecha_nac,LocalDate.now());
		return periodo.getYears();
	}
	
	@Override
	public String toString() {
		return "\nJugador \nNombre: " + this.nombre + "\nApellido:" + this.apellido + "\nFecha de nacimiento: " + this.fecha_nac + "\nNacionalidad:"
				+ this.nacionalidad + "\nAltura: " + this.altura + "\nPeso:" + this.peso + "\nPosicion:" + this.posicion +"\n\n" ;
	}

	
	
}