package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.TiposMovimientoDao;
import entidad.TipoMovimiento;

public class TiposMovimientoDaoImpl implements TiposMovimientoDao {
	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public ArrayList<TipoMovimiento> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<TipoMovimiento> Tmovimiento = new ArrayList<TipoMovimiento>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);

			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, descripcion FROM tipomovimiento;");

			while (rs.next()) {

				TipoMovimiento TmovimientoRs = new TipoMovimiento();
				TmovimientoRs.setDescripcion(rs.getString("descripcion"));

				Tmovimiento.add(TmovimientoRs);

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return Tmovimiento;

	}

	@Override
	public TipoMovimiento buscarID(int id) {

		TipoMovimiento TmovimientoRs = new TipoMovimiento();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);

			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM tipoMovimiento where id =" + id);

			while (rs.next()) {
				TmovimientoRs.setId(id);
				TmovimientoRs.setDescripcion(rs.getString("descripcion"));
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return TmovimientoRs;

	}
}
