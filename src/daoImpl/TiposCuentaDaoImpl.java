package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.TiposCuentaDao;
import entidad.TipoCuentas;

public class TiposCuentaDaoImpl implements TiposCuentaDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public ArrayList<TipoCuentas> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<TipoCuentas> lcue = new ArrayList<TipoCuentas>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, descripcion FROM TipoCuenta;");

			while (rs.next()) {
				TipoCuentas TcuentaRs = new TipoCuentas();
				TcuentaRs.setId(rs.getInt("id"));
				TcuentaRs.setDescripcion(rs.getString("descripcion"));

				lcue.add(TcuentaRs);
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return lcue;

	}
	
	@Override
	public TipoCuentas buscarId(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;

		TipoCuentas TcuentaRs = new TipoCuentas();

		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(" SELECT * FROM TipoCuenta where id=" + id);
			while (rs.next()) {
				TcuentaRs.setId(id);
				TcuentaRs.setDescripcion(rs.getString("descripcion"));
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return TcuentaRs;

	}

}
