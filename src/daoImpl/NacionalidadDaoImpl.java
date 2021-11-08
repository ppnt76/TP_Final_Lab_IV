package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 

import dao.NacionalidadDao;
import entidad.Nacionalidad; 

public class NacionalidadDaoImpl implements NacionalidadDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

 
 	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public ArrayList<Nacionalidad> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Nacionalidad> lcue = new ArrayList<Nacionalidad>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, Nacionalidad FROM nacionalidad;");

			while (rs.next()) {
				Nacionalidad TNacionalidadRs = new Nacionalidad();
				TNacionalidadRs.setId(rs.getInt("id"));
				TNacionalidadRs.setNacionalidad(rs.getString("Nacionalidad"));

				lcue.add(TNacionalidadRs);
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return lcue;

	}

	@Override
	public Nacionalidad buscarId(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;

		Nacionalidad NacionalidadRs = new Nacionalidad();
		try {
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, Nacionalidad  FROM Nacionalidad where id=" + id);

			while (rs.next()) {
				NacionalidadRs.setId(rs.getInt("id"));
				NacionalidadRs.setNacionalidad(rs.getString("Nacionalidad")); 

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return NacionalidadRs;

	}
}
