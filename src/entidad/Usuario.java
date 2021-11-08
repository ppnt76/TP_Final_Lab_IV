package entidad;

public class Usuario {

	public Usuario(String nombreUsuario, String contraseña, Rol rol, DatosPersonales dp_DNI, boolean estado) {
		super();
		NombreUsuario = nombreUsuario;
		Contraseña = contraseña;
		this.rol = rol;
		this.dp_DNI = dp_DNI;
		Estado = estado;
	}

	public Usuario() {
	}

	private int Id;
	private String NombreUsuario;
	private String Contraseña;
	private Rol rol;
	private DatosPersonales dp_DNI;
	private boolean Estado;

	public void setId(int id) {
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public DatosPersonales getdp_DNI() {
		return dp_DNI;
	}

	public void setDatosPersonales(DatosPersonales dp_DNI) {
		this.dp_DNI = dp_DNI;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
