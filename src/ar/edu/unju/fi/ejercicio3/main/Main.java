package ar.edu.unju.fi.ejercicio3.main;



import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values() ;
		
		for(Provincia p: provincias) {
			System.out.println("\n---> "+p.name()+"\nPoblacion: "+p.getPoblacion()+
					" habitantes \nSuperficie: "+p.getSuperficie()+"km2\nDensidad: "+p.densidadPoblacional()+"hab/km2");
		}
	}

}
