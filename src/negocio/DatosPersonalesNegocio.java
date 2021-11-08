package negocio;

import java.util.List;

import entidad.DatosPersonales;
import exceptions.cuilException;
import exceptions.telefonoException;

public interface DatosPersonalesNegocio {
	public int insert(DatosPersonales persona);
	public int update(DatosPersonales persona); 
	public DatosPersonales buscarDNI(int id);
	public List<DatosPersonales> readAll();
	boolean validarCuil(double cuil) throws cuilException;
	boolean validarTelefono(String tel) throws telefonoException;
}
