package dao;

import java.util.ArrayList;
import entidad.Rol;

public interface RolDao {

	public ArrayList<Rol> readAll();

	public Rol buscarId(int id);
}
