package exceptions;

public class telefonoException extends Exception{

	private static final long serialVersionUID = 1L;

		public telefonoException()
		{
			
		}

		@Override
		public String getMessage() {

			return "El tel�fono no puede contener letras, s�lo numeros!";
		}
		
		
}
