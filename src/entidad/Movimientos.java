package entidad;

import java.time.LocalDate;

public class Movimientos {

	private int Id;
	private String Detalle;
	private LocalDate Fecha;
	private double Importe;
	private TipoMovimiento TipoMovimiento;
	private Cuentas Cuenta;

	public Movimientos() {
	}

	public Movimientos(int id, String detalle, LocalDate fecha, double importe, TipoMovimiento tipoMovimiento,
			Cuentas cuenta) {
		Id = id;
		Detalle = detalle;
		Fecha = fecha;
		Importe = importe;
		TipoMovimiento = tipoMovimiento;
		Cuenta = cuenta;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public double getImporte() {
		return Importe;
	}

	public void setImporte(double importe) {
		Importe = importe;
	}

	public TipoMovimiento getTipoMovimiento() {
		return TipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}

	public Cuentas getCuenta() {
		return Cuenta;
	}

	public void setCuenta(Cuentas cuenta) {
		Cuenta = cuenta;
	}

}
