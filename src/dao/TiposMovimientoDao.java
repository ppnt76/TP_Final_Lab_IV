package dao;
import java.util.ArrayList;

import entidad.TipoMovimiento;

public interface TiposMovimientoDao {
	
	public ArrayList<TipoMovimiento> readAll();

	public TipoMovimiento buscarID(int id);
}
