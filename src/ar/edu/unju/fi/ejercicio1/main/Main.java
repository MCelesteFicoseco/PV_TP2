package ar.edu.unju.fi.ejercicio1.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.util.Categoria;
import ar.edu.unju.fi.ejercicio1.util.OrigenFabricacion;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		List<Producto> productos = new ArrayList<>();
		
		do {
			n = menu();
			
			switch(n) {
			case 1:
				productos = crearProducto(productos);
				break;
			case 2:
				mostrarProducto(productos);
				break;
			case 3:
				modificarProducto(productos);
				break;
			}
		}while (n != 4);
		System.out.println("Programa finalizado correctamente");
		
	}
	
	
	
	public static List<Producto> crearProducto(List<Producto> productos) {
		Scanner scanner = new Scanner(System.in);
		int n;
		
		System.out.println("*************** ALTA DE PRODUCTO ****************");
		System.out.println("Ingrese el código:");
		String codigo = scanner.next();
		
		System.out.println("Ingrese la descripcion:");
		String descripcion = scanner.next();
		
		float precioUnitario;
		do {
			try {
				System.out.println("Ingrese precio unitario:");
				precioUnitario = scanner.nextFloat();
			}catch(Exception ex){
				precioUnitario = (float)0.0;
				scanner.nextLine();
			}
			
		}while(precioUnitario==0.0 || precioUnitario<0.0);
		
		
		int origen;
		String origenFabricacion = null;
		do {
			System.out.println("Origen de fabricacion:");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			System.out.println("Elija una opcion:");
			origen = scanner.nextInt(); 
		}while(origen<1 || origen >4);
		
		switch(origen) {
		case 1:
			origenFabricacion = "ARGENTINA";
			break;
		case 2:
			origenFabricacion = "CHINA";
			break;
		case 3:
			origenFabricacion = "BRASIL";
			break;
		case 4:
			origenFabricacion = "URUGUAY";
			break;
		}
		
		
		
		int opcCategoria;
		String categoria = null;
		do {
			System.out.println("Categoria:");
			System.out.println("1 - Telefonia");
			System.out.println("2 - Informática");
			System.out.println("3 - Electro hogar");
			System.out.println("4 - Herramientas");
			System.out.println("Elija una opcion:");
			opcCategoria = scanner.nextInt(); 
		}while(opcCategoria<1 || opcCategoria >4);
		
		switch(opcCategoria) {
		case 1:
			categoria = "TELEFONIA";
			break;
		case 2:
			categoria = "INFORMATICA";
			break;
		case 3:
			categoria = "ELECTROHOGAR";
			break;
		case 4:
			categoria = "HERRAMIENTAS";
			break;
		}
		
		Producto producto = new Producto(codigo, descripcion, precioUnitario, OrigenFabricacion.valueOf(origenFabricacion), Categoria.valueOf(categoria));
		productos.add(producto);
		
		return productos;
	}



	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int opc;
		
		System.out.println("------------------- MENU -------------------");
		System.out.println("1 - Crear producto");
		System.out.println("2 - Mostrar productos");
		System.out.println("3 - Modificar producto");
		System.out.println("4 - Salir");
		System.out.println("-------------------------------------------");
		do {
			System.out.println("Ingrese una opción");
			opc = scanner.nextInt();
		}while(opc<1 || opc>4);
		//scanner.close();
		return opc;
	}
	
	public static void mostrarProducto(List<Producto> productos) {
		for(Producto c: productos) {
			System.out.println(c);
		}
	}
	
	public static List<Producto> modificarProducto(List<Producto> productos){
		Scanner scanner = new Scanner(System.in);
		String codigo;
		System.out.println("Ingresar codigo:");
		codigo = scanner.next();
		
		for(Producto p:productos) {
			if(p.getCodigo().equals(codigo)) {
				String salir;
				do {
					int e =0;
					do {
						System.out.println("----> MODIFICAR DATOS DE "+p.getCodigo());
						System.out.println("1) Descripcion \n2)Precio unitario \n3)Origen \n4)Categoria");
						System.out.println("Ingrese una opcion:");
						e = scanner.nextInt();
						
					}while(e<1 || e>4);
					switch(e) {
						case 1:
							System.out.println("Ingrese la descripcion:");
							String descripcion = scanner.next();
							p.setDescripcion(descripcion);
							break;
							
						case 2:
							float precioUnitario;
							do {
								try {
									System.out.println("Ingrese precio unitario:");
									precioUnitario = scanner.nextFloat();
								}catch(Exception ex){
									precioUnitario = (float)0.0;
									scanner.nextLine();
								}
								
							}while(precioUnitario==0.0 || precioUnitario<0.0);
							p.setPrecioUnitario(precioUnitario);
							break;
							
						case 3:
							int origen;
							String origenFabricacion = null;
							do {
								System.out.println("Origen de fabricacion:");
								System.out.println("1 - Argentina");
								System.out.println("2 - China");
								System.out.println("3 - Brasil");
								System.out.println("4 - Uruguay");
								System.out.println("Elija una opcion:");
								origen = scanner.nextInt(); 
							}while(origen<1 || origen >4);
							
							switch(origen) {
							case 1:
								origenFabricacion = "ARGENTINA";
								break;
							case 2:
								origenFabricacion = "CHINA";
								break;
							case 3:
								origenFabricacion = "BRASIL";
								break;
							case 4:
								origenFabricacion = "URUGUAY";
								break;
							}
							p.setOrigenFabricacion(OrigenFabricacion.valueOf(origenFabricacion));
							break;
						
						case 4:
							int opcCategoria;
							String categoria = null;
							do {
								System.out.println("Categoria:");
								System.out.println("1 - Telefonia");
								System.out.println("2 - Informática");
								System.out.println("3 - Electro hogar");
								System.out.println("4 - Herramientas");
								System.out.println("Elija una opcion:");
								opcCategoria = scanner.nextInt(); 
							}while(opcCategoria<1 || opcCategoria >4);
							
							switch(opcCategoria) {
							case 1:
								categoria = "TELEFONIA";
								break;
							case 2:
								categoria = "INFORMATICA";
								break;
							case 3:
								categoria = "ELECTROHOGAR";
								break;
							case 4:
								categoria = "HERRAMIENTAS";
								break;
							}
							p.setCategoria(Categoria.valueOf(categoria));
							break;
							
					}
					System.out.println("Desea modificar otro campo del mismo producto? si/no");
					salir = scanner.next();
				}while(salir == "si");
			}
		}
		
		return null;
	}
	
	
	
}
