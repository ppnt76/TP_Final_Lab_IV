package entidad;
 
import java.time.LocalDate;

public class DatosPersonales {
	
	private int Dni;
	private Double Cuil;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private Nacionalidad Nacionalidad;
	private LocalDate FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private String Mail;
	private Telefonos Telefono;	
	
	public DatosPersonales(int dni, Double cuil, String nombre, String apellido, String sexo, Nacionalidad nacionalidad, String direccion, String localidad, String provincia, String mail,
			Telefonos telefono) { 
		Dni = dni;
		Cuil = cuil;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		Mail = mail;
		Telefono = telefono;
	}
	
	public DatosPersonales() {};
	
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public Double getCuil() {
		return Cuil;
	}

	public void setCuil(Double cuil) {
		Cuil = cuil;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}	
	
	public Nacionalidad getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(Nacionalidad nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getMail() {
		return Mail;
	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate dataFormateada) {
		FechaNacimiento =  dataFormateada;
	}

	public void setMail(String mail) {
		Mail = mail;
	}
	public Telefonos getTelefono() {
		return Telefono;
	}
	public void setTelefono(Telefonos telefono) {
		Telefono = telefono;
	}
	
	
	
	
}
