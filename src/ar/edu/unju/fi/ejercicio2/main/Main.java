package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		List<Efemeride> efemerides = new ArrayList<>();
		int n;
		
		do {
			n = menu();
			
			switch(n) {
			case 1:
				efemerides = crearEfemeride(efemerides);
				break;
			case 2:
				mostrarEfemeride(efemerides);
				break;
			case 3:
				eliminarEfemeride(efemerides);
				break;
			case 4:
				modificarEfemeride(efemerides);
				break;
			}
		}while (n != 5);
		System.out.println("Programa finalizado correctamente");

	}
	

	private static void modificarEfemeride(List<Efemeride> efemerides) {
		Scanner scanner = new Scanner(System.in);
		String codigo;
		System.out.println("Ingresar codigo:");
		codigo = scanner.next();
		
		for(Efemeride p:efemerides) {
			if(p.getCodigo().equals(codigo)) {
				String salir;
				do {
					int e =0;
					do {
						System.out.println("----> MODIFICAR DATOS DE "+p.getCodigo());
						System.out.println("1) Mes \n2)Dia \n3)Detalle");
						System.out.println("Ingrese una opcion:");
						e = scanner.nextInt();
						
					}while(e<1 || e>3);
					switch(e) {
						case 1:
							int mes;
							String mesEfemeride = null;
							do {
								try {
									System.out.println("Ingrese el mes de la efemeride (1-12)");
									mes = scanner.nextInt(); 
								}catch(Exception ex) {
									mes=0;
									scanner.nextLine();
								}
							}while(mes<1 || mes >12);

							switch(mes) {
							case 1:
								mesEfemeride = "ENERO";
								break;
							case 2:
								mesEfemeride = "FEBRERO";
								break;
							case 3:
								mesEfemeride = "MARZO";
								break;
							case 4:
								mesEfemeride = "ABRIL";
								break;
							case 5:
								mesEfemeride = "MAYO";
								break;
							case 6:
								mesEfemeride = "JUNIO";
								break;
							case 7:
								mesEfemeride = "JULIO";
								break;
							case 8:
								mesEfemeride = "AGOSTO";
								break;
							case 9:
								mesEfemeride = "SEPTIEMBRE";
								break;
							case 10:
								mesEfemeride = "OCTUBRE";
								break;
							case 11:
								mesEfemeride = "NOVIEMBRE";
								break;
							case 12:
								mesEfemeride = "DICIEMBRE";
								break;
							}
							p.setMes(Mes.valueOf(mesEfemeride));
							break;
							
						case 2:
							int dia;
							do {
								try {
									System.out.println("Ingrese el día:");
									dia = scanner.nextInt();
								}catch(Exception ex) {
									dia = 0;
									scanner.nextLine();
								}
								switch(p.getMes().getNUMERO()){
								case 2:
									if(dia>29) {
										dia=0;
									}
									break;
								case 4,6,9,11:
									if(dia>30){
										dia=0;
										break;
									}
								}
							}while(dia==0 || dia>31);
							p.setDia(dia);
							break;
							
						case 3:
							System.out.println("Ingrese el detalle:");
							String detalle = scanner.next();
							p.setDetalle(detalle);
							break;
							
					}
					System.out.println("Desea modificar otro campo del mismo producto? si/no");
					salir = scanner.next();
				}while(salir == "si");
			}
		}
		
	}


	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int opc;
		
		System.out.println("------------------- MENU -------------------");
		System.out.println("1 - Crear efemeride");
		System.out.println("2 - Mostrar efemeride");
		System.out.println("3 - Eliminar efemeride");
		System.out.println("4 - Modificar efemeride");
		System.out.println("5 - Salir");
		System.out.println("-------------------------------------------");
		do {
			System.out.println("Ingrese una opción");
			opc = scanner.nextInt();
		}while(opc<1 || opc>5);
		//scanner.close();
		return opc;
	}
	
	private static List<Efemeride> crearEfemeride(List<Efemeride> efemerides) {
		Scanner scanner = new Scanner(System.in);
		int n;
		
		System.out.println("*************** ALTA DE EFEMERIDE ****************");
		System.out.println("Ingrese el código:");
		String codigo = scanner.next();
		
		int mes;
		String mesEfemeride = null;
		do {
			try {
				System.out.println("Ingrese el mes de la efemeride (1-12)");
				mes = scanner.nextInt(); 
			}catch(Exception ex) {
				mes=0;
				scanner.nextLine();
			}
		}while(mes<1 || mes >12);

		switch(mes) {
		case 1:
			mesEfemeride = "ENERO";
			break;
		case 2:
			mesEfemeride = "FEBRERO";
			break;
		case 3:
			mesEfemeride = "MARZO";
			break;
		case 4:
			mesEfemeride = "ABRIL";
			break;
		case 5:
			mesEfemeride = "MAYO";
			break;
		case 6:
			mesEfemeride = "JUNIO";
			break;
		case 7:
			mesEfemeride = "JULIO";
			break;
		case 8:
			mesEfemeride = "AGOSTO";
			break;
		case 9:
			mesEfemeride = "SEPTIEMBRE";
			break;
		case 10:
			mesEfemeride = "OCTUBRE";
			break;
		case 11:
			mesEfemeride = "NOVIEMBRE";
			break;
		case 12:
			mesEfemeride = "DICIEMBRE";
			break;
		}
		
		int dia;
		do {
			try {
				System.out.println("Ingrese el día:");
				dia = scanner.nextInt();
			}catch(Exception ex) {
				dia = 0;
				scanner.nextLine();
			}
			switch(mes){
			case 2:
				if(dia>29) {
					dia=0;
				}
				break;
			case 4,6,9,11:
				if(dia>30){
					dia=0;
					break;
				}
				
			}
		}while(dia==0 || dia>31);
		
		
		System.out.println("Ingrese el detalle:");
		String detalle = scanner.next();
		
		Efemeride efemeride = new Efemeride(codigo, Mes.valueOf(mesEfemeride),dia, detalle);
		efemerides.add(efemeride);
		
		return efemerides;
	}
	
	public static void mostrarEfemeride(List<Efemeride> efemerides) {
		for(Efemeride e: efemerides) {
			System.out.println(e);
		}
	}
	
	public static List<Efemeride> eliminarEfemeride(List<Efemeride> efemerides){
		Scanner scanner = new Scanner(System.in);
		String codigo;
		
		System.out.println("Ingresar coodigo de la efemeride:");
		codigo = scanner.next();
		Iterator<Efemeride> iterator = efemerides.iterator();
		while(iterator.hasNext()) {
			Efemeride c = (Efemeride)iterator.next();
			if(c.getCodigo().equals(codigo)) { 
				efemerides.remove(c);
			}
		}
		return efemerides;
	}

}
