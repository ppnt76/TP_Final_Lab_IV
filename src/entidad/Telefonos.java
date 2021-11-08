package entidad;

public class Telefonos {
	public Telefonos(String numero) {
		Numero = numero;
	}

	public Telefonos() {
	}

	public Telefonos(Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}

	private int Id;
	
	private String Numero;

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
