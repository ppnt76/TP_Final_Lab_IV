package entidad;

import java.time.LocalDate;

public class Cuentas {

	private int NumeroCuenta;
	private double Cbu;
	private TipoCuentas TipoCuenta;
	private DatosPersonales DpDNI;
	private LocalDate FechaCreacion;
	private double Saldo;
	private boolean Estado;

	public Cuentas(int numeroCuenta, double cbu, TipoCuentas tipoCuenta, DatosPersonales dpDNI, LocalDate fechaCreacion,
			double saldo, boolean estado) {
		NumeroCuenta = numeroCuenta;
		Cbu = cbu;
		TipoCuenta = tipoCuenta;
		DpDNI = dpDNI;
		FechaCreacion = fechaCreacion;
		Saldo = saldo;
		Estado = estado;
	}

	public Cuentas() {
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public double getCbu() {
		return Cbu;
	}

	public void setCbu(double cbu) {
		Cbu = cbu;
	}

	public TipoCuentas getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(TipoCuentas tP) {
		TipoCuenta = tP;
	}

	public DatosPersonales getDniCliente() {
		return DpDNI;
	}

	public void setDniCliente(DatosPersonales dniInt) {
		DpDNI = dniInt;
	}

	public LocalDate getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCre) {
		FechaCreacion = fechaCre;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
