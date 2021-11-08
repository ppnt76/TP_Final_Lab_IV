package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DatosPersonalesDao;
import dao.RolDao;
import dao.UsuarioDao;
import entidad.DatosPersonales;
import entidad.Rol;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public int insert(Usuario usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into tpint_grupo1_v2.usuario (NombreUsuario, Contraseña, FK_IdRol, FK_DniDp, Estado) values ("
					+ "'" + usuario.getNombreUsuario() + "'," + "'" + usuario.getContraseña() + "'," + "'"
					+ usuario.getRol().getId() + "'," + "'" + usuario.getdp_DNI().getDni() + "'," + usuario.isEstado()
					+ ")";

			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int updateDNI(DatosPersonales DatosPersonales) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "update usuario set FK_DniDp = '" + DatosPersonales.getDni() + "' where  FK_DniDp = '"
					+ DatosPersonales.getDni() + "'";

			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int updatePass(String passNueva, String usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "update tpint_grupo1_v2.usuario set Contraseña='" + passNueva + "'  where NombreUsuario='"
					+ usuario + "'";

			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int delete(String id, String usuario) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "update usuario set estado = 0 where FK_DniDP='" + id + "' and NombreUsuario='" + usuario
					+ "'";
			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public ArrayList<Usuario> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Usuario> Lusuario = new ArrayList<Usuario>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery("Select * from usuario");

			while (rs.next()) {

				Usuario usuario = new Usuario();
				RolDao rolrs = new RolDaoImpl();
				DatosPersonalesDao dnirs = new DatosPersonalesDaoImpl();

				usuario.setId(rs.getInt("id"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setRol(rolrs.buscarId(rs.getInt("FK_idRol")));
				usuario.setDatosPersonales(dnirs.buscarDNI(rs.getInt("FK_DniDP")));
				usuario.setEstado(rs.getBoolean("Estado"));

				Lusuario.add(usuario);
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return Lusuario;
	}

	@Override
	public Usuario obtenerUnUsuario(int id, String NombreUsuario) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;

		Usuario usuario = new Usuario();

		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st
					.executeQuery("Select id, NombreUsuario, contraseña, FK_idRol, FK_DniDP, Estado from usuario "
							+ " where FK_DniDP = " + id + " or NombreUsuario = '" + NombreUsuario + "'");

			while (rs.next()) {

				RolDao rolrs = new RolDaoImpl();
				DatosPersonalesDao dnirs = new DatosPersonalesDaoImpl();

				usuario.setId(rs.getInt("id"));
				usuario.setNombreUsuario(rs.getString("NombreUsuario"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setRol(rolrs.buscarId(rs.getInt("FK_idRol")));
				usuario.setDatosPersonales(dnirs.buscarDNI(rs.getInt("FK_DniDP")));
				usuario.setEstado(rs.getBoolean("Estado"));

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return usuario;
	}

	@Override
	public Usuario logueo(String passLogin, String NombreUsuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		DatosPersonales dp = new DatosPersonales();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			PreparedStatement miSentencia = cn.prepareStatement("Select u.NombreUsuario, u.contraseña, "
					+ "u.FK_idRol, r.Descripcion, u.FK_DniDP, u.Estado "
					+ "from usuario u inner join rol r on r.id=u.FK_idRol where u.contraseña = ? and u.NombreUsuario = ?;");
			miSentencia.setString(1, passLogin); // Cargo el ID recibido
			miSentencia.setString(2, NombreUsuario); // Cargo el usuario recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();

			rol.setId(resultado.getInt(3));
			rol.setDescripcion(resultado.getString(4));

			dp.setDni(resultado.getInt(5));

			usuario.setNombreUsuario(resultado.getString(1));
			usuario.setContraseña(resultado.getString(2));
			usuario.setRol(rol);
			usuario.setDatosPersonales(dp);
			usuario.setEstado(resultado.getBoolean(6));
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/* Procedimiento */
	public void procedimientoInsertarUsuario(Usuario usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			CallableStatement proc = cn.prepareCall(" CALL crearUsuario(?,?) ");
			proc.setString("NombreUsuario", usuario.getNombreUsuario());// Tipo String
			proc.execute();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
