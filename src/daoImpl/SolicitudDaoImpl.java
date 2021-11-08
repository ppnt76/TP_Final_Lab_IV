package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.SolicitudDao;
import entidad.Solicitud;

public class SolicitudDaoImpl implements SolicitudDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public int insert(Solicitud soli) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int filas = 0;

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			String query = "insert into solicitud(FK_NCuenta, Montosolicitado, CantCuotasSolicitadas, EstadoSolicitud)   values ("
					+ +soli.getCuentaDepositar() + "," + soli.getMontoSolicitado() + ","
					+ soli.getCantCuotasSolicitado() + "," + "'" + soli.getEstadoSolicitud() + "')";

			filas = st.executeUpdate(query);
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public ArrayList<Solicitud> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(
					"SELECT idSolicitud, FK_NCuenta, Montosolicitado, CantCuotasSolicitadas, EstadoSolicitud"
							+ " FROM solicitud");

			while (rs.next()) {

				Solicitud solicitudRs = new Solicitud();
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("Montosolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setEstadoSolicitud(rs.getString("EstadoSolicitud"));

				solicitud.add(solicitudRs);

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return solicitud;
	}

	
	public int updateSolicitud(int numero) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("numero de query " + numero);

		int filas = 0;
		String estado = "Autorizado";
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			String query = ("update solicitud set EstadoSolicitud =('" +estado+ "')" + " where idSolicitud="
					+ numero);
			System.out.println("query " + query);
			filas = st.executeUpdate(query);
			if (filas > 0) {
				cn.close();
				return filas;
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
			e.printStackTrace();
		} finally {

		}
		return filas;

	}

	@Override
	public ArrayList<Solicitud> buscar(String cliente) {
		int cliente2 = Integer.parseInt(cliente);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM solicitud where FK_NCuenta =" + cliente2);

			while (rs.next()) {
				Solicitud solicitudRs = new Solicitud();
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("Montosolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setEstadoSolicitud(rs.getString("EstadoSolicitud"));
				solicitud.add(solicitudRs);
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return solicitud;

	}

	@Override
	public Solicitud buscarSolicitud(int Nsolicitud) {
		Solicitud solicitudRs = new Solicitud();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(
					"SELECT idSolicitud, FK_NCuenta, Montosolicitado, CantCuotasSolicitadas, EstadoSolicitud"
							+ " FROM solicitud where idSolicitud =" + Nsolicitud);

			while (rs.next()) {
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("Montosolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setEstadoSolicitud(rs.getString("EstadoSolicitud"));

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return solicitudRs;
	}

	@Override
	public int UpdateRechazoSolicitud(int numero) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int filas = 0;
		String estado = "Rechazado";
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			String query = ("update solicitud set EstadoSolicitud =('" +estado+ "')" + "where idSolicitud ="
					+ numero);

			filas = st.executeUpdate(query);
			if (filas > 0) {
				cn.close();
				return filas;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return filas;

	}

	@Override
	public int UpdateSumarPrestamo(int numeroCuenta, double d) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int filas = 0;

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			String query = ("update cuentas set Saldo =('" +d+ "'+ Saldo)" + "where NumeroCuenta =" + numeroCuenta);

			filas = st.executeUpdate(query);
			if (filas > 0) {
				cn.close();
				return filas;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return filas;
	}

}
