package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DatosPersonalesDao;
import entidad.DatosPersonales;
import entidad.Nacionalidad;
import entidad.Telefonos;

public class DatosPersonalesDaoImpl implements DatosPersonalesDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_V2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public int insert(DatosPersonales persona) {

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

			String query = "Insert into datospersonales(DNI, Cuil, Nombre, Apellido, sexo, FechaNacimiento,"
					+ " Direccion, Localidad, Provincia, Mail, FK_Nacionalidad, FK_IdTelefono)  values ("
					+ +persona.getDni() + "," + "'" + persona.getCuil() + "'," + "'" + persona.getNombre() + "'," + "'"
					+ persona.getApellido() + "'," + "'" + persona.getSexo() + "'," + "('"
					+ persona.getFechaNacimiento() + "')," + "'" + persona.getDireccion() + "'," + "'"
					+ persona.getLocalidad() + "'," + "'" + persona.getProvincia() + "'," + "'" + persona.getMail()
					+ "'," + persona.getNacionalidad().getId() + "," + persona.getTelefono().getId() + ")";

			filas = st.executeUpdate(query);
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int update(DatosPersonales persona) {

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
			String query = "update tpint_grupo1_v2.datospersonales set " + "DNI='" + persona.getDni() + "'," + "Cuil='"
					+ persona.getCuil() + "'," + "Nombre='" + persona.getNombre() + "'," + "Apellido='"
					+ persona.getApellido() + "'," + "FechaNacimiento=('" + persona.getFechaNacimiento() + "'),"
					+ "Direccion='" + persona.getDireccion() + "'," + "Localidad='" + persona.getLocalidad() + "',"
					+ "Provincia='" + persona.getProvincia() + "'," + "Mail='" + persona.getMail() + "',"
					+ "FK_idTelefono='" + persona.getTelefono().getId() + "' where DNI=" + persona.getDni();

			filas = st.executeUpdate(query);
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public ArrayList<DatosPersonales> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;

		ArrayList<DatosPersonales> Ldatos = new ArrayList<DatosPersonales>();

		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT * FROM datospersonales ;");

			while (rs.next()) {
				DatosPersonales DatosPersonalesRs = new DatosPersonales();
				Nacionalidad NacionalidadRs = new Nacionalidad();
				Telefonos TelefonoRs = new Telefonos();

				NacionalidadRs.setNacionalidad(rs.getString("FK_Nacionalidad"));
				TelefonoRs.setNumero(rs.getString("FK_IdTelefono"));

				DatosPersonalesRs.setDni(rs.getInt("DNI"));
				DatosPersonalesRs.setCuil(rs.getDouble("Cuil"));
				DatosPersonalesRs.setNombre(rs.getString("Nombre"));
				DatosPersonalesRs.setApellido(rs.getString("Apellido"));
				DatosPersonalesRs.setSexo(rs.getString("sexo"));
				DatosPersonalesRs.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
				DatosPersonalesRs.setNacionalidad(NacionalidadRs);
				DatosPersonalesRs.setDireccion(rs.getString("Direccion"));
				DatosPersonalesRs.setLocalidad(rs.getString("Localidad"));
				DatosPersonalesRs.setProvincia(rs.getString("Provincia"));
				DatosPersonalesRs.setMail(rs.getString("Mail"));
				DatosPersonalesRs.setTelefono(TelefonoRs);

				Ldatos.add(DatosPersonalesRs);

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return Ldatos;

	}
	
	@Override
	public ArrayList<DatosPersonales> Fechas(String desde, String hasta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<DatosPersonales> ldp = new ArrayList<DatosPersonales>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM datospersonales where fechanacimiento >= ('" + desde + "') and fechanacimiento <=  ('" + hasta + "')" ;			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				DatosPersonales x = new DatosPersonales();
				x.setDni(rs.getInt("Dni"));
				x.setApellido(rs.getString("Apellido"));
				x.setNombre(rs.getString("Nombre"));
				x.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
				x.setSexo(rs.getString("Sexo"));
				x.setMail(rs.getString("Mail"));
			
				ldp.add(x);
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ldp;
	}

	@Override
	public DatosPersonales buscarDNI(int dni) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;

		DatosPersonales DatosPersonalesRs = new DatosPersonales();
		NacionalidadDaoImpl NacioImp = new NacionalidadDaoImpl();
		TelefonosDaoImpl TelImps = new TelefonosDaoImpl();
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM datospersonales where dni =" + dni);
			while (rs.next()) {
				DatosPersonalesRs.setDni(rs.getInt("dni"));
				DatosPersonalesRs.setCuil(rs.getDouble("Cuil"));
				DatosPersonalesRs.setNombre(rs.getString("Nombre"));
				DatosPersonalesRs.setApellido(rs.getString("Apellido"));
				DatosPersonalesRs.setSexo(rs.getString("sexo"));
				DatosPersonalesRs.setNacionalidad(NacioImp.buscarId(rs.getInt("FK_Nacionalidad")));
				DatosPersonalesRs.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
				DatosPersonalesRs.setDireccion(rs.getString("Direccion"));
				DatosPersonalesRs.setLocalidad(rs.getString("Localidad"));
				DatosPersonalesRs.setProvincia(rs.getString("Provincia"));
				DatosPersonalesRs.setMail(rs.getString("Mail"));
				DatosPersonalesRs.setTelefono(TelImps.buscarId(rs.getInt("FK_IdTelefono")));

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return DatosPersonalesRs;

	}

}
