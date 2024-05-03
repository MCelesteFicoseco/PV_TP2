package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoEfectivo implements IPago {
	
	private LocalDate fechaPago;
	private double montoPagado;

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto-(0.10*monto);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nFecha de pago: "+this.fechaPago+
							"\nMonto pagado: "+this.montoPagado);
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
