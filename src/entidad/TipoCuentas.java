package entidad;

public class TipoCuentas {
	private int Id;
	private String Descripcion;
	
	public TipoCuentas(int id, String descripcion) {
		super();
		Id = id;
		Descripcion = descripcion;
	}

	public TipoCuentas() {
		super();
	}

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
	
}
