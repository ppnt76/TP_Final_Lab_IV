package exceptions;

public class cuilException extends Exception {

	private static final long serialVersionUID = 1L;

	public cuilException() 
	{
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "El tamaño del cuil no es correcto, por favor, corregir!";
	}
	
	
	
}
