package fr.eni.papeterie.bll;

public class BLLException extends Exception
{

	public BLLException()
	{
		
	}

	public BLLException(String message, Throwable exception)
	{
		super(message, exception);
	}

	public BLLException(String message)
	{
		super(message);
	}
	
	//Méthodes
		@Override
		public String getMessage() {
			StringBuffer sb = new StringBuffer("Couche BLL - ");
			sb.append(super.getMessage());
			
			return sb.toString() ;
		}
}
