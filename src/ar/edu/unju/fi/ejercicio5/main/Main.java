package ar.edu.unju.fi.ejercicio5.main;

import ar.edu.unju.fi.ejercicio1.util.Categoria;
import ar.edu.unju.fi.ejercicio1.util.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Producto> productos= new ArrayList<>();
		List<Producto> compra= new ArrayList<>();
		
		int n;
		String[] codigos = {"P1","P2","P3","P4","P5","P6","P7",
							"P8","P9","P10","P11","P12","P13","P14","P15"};
		String[] descripciones = {"d1","d2","d3","d4","d5","d5","d6","d7",
								  "d8","d9","d10","d11","d12","d13","d14","d15"};
		float[] preciosU = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		OrigenFabricacion[] origenes = {OrigenFabricacion.ARGENTINA,OrigenFabricacion.BRASIL,
										OrigenFabricacion.CHINA, OrigenFabricacion.URUGUAY,
										OrigenFabricacion.ARGENTINA,OrigenFabricacion.BRASIL,
										OrigenFabricacion.CHINA, OrigenFabricacion.URUGUAY,
										OrigenFabricacion.ARGENTINA,OrigenFabricacion.BRASIL,
										OrigenFabricacion.CHINA, OrigenFabricacion.URUGUAY,
										OrigenFabricacion.ARGENTINA,OrigenFabricacion.BRASIL,
										OrigenFabricacion.CHINA};
		Categoria[] categorias = {Categoria.ELECTROHOGAR,Categoria.HERRAMIENTAS,
								 Categoria.INFORMATICA, Categoria.TELEFONIA,
								 Categoria.ELECTROHOGAR,Categoria.HERRAMIENTAS,
								 Categoria.INFORMATICA, Categoria.TELEFONIA,
								 Categoria.ELECTROHOGAR,Categoria.HERRAMIENTAS,
								 Categoria.INFORMATICA, Categoria.TELEFONIA,
								 Categoria.ELECTROHOGAR,Categoria.HERRAMIENTAS,
								 Categoria.INFORMATICA};
		boolean[] estados = {true,true,true,true,true,true,true,true,
							true,true,true,true,true,true,true};
		
		for(int i=0; i<15; i++) {
			Producto p = new Producto(codigos[i],descripciones[i],preciosU[i],origenes[i],
										categorias[i],estados[i]);
			productos.add(p);
		}
		

		
		do {
			n = menu();
			
			switch(n) {
			case 1:
				mostrarProdctos(productos);
				break;
			case 2:
				compra = realizarCompra(productos, compra);
				n = 3;
				break;

			}
		}while (n != 3);
		
		System.out.println("Programa terminado....");
		

	}
	
	public static void mostrarProdctos(List<Producto> productos) {
		for(Producto p:productos) {
			System.out.println(p);
		}
		
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int opc;
		
		
		System.out.println("------------------- MENU -------------------");
		System.out.println("1 - Mostrar productos");
		System.out.println("2 - Realizar compra");
		System.out.println("3 - Salir");
		System.out.println("-------------------------------------------");
		do {
			System.out.println("Ingrese una opción");
			opc = scanner.nextInt();
		}while(opc<1 || opc>5);
		return opc;
	}
	
	public static List<Producto> realizarCompra(List<Producto> productos, List<Producto> compra) {
		Scanner scanner = new Scanner(System.in);
		int opcPago;
		String opcProducto="no", codigo, numTrajeta;
		boolean existe=false;
		float montoTotal=0;
		
		do {
			System.out.println("Ingrese el codigo del producto:");
			codigo = scanner.next();
			try {
				for(Producto p: productos) {
					if(p.getCodigo().equals(codigo)) {
						compra.add(p);
						montoTotal = montoTotal + p.getPrecioUnitario();
						existe = true;
					}
				}
				if(existe == false) {
					System.out.println("El código ingresado no existe!");
					opcProducto = "si";
				}else {
					System.out.println("Desea comprar otro producto? si/no");
					opcProducto = scanner.next();
					
				}
			}catch(Exception ex) {
				opcProducto = "si";
			}
			existe=false;
		}while(opcProducto == "no");
		
		
		do {
			try {
				System.out.println("    FORMA DE PAGO");
				System.out.println("1 - Pago efectivo");
				System.out.println("2 - Pago con tarjeta");
				System.out.println("Elegir una opcion:");
				opcPago = scanner.nextInt();
			}catch(Exception ex) {
				opcPago=0;
				scanner.nextLine();
			}
		}while(opcPago<1 || opcPago>2);
		
		switch(opcPago) {
		case 1:
			PagoEfectivo efectivo = new PagoEfectivo();
			efectivo.setFechaPago(LocalDate.now());
			efectivo.realizarPago(montoTotal);
			efectivo.imprimirRecibo();
			break;
		case 2:
			PagoTarjeta tarjeta = new PagoTarjeta();
			System.out.println("Ingerse numero de tarjeta");
			numTrajeta = scanner.next();
			tarjeta.setFechaPago(LocalDate.now());
			tarjeta.realizarPago(montoTotal);
			tarjeta.imprimirRecibo();
			break;
		}
	
		return compra;
	}

}
