package negocio;

import java.util.ArrayList; 

import entidad.Solicitud;

public interface SolicitudNegocio {
	public int insert(Solicitud soli);
    public ArrayList<Solicitud> readAll();
    public int updateSolicitud(int numero);
	ArrayList<Solicitud> buscar(String cuenta);
	int UpdateRechazoSolicitud(int numeroSolicitud);
	int UpdateSumarPrestamo(int numeroCuenta, double montoSolicitado);
	Solicitud buscarSolicitud(int nsoli); 
}