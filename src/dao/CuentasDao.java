package dao;

import java.util.ArrayList;

import entidad.Cuentas;

public interface CuentasDao {
	public int insert(Cuentas cuenta);

	public int update(Cuentas cuenta);

	public int delete(Cuentas cuenta);

	public Cuentas buscarCuenta(int numeroCuenta);

	public Cuentas buscarDni(int dni);

	public ArrayList<Cuentas> ListarCuentas(int DNI); 

	public int updateMonto(Double Monto, int dni, int Ncuenta);

	public ArrayList<Cuentas> ListarCuentasCBU(double cbu);
	
	public ArrayList<Cuentas> TC(int tc);
	public ArrayList<Cuentas> readAll();

}
