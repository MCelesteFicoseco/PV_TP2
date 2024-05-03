package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoTarjeta implements IPago{
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto+(0.15*monto);

	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nNumero de tarjeta: "+this.numTarjeta+
							"\nFecha de pago: "+this.fechaPago+
							"\nMonto pagado: "+this.montoPagado);
		
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	

}
