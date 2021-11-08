package entidad;

public class Rol {
	
	public Rol() {}
	
	public Rol(String descripcion, boolean estado) { 
		Descripcion = descripcion;
		Estado = estado;
	}
	private int Id;
	private String Descripcion;
	private boolean Estado;
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	
}
