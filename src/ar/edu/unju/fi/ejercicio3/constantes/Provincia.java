package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(718971, 53219), SALTA(1333000,155488), TUCUMAN(1593000,22525), CATAMARCA(396895,102602),
	LA_RIOJA(362605,89680), SANTIAGO_DEL_ESTERO(1060906,136351);
	
	private int poblacion;
	private int superficie;
	
	private Provincia(int poblacion, int superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public float densidadPoblacional() {
		return (this.poblacion / this.superficie);
	}
	 

}
