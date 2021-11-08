package negocio;

import java.util.List;

import entidad.Telefonos;

public interface TelefonosNegocio {
	public int insert(Telefonos usuario);
	public int update(Telefonos usuario);

	public List<Telefonos> readAll();
	Telefonos buscarId(int id);
}
