package entidad;

import java.time.LocalDate;

public class Prestamos {

	private int Id;
	private int CuotasPagas;
	private int CuotasTotal;
	private double ImporteCuota;
	private double ImportePedidoTotal;
	private LocalDate FechaUltimoPago;
	private int NumeroCuenta;

	public Prestamos() {

	}

	public Prestamos(int id, int cuotasPagas, int cuotasTotal, double importeCuota, double importePedidoTotal,
			LocalDate fechaUltimoPago, int numeroCuenta) {
		Id = id;
		CuotasPagas = cuotasPagas;
		CuotasTotal = cuotasTotal;
		ImporteCuota = importeCuota;
		ImportePedidoTotal = importePedidoTotal;
		FechaUltimoPago = fechaUltimoPago;
		NumeroCuenta = numeroCuenta;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCuotasPagas() {
		return CuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		CuotasPagas = cuotasPagas;
	}

	public int getCuotasTotal() {
		return CuotasTotal;
	}

	public void setCuotasTotal(int cuotasTotal) {
		CuotasTotal = cuotasTotal;
	}

	public double getImporteCuota() {
		return ImporteCuota;
	}

	public void setImporteCuota(double importeCuota) {
		ImporteCuota = importeCuota;
	}

	public double getImportePedidoTotal() {
		return ImportePedidoTotal;
	}

	public void setImportePedidoTotal(double importePedidoTotal) {
		ImportePedidoTotal = importePedidoTotal;
	}

	public LocalDate getFechaUltimoPago() {
		return FechaUltimoPago;
	}

	public void setFechaUltimoPago(LocalDate fechaUltimoPago) {
		FechaUltimoPago = fechaUltimoPago;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}
}