package negocio;

import java.util.ArrayList;

import entidad.Movimientos;

public interface MovimientosNegocio {
	public ArrayList<Movimientos> readAll();

	ArrayList<Movimientos> buscarDNI(int dni, int tip);
	

	public int insert(Movimientos Movimientos);
	

	ArrayList<Movimientos> FiltroFechas(String desde, String hasta);

}
