package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.util.Categoria;
import ar.edu.unju.fi.ejercicio1.util.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	public static void main(String[] args) {
		List<Producto> productos= new ArrayList<>();
		
		int n;
		String[] codigos = {"Producto1","Producto2","Producto3","Producto4","Producto5","Producto6","Producto7",
							"Producto8","Producto9","Producto10","Producto11","Producto12","Producto13","Producto14","Producto15"};
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
		boolean[] estados = {true,true,false,true,true,false,true,true,
							true,true,false,true,true,true,false};
		
		for(int i=0; i<15; i++) {
			Producto p = new Producto(codigos[i],descripciones[i],preciosU[i],origenes[i],
										categorias[i],estados[i]);
			productos.add(p);
		}
		
		
		
		
		do {
			n = menu();
			
			switch(n) {
			case 1:
				mostrarTrueConConsumer(productos);
				break;
			case 2:
				mostrarFalseConPredicate(productos);
				break;
			case 3:
				incrementarPrecios(productos);
				break;
			case 4:
				mostrarElectrogarTrue(productos);
				break;
			case 5:
				ordenarDescendente(productos);
				break;
			case 6:
				mostrarMayuscula(productos);
				break;

			}
		}while (n != 7);
		
		System.out.println("Programa terminado....");

	}
	
	private static void mostrarMayuscula(List<Producto> productos) {
		List<Producto> mayuscula = new ArrayList<Producto>();
		Function<Producto,Producto> funcion = (mayus) -> {mayus.setCodigo(mayus.getCodigo().toUpperCase());
		return mayus;};
		mayuscula = productos.stream().map(funcion).collect(Collectors.toList());
		Consumer<Producto> printConsumer = c-> System.out.println(c);
		mayuscula.forEach(printConsumer);
		
	}

	private static void ordenarDescendente(List<Producto> productos) {
		productos.sort(Comparator.comparing(Producto::getPrecioUnitario));
		
	}

	private static void mostrarElectrogarTrue(List<Producto> productos) {
		List<Producto> productoElectrohogar = new ArrayList<Producto>();
		Predicate<Producto> filterTrue = f -> f.getEstado()==true && f.getCategoria()==Categoria.ELECTROHOGAR;
		Consumer<Producto> printConsumer = c-> System.out.println(c);
		productoElectrohogar = productos.stream().filter(filterTrue).collect(Collectors.toList());
		productoElectrohogar.forEach(printConsumer);
		
	}

	private static void incrementarPrecios(List<Producto> productos) {
		Consumer<Producto> incrementarP = c-> c.setPrecioUnitario(c.getPrecioUnitario()+(float)(c.getPrecioUnitario()*0.2));
		productos.forEach(incrementarP);
		
	}

	private static void mostrarFalseConPredicate(List<Producto> productos) {
		List<Producto> productosFalse = new ArrayList<Producto>();
		Predicate<Producto> filterFalse = f -> f.getEstado()==false;
		Consumer<Producto> printConsumer = c-> System.out.println(c);
		productosFalse = productos.stream().filter(filterFalse).collect(Collectors.toList());
		productosFalse.forEach(printConsumer);
	}

	private static void mostrarTrueConConsumer(List<Producto> productos) {
		List<Producto> productosTrue = new ArrayList<Producto>();
		for(Producto p:productos) {
			if(p.getEstado()==true) {
				productosTrue.add(p);
			}
		}
		Consumer<Producto> printConsumer = c-> System.out.println(c);
		productosTrue.forEach(printConsumer);
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		int opc;
		
		
		System.out.println("------------------- MENU -------------------");
		System.out.println("1 - Mostrar productos");
		System.out.println("2 - Mostrar productos faltantes");
		System.out.println("3 - Incrementar precios en un 20%");
		System.out.println("4 - Mostrar los productos de Electrohogar y disponibles para la venta");
		System.out.println("5 - Ordenar los productos por precio de forma descendente");
		System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
		System.out.println("7 - Salir");
		System.out.println("-------------------------------------------");
		do {
			System.out.println("Ingrese una opción");
			opc = scanner.nextInt();
		}while(opc<1 || opc>7);
		return opc;
	}

}
