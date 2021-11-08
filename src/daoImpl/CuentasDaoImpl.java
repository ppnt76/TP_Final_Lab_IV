package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.CuentasDao;
import entidad.Cuentas;
import entidad.DatosPersonales;
import entidad.TipoCuentas;

public class CuentasDaoImpl implements CuentasDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public int insert(Cuentas cuenta) {

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
			String query = "Insert into cuentas(cbu,fechacreacion,saldo,estado,FK_Idtipocuenta,FK_DniCliente) values ("
					+ "'" + cuenta.getCbu() + "'," + "('" + cuenta.getFechaCreacion() + "'), " + cuenta.getSaldo() + ","
					+ cuenta.isEstado() + "," + cuenta.getTipoCuenta().getId() + ", " + cuenta.getDniCliente().getDni()
					+ " )";
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int update(Cuentas cuenta) {

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
			String query = "Update tpint_grupo1_v2.cuentas set saldo= ('" + cuenta.getSaldo() + "'), FK_idTipoCuenta=('" + cuenta.getTipoCuenta().getId() + "') where NumeroCuenta = ('" + cuenta.getNumeroCuenta() + "');";
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int updateMonto(Double Monto, int dni, int Ncuenta) {

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
			String query = "Update cuentas set saldo= " + Monto + " where FK_DniCliente = " + dni + " and  NumeroCuenta= " + Ncuenta + ";"; 
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int delete(Cuentas cuenta) {

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
			String query = "Update cuentas estado= false where nrocuenta= ('" + cuenta.getNumeroCuenta() + "')";
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Cuentas buscarCuenta(int numeroCuenta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		TiposCuentaDaoImpl TipoImp = new TiposCuentaDaoImpl();
		DatosPersonalesDaoImpl DniImp = new DatosPersonalesDaoImpl();

		Connection cn = null;
		Cuentas x = new Cuentas();

		try {

			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM cuentas where numeroCuenta=" + numeroCuenta;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				x.setNumeroCuenta(numeroCuenta);
				x.setCbu(rs.getDouble("Cbu"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
				x.setSaldo(rs.getDouble("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(TipoImp.buscarId(rs.getInt("FK_idTipoCuenta")));
				x.setDniCliente(DniImp.buscarDNI(rs.getInt("FK_DniCliente")));
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public Cuentas buscarDni(int dni) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		TiposCuentaDaoImpl TipoImp = new TiposCuentaDaoImpl();
		DatosPersonalesDaoImpl DniImp = new DatosPersonalesDaoImpl();

		Connection cn = null;
		Cuentas x = new Cuentas();

		try {

			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM cuentas where FK_DniCliente=" + dni;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				x.setNumeroCuenta(rs.getInt("numeroCuenta"));
				x.setCbu(rs.getDouble("Cbu"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
				x.setSaldo(rs.getDouble("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(TipoImp.buscarId(rs.getInt("FK_idTipoCuenta")));
				x.setDniCliente(DniImp.buscarDNI(dni));
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public ArrayList<Cuentas> ListarCuentas(int DNI) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Cuentas> lc = new ArrayList<Cuentas>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT NumeroCuenta, Cbu, FechaCreacion, Saldo, Estado, FK_idTipoCuenta, tc.Descripcion as DescTP, FK_DniCliente FROM cuentas c inner join tipocuenta tc on c.FK_idTipoCuenta = tc.id where FK_DniCliente = "+ DNI;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Cuentas x = new Cuentas();

				TipoCuentas tp = new TipoCuentas();
				tp.setId(rs.getInt("FK_idTipoCuenta"));
				tp.setDescripcion(rs.getString("DescTP"));

				DatosPersonales dp = new DatosPersonales();
				dp.setDni(rs.getInt("FK_DniCliente"));

				x.setNumeroCuenta(rs.getInt("NumeroCuenta"));
				x.setCbu(rs.getDouble("CBU"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
				x.setSaldo(rs.getDouble("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(tp);
				x.setDniCliente(dp);

				lc.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

	public ArrayList<Cuentas> updateMonto(int dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Cuentas> lc = new ArrayList<Cuentas>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT NumeroCuenta, Cbu, FechaCreacion, Saldo, Estado, FK_idTipoCuenta, tc.Descripcion as DescTP, FK_DniCliente FROM cuentas c inner join tipocuenta tc on c.FK_idTipoCuenta = tc.id where FK_idTipoCuenta = "
					+ dni;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Cuentas x = new Cuentas();

				TipoCuentas tp = new TipoCuentas();
				tp.setId(rs.getInt("FK_idTipoCuenta"));
				tp.setDescripcion(rs.getString("DescTP"));

				DatosPersonales dp = new DatosPersonales();
				dp.setDni(rs.getInt("FK_DniCliente"));

				x.setNumeroCuenta(rs.getInt("NumeroCuenta"));
				x.setCbu(rs.getDouble("CBU"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
				x.setSaldo(rs.getDouble("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(tp);
				x.setDniCliente(dp);

				lc.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

	@Override
	public ArrayList<Cuentas> ListarCuentasCBU(double cbu) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Cuentas> lc = new ArrayList<Cuentas>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT NumeroCuenta, Cbu, FechaCreacion, Saldo, Estado, FK_idTipoCuenta, tc.Descripcion as DescTP, FK_DniCliente FROM cuentas c inner join tipocuenta tc on c.FK_idTipoCuenta = tc.id where cbu= "
					+ cbu;
			System.out.println(query);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Cuentas x = new Cuentas();

				TipoCuentas tp = new TipoCuentas();
				tp.setId(rs.getInt("FK_idTipoCuenta"));
				tp.setDescripcion(rs.getString("DescTP"));

				DatosPersonales dp = new DatosPersonales();
				dp.setDni(rs.getInt("FK_DniCliente"));

				x.setNumeroCuenta(rs.getInt("NumeroCuenta"));
				x.setCbu(rs.getDouble("CBU"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
				x.setSaldo(rs.getDouble("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(tp);
				x.setDniCliente(dp);

				lc.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

}
