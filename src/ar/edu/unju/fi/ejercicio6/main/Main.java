package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.IConverter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield",(byte)45, 12f);
		
		IConverter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		converter.mostrarObjeto(felino1);
		
		// Conversion de un felino salvaje a doméstico
		
		FelinoSalvaje pantera = new FelinoSalvaje("Tanner",(byte)20, 186f);
		IConverter<FelinoSalvaje, FelinoDomestico> converterSalvajeDomestico = x-> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
		if(IConverter.isNotNull(pantera)) {
			FelinoDomestico domestico1 = converterSalvajeDomestico.convert(pantera);
			converterSalvajeDomestico.mostrarObjeto(domestico1);
		}
		

	}

}