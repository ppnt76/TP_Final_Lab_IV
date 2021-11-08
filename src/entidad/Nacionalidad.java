package entidad;

public class Nacionalidad {
	
	private int Id;
	private String Nacionalidad;
	
	public Nacionalidad(int id, String nacionalidad) {
		super();
		Id = id;
		Nacionalidad = nacionalidad;
	}
	
	public Nacionalidad() {}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	};	
		
}
