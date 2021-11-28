package dao;

import java.util.ArrayList;

import entidad.DatosPersonales;


public interface DatosPersonalesDao {
	public int insert(DatosPersonales persona);
	public int update(DatosPersonales persona); 
	public DatosPersonales buscarDNI(int id); 
	public ArrayList<DatosPersonales> readAll();
	
	ArrayList<DatosPersonales> Fechas(String desde, String hasta);
}
