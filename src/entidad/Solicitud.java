package entidad;
import java.util.Date;
public class Solicitud {

	private int NumeroSolicitud;
	private int NumeroCuenta;
	private double MontoSolicitado;
	private int CantCuotasSolicitado;
	private String EstadoSolicitud;
	private Date FechaEmitida;
	private int CuentaDepositar;
	
	
	public Solicitud() {
		
	}
	
	public Solicitud(int numeroSolicitud,int numeroCuenta,double montoSolicitado, int cantCuotasSolicitado,
			         String estadoSolicitud, Date fechaEmitida, int cuentaDepositar)
	{ 
		
		NumeroSolicitud = numeroSolicitud;
		NumeroCuenta = numeroCuenta;
		MontoSolicitado = montoSolicitado;
		CantCuotasSolicitado = cantCuotasSolicitado;
		EstadoSolicitud = estadoSolicitud;
		FechaEmitida = fechaEmitida;
		CuentaDepositar = cuentaDepositar;
	}

	public int getNumeroSolicitud() {
		return NumeroSolicitud;
	}

	public void setNumeroSolicitud(int numeroSolicitud) {
		NumeroSolicitud = numeroSolicitud;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public double getMontoSolicitado() {
		return MontoSolicitado;
	}

	public void setMontoSolicitado(double montoSolicitado) {
		MontoSolicitado = montoSolicitado;
	}

	public int getCantCuotasSolicitado() {
		return CantCuotasSolicitado;
	}

	public void setCantCuotasSolicitado(int cantCuotasSolicitado) {
		CantCuotasSolicitado = cantCuotasSolicitado;
	}

	public String getEstadoSolicitud() {
		return EstadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		EstadoSolicitud = estadoSolicitud;
	}

	public Date getFechaEmitida() {
		return FechaEmitida;
	}

	public void setFechaEmitida(Date fechaEmitida) {
		FechaEmitida = fechaEmitida;
	}

	public int getCuentaDepositar() {
		return CuentaDepositar;
	}

	public void setCuentaDepositar(int cuentaDepositar) {
		CuentaDepositar = cuentaDepositar;
	}
	
	
	
	
	
}
