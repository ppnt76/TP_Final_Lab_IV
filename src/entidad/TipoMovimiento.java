package entidad;

public class TipoMovimiento {
	
	private int Id;
	private String Descripcion;

	public TipoMovimiento(int id, String descripcion) {
		Id = id;
		Descripcion = descripcion;
		}

	public TipoMovimiento() {
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
