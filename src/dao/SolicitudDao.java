package dao;

import java.util.ArrayList;
import entidad.Solicitud;

public interface SolicitudDao {

	public ArrayList<Solicitud> readAll();

	public int updateSolicitud(int numero);

	public int UpdateRechazoSolicitud(int numero);

	public ArrayList<Solicitud> buscar(String cliente);

	public Solicitud buscarSolicitud(int Nsolicitud);

	public int insert(Solicitud soli);

	public int UpdateSumarPrestamo(int numeroCuenta, double d);
}
