package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;



public class Main {

	public static void main(String[] args) {
		int n;
		List<Jugador> jugadores = new ArrayList<>();
		
		do {
			n = menu();
			
			switch(n) {
			case 1:
				jugadores = altaJugador(jugadores);
				break;
			case 2:
				mostrarJugador(jugadores);
				break;
			case 3:
				modificarPosicion(jugadores);
				break;
			case 4:
				eliminarJugador(jugadores);
				break;
			}
		}while (n != 5);
		
		System.out.println("Programa terminado....");

	}
	
	public static List<Jugador> eliminarJugador(List<Jugador>  j){
		Scanner scanner = new Scanner(System.in);
		String nombre, apellido;
		System.out.println("Ingresar nombre:");
		nombre = scanner.next();
		System.out.println("Ingresar apellido:");
		apellido = scanner.next();
		Iterator iterator = j.iterator();
		while(iterator.hasNext()) {
			Jugador c = (Jugador)iterator.next();
			if(c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) { 
				j.remove(c);
			}
		}
		return j;
	}

	private static void modificarPosicion(List<Jugador> jugadores) {
		Scanner scanner = new Scanner(System.in);
		String nombre, apellido;
		int n;
		System.out.println("Ingresar nombre:");
		nombre = scanner.next();
		System.out.println("Ingresar apellido:");
		apellido = scanner.next();
		
		for(Jugador c: jugadores) {
			if(c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) {
				int opcPosicion;
				String posicion = null;
				do {
					System.out.println("Posicion:");
					System.out.println("1 - Delantero");
					System.out.println("2 - Medio");
					System.out.println("3 - Defensa");
					System.out.println("4 - Arquero");
					System.out.println("Elija una opcion:");
					opcPosicion = scanner.nextInt(); 
				}while(opcPosicion<1 || opcPosicion >4);
				
				switch(opcPosicion) {
				case 1:
					posicion = "DELANTERO";
					break;
				case 2:
					posicion = "MEDIO";
					break;
				case 3:
					posicion = "DEFENSA";
					break;
				case 4:
					posicion = "ARQUERO";
					break;
				}
				c.setPosicion(Posicion.valueOf(posicion));
			}		
		}
		
	}

	private static void mostrarJugador(List<Jugador> jugadores) {
		for(Jugador c: jugadores) {
			System.out.println(c);
		}
		
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int opc;
		
		System.out.println("------------------- MENU -------------------");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar jugadores");
		System.out.println("3 - Modificar la posicion de un jugador");
		System.out.println("4 - Eliminar jugador");
		System.out.println("5 - Salir");
		System.out.println("-------------------------------------------");
		do {
			System.out.println("Ingrese una opción");
			opc = scanner.nextInt();
		}while(opc<1 || opc>5);
		//scanner.close();
		return opc;
	}
	
	
	public static List<Jugador> altaJugador(List<Jugador>  j) {
		Scanner scanner = new Scanner(System.in);
		
		int n;
		
		System.out.println("*************** ALTA DE JUGADOR ****************");
		System.out.println("Ingrese el nombre:");
		String nombre = scanner.next();
		
		System.out.println("Ingrese el apellido:");
		String apellido = scanner.next();
		
		String nac_string;
		LocalDate fecha_nac;
		
		do {
			try {
				System.out.println("Ingrese la fecha de nacimiento: (yyy-mm-dd)");
				nac_string = scanner.next();
				fecha_nac = LocalDate.parse(nac_string);
			}catch (Exception ex){
				nac_string = "";
				fecha_nac = LocalDate.now();
				scanner.nextLine();
			}
		}while(fecha_nac.isEqual(LocalDate.now()) );
		
			
		System.out.println("Ingrese la nacionalidad:");
		String nacionalidad = scanner.next();
		
		float estatura;
		do {
			try {
				System.out.println("Ingrese la estatura en cm:");
				estatura = scanner.nextFloat();
			}catch(Exception ex) {
				estatura = (float)0.0;
				scanner.nextLine();
			}
		}while(estatura == 0.0 || estatura < (float)100);
		
		float peso;
		do {
			try {
				System.out.println("Ingrese el peso en kg:");
				peso = scanner.nextFloat();
			}catch(Exception ex) {
				peso = (float)0.0;
				scanner.nextLine();
			}
		}while(peso == 0.0 || peso < (float)30);
		
		
		int opcPosicion;
		String posicion = null;
		do {
			System.out.println("Posicion:");
			System.out.println("1 - Delantero");
			System.out.println("2 - Medio");
			System.out.println("3 - Defensa");
			System.out.println("4 - Arquero");
			System.out.println("Elija una opcion:");
			opcPosicion = scanner.nextInt(); 
		}while(opcPosicion<1 || opcPosicion >4);
		
		switch(opcPosicion) {
		case 1:
			posicion = "DELANTERO";
			break;
		case 2:
			posicion = "MEDIO";
			break;
		case 3:
			posicion = "DEFENSA";
			break;
		case 4:
			posicion = "ARQUERO";
			break;
		}
		
		
		Jugador jugador = new Jugador(nombre, apellido, fecha_nac, nacionalidad, estatura, peso, Posicion.valueOf(posicion));
		j.add(jugador);
		
		return j;
	}

}