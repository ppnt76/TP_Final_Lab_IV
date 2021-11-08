package dao;

import java.util.ArrayList;

import entidad.TipoCuentas;

public interface TiposCuentaDao {

	public ArrayList<TipoCuentas> readAll();
	
	public TipoCuentas buscarId (int id);

}
