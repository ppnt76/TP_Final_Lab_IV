package negocio;

import java.util.ArrayList; 
import entidad.Rol;

public interface RolNegocio {
	public ArrayList<Rol> readAll();

	Rol buscarId(int rolentero);

}
