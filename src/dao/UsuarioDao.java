package dao;

import java.util.ArrayList;

import entidad.DatosPersonales;
import entidad.Usuario;

public interface UsuarioDao {
	public int insert(Usuario usuario);

	public int updateDNI(DatosPersonales DatosPersonales);

	public int updatePass(String passWord, String usuario);

	public int delete(String dni, String usuario);

	Usuario obtenerUnUsuario(int id, String NombreUsuario);

	Usuario logueo(String pass, String NombreUsuario);

	ArrayList<Usuario> readAll();
}
