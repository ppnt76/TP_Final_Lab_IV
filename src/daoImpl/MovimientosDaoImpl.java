package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.MovimientosDao;
import entidad.Movimientos;

public class MovimientosDaoImpl implements MovimientosDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	TiposMovimientoDaoImpl TipoMovImp = new TiposMovimientoDaoImpl();
	CuentasDaoImpl CueImp = new CuentasDaoImpl();
	
	@Override
	public int insert(Movimientos Movimientos) {

		int filas = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into Movimientos(Detalle,Fecha,Importe,FK_IdTipoMovimiento,FK_IdCuentas) values ("
			+ "'" + Movimientos.getDetalle() 			 		+ "'," 
			+ "('"  + Movimientos.getFecha()					+ "'), " 
					+ Movimientos.getImporte() 					+ ","
					+ Movimientos.getTipoMovimiento().getId()	+ "," 
					+ Movimientos.getCuenta().getNumeroCuenta()	+ ")";
			 
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public ArrayList<Movimientos> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Movimientos> lmov = new ArrayList<Movimientos>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM movimientos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Movimientos x = new Movimientos();
				x.setId(rs.getInt("id"));
				x.setDetalle(rs.getString("Detalle"));
				x.setFecha(rs.getDate("Fecha").toLocalDate());
				x.setImporte(rs.getFloat("Importe"));
				x.setTipoMovimiento(TipoMovImp.buscarID(rs.getInt("FK_IdTipoMovimiento")));
				x.setCuenta(CueImp.buscarCuenta(rs.getInt("FK_IdCuentas")));
				lmov.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmov;
	}

	@Override
	public ArrayList<Movimientos> buscarDNI(int dni, int tipoCuenta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Movimientos> lmov = new ArrayList<Movimientos>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM movimientos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query); 
			while (rs.next()) {
				Movimientos x = new Movimientos();
				x.setId(rs.getInt("id"));
				x.setDetalle(rs.getString("Detalle"));
				x.setFecha(rs.getDate("Fecha").toLocalDate());
				x.setImporte(rs.getFloat("Importe"));
				x.setTipoMovimiento(TipoMovImp.buscarID(rs.getInt("FK_IdTipoMovimiento")));
				x.setCuenta(CueImp.buscarCuenta(rs.getInt("FK_IdCuentas"))); 
				lmov.add(x); 
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmov;
	}
	
	@Override
	public ArrayList<Movimientos> FiltroFechas(String desde, String hasta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Movimientos> lmov = new ArrayList<Movimientos>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM movimientos where fecha >= ('" + desde + "') and fecha <=  ('" + hasta + "')" ;			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Movimientos x = new Movimientos();
				x.setId(rs.getInt("id"));
				x.setDetalle(rs.getString("Detalle"));
				x.setFecha(rs.getDate("Fecha").toLocalDate());
				x.setImporte(rs.getFloat("Importe"));
				x.setTipoMovimiento(TipoMovImp.buscarID(rs.getInt("FK_IdTipoMovimiento")));
				x.setCuenta(CueImp.buscarCuenta(rs.getInt("FK_IdCuentas")));
				lmov.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmov;
	}
}
