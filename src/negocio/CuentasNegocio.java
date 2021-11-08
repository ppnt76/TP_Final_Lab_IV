package negocio;

import java.util.ArrayList;

import entidad.Cuentas;

public interface CuentasNegocio {
	public int insert(Cuentas cuenta);

	public int update(Cuentas cuenta);

	public int delete(Cuentas cuenta);

	public Cuentas buscarDni(int dni);

	ArrayList<Cuentas> ListarCuentas(int DNI);
	
	public int updateMonto(Double Monto, int dni, int Ncuenta);

	public ArrayList<Cuentas> ListarCuentasCBU(double cbu);
}
