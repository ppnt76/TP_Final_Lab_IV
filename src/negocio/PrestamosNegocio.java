package negocio;

import java.util.ArrayList;

import entidad.Prestamos;

public interface PrestamosNegocio {
	public boolean insertPrestamo(Prestamos prestamo);
	public ArrayList<Prestamos> readAll(int dni);
	public ArrayList<Prestamos> readAll();
	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo);
	public Prestamos BuscarPrestamos(String numero);
	public boolean ComprobarSaldo(double saldo, String Ncuenta);
	public boolean UpdateCuotas(String NPrestamo,int cantCuotasPagas);
	public boolean RestarSaldo(int Ncuenta, double saldo); 

	ArrayList<Prestamos> FiltroMonto(String desde, String hasta);
}

