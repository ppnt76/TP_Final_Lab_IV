package exceptions;

public class telefonoException extends Exception{

	private static final long serialVersionUID = 1L;

		public telefonoException()
		{
			
		}

		@Override
		public String getMessage() {

			return "El teléfono no puede contener letras, sólo numeros!";
		}
		
		
}
